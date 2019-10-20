package dev.jbond.quizpop.model.entity;

import android.support.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = {"last_name", "first_name"}, unique = true)
)
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "last_name", collate = ColumnInfo.NOCASE)
  private String lastName;

  @NonNull
  @ColumnInfo(name = "first_name", collate = ColumnInfo.NOCASE)
  private String firstName;

  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  private String email;

  @ColumnInfo(index = true,name = "high_score")
  private long highScore;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getLastName() {
    return lastName;
  }

  public void setLastName(@NonNull String lastName) {
    this.lastName = lastName;
  }

  @NonNull
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(@NonNull String firstName) {
    this.firstName = firstName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getHighScore() {
    return highScore;
  }

  public void setHighScore(long highScore) {
    this.highScore = highScore;
  }
}