package dev.jbond.quizpop.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import dev.jbond.quizpop.MainViewModel;
import dev.jbond.quizpop.R;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.pojo.QuestionWithAnswers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionFragment extends Fragment {

  View view;
  RecyclerView recyclerView;
  AnswerAdapter adapter;
  MainViewModel viewModel;
  QuestionWithAnswers question;
  TextView questionText;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.question_fragment, container, false);
    questionText = view.findViewById(R.id.question_text);


    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    viewModel.getRandomQuestion();
    viewModel.getRandomQuestion().observe(this, (question) -> {
      if (question != null) {
        setUpUI(question);
      }
    });

  }

  private void setUpUI(QuestionWithAnswers question) {

    questionText.setText(question.getText());
  List<Answer> answers = new ArrayList<>(question.getAnswers());

    Collections.shuffle(answers);
    recyclerView = view.findViewById(R.id.recycler_view);
    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    //recyclerView.setHasFixedSize(true);
    // use a linear layout manager
    // specify an adapter (see also next example)
    adapter = new AnswerAdapter(answers, getContext());
    recyclerView.setAdapter(adapter);
  }


}
