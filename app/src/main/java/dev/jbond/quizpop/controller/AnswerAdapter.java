package dev.jbond.quizpop.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dev.jbond.quizpop.R;
import dev.jbond.quizpop.model.entity.Answer;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.MyViewHolder> {

  private final Context context;
  private List<Answer> answers;
  private final OnClickListener listener;
  private boolean correctAnswerHighlighted;

  public AnswerAdapter(Context context, OnClickListener listener, List<Answer> answers ) {
    this.answers = answers;
    this.context = context;
    this.listener = listener;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    MyViewHolder viewHolder = new MyViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.bind(position, answers.get(position));

  }

  public boolean isCorrectAnswerHighlighted() {
    return correctAnswerHighlighted;
  }

  public void setCorrectAnswerHighlighted(boolean correctAnswerHighlighted) {
    this.correctAnswerHighlighted = correctAnswerHighlighted;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return answers.size();
  }


  public interface OnClickListener {
    void onClick (int position, Answer answer);
  }

  class MyViewHolder extends RecyclerView.ViewHolder {

    // each data item is just a string in this case

    private View itemView;
    private Answer answer;
    private TextView textView;

    private MyViewHolder(View v) {
      super(v);
      itemView = v;
      textView = v.findViewById(R.id.list_item_text);
    }

    private void bind(int position, Answer answer) {
      textView.setText(answer.getText());
      this.answer = answer;
      if (isCorrectAnswerHighlighted()) {
        itemView.setBackgroundColor(answer.isCorrect() ? Color.GREEN : Color.TRANSPARENT);
      }
      itemView.setOnClickListener((v) -> {
        listener.onClick(position, answer);
        setCorrectAnswerHighlighted(true);
      });
    }
  }


}
