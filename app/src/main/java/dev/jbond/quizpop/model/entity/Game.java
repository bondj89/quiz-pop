package dev.jbond.quizpop.model.entity;


import androidx.room.Entity;
import androidx.room.ForeignKey;

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

}