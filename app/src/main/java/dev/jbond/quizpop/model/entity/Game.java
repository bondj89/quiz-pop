package dev.jbond.quizpop.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Category.class,
            childColumns = "category_id",
            parentColumns = "category_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)

public class Game {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "game_id")
    private long id;

    @NonNull
    @ColumnInfo(index = true)
    private Date created = new Date();

    @ColumnInfo(name = "category_id", index = true)
    private long categoryId;

    public long getId() {
      return id;
    }

    public void categoryId(long id) {
      this.id = id;
    }

    @NonNull
    public Date getCreated() {
      return created;
    }

    public void setCreated(@NonNull Date created) {
      this.created = created;
    }

    public long getcategoryId() {
      return categoryId;
    }

    public void setcategoryId(long categoryId) {
      this.categoryId = categoryId;
    }
  }