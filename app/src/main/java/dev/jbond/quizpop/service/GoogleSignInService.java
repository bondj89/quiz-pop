package dev.jbond.quizpop.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * The type Google sign in service.
 */
public class GoogleSignInService {

  private static Application applicationContext;

  private GoogleSignInClient client;
  private MutableLiveData<GoogleSignInAccount> account = new MutableLiveData<>();
  private MutableLiveData<Exception> exception = new MutableLiveData<>();

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        // .requestIdToken(...)
        .build();
    client = GoogleSignIn.getClient(applicationContext, options);
  }

  /**
   * Sets application context.
   *
   * @param applicationContext the application context
   */
  public static void setApplicationContext(Application applicationContext) {
    GoogleSignInService.applicationContext = applicationContext;
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets account.
   *
   * @return the account
   */
  public LiveData<GoogleSignInAccount> getAccount() {
    return account;
  }

  /**
   * Gets exception.
   *
   * @return the exception
   */
  public LiveData<Exception> getException() {
    return exception;
  }

  /**
   * Refresh task.
   *
   * @return the task
   */
  public Task<GoogleSignInAccount> refresh() {
    return client.silentSignIn()
        .addOnSuccessListener(this::update)
        .addOnFailureListener(this::update);
  }

  private void update(GoogleSignInAccount account) {
    this.account.setValue(account);
    this.exception.setValue(null);
  }

  private void update(Exception ex) {
    account.setValue(null);
    exception.setValue(ex);
  }

  /**
   * Start sign in.
   *
   * @param activity    the activity
   * @param requestCode the request code
   */
  public void startSignIn(Activity activity, int requestCode) {
    update((GoogleSignInAccount) null);
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Complete sign in task.
   *
   * @param data the data
   * @return the task
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      account.setValue(task.getResult(ApiException.class));
    } catch (ApiException e) {
      update(e);
    }
    return task;
  }

  /**
   * Sign out task.
   *
   * @return the task
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((account) -> update((GoogleSignInAccount) null));
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }



}
