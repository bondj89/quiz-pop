package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "opentdp_id", unique = true)
)
public class Category {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "category_id")
  private long id;

  private String name;

}
