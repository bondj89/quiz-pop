package dev.jbond.quizpop.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dev.jbond.quizpop.R;

public class QuestionFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.question_fragment, container,false);
    TextView questionText = view.findViewById(R.id.question_text);

    questionText.setText("Quiz Pop");

    return view;
  }
}
