package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "category_id")
  private long id;
}
