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

    private enum Difficulty {
      EASY, MEDIUM, HARD;
    }

    private int Length;




  }