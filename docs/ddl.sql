CREATE TABLE IF NOT EXISTS `User` (`user_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `last_name` TEXT COLLATE NOCASE, `first_name` TEXT COLLATE NOCASE, `email` TEXT COLLATE NOCASE, `high_score` INTEGER NOT NULL);

CREATE UNIQUE INDEX `index_User_last_name_first_name` ON `User` (`last_name`, `first_name`);

