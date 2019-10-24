## Data Definition Language (DDL) for data model

``` sql
CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key`  TEXT,
    `high_score` INTEGER                           NOT NULL
);

CREATE UNIQUE INDEX `index_User_oauth_key` ON `User` (`oauth_key`);

CREATE INDEX `index_User_high_score` ON `User` (`high_score`);

CREATE TABLE IF NOT EXISTS `Answer`
(
    `answer_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `question_id` INTEGER                           NOT NULL,
    `text`        TEXT,
    `correct`     INTEGER                           NOT NULL,
    FOREIGN KEY (`question_id`) REFERENCES `Question` (`question_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX `index_Answer_question_id` ON `Answer` (`question_id`);

CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `difficulty` TEXT,
    `user_id`    INTEGER                           NOT NULL,
    `score`      INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX `index_Game_score` ON `Game` (`score`);

CREATE TABLE IF NOT EXISTS `Question`
(
    `question_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `category`      TEXT,
    `type`          TEXT,
    `difficulty`    TEXT                              NOT NULL,
    `question_text` TEXT                              NOT NULL,
    `correct`       INTEGER
);





```
[`ddl.sql`](ddl.sql) 