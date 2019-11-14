package dev.jbond.quizpop.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import dev.jbond.quizpop.MainViewModel;
import dev.jbond.quizpop.R;
import dev.jbond.quizpop.service.GoogleSignInService;

public class MainActivity extends AppCompatActivity {

  private ViewPager viewPager;

  private TextView mTextMessage;
  private Button randomButton;

  private String url = "https://opentdb.com/api.php?amount=25";
  private Handler handler = new Handler();
  private int delay = 5000;
  private int page = 0;


  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_home:
          mTextMessage.setText(R.string.title_home);
          return true;
        case R.id.navigation_dashboard:
          mTextMessage.setText(R.string.title_dashboard);
          return true;
        case R.id.navigation_notifications:
          mTextMessage.setText(R.string.title_notifications);
          return true;
      }
      return false;
    }
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    viewPager = findViewById(R.id.view_pager);
//    mTextMessage = findViewById(R.id.message);
    randomButton = findViewById(R.id.randomButton);
//    BottomNavigationView navigation = findViewById(R.id.navigation);
//    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    randomButton.setOnClickListener(view -> {
      viewModel.refreshRandom();
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.options, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.sign_out:
        signOut();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  private void signOut() {
    GoogleSignInService.getInstance().signOut()
        .addOnCompleteListener((task) -> {
          Intent intent = new Intent(this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        });
  }

}
