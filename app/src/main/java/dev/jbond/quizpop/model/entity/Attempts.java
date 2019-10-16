package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Game.class,
            childColumns = "game_id",
            parentColumns = "game_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Attempts {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "attempts_id")
  private long id;

}
