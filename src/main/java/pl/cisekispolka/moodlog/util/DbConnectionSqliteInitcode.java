package pl.cisekispolka.moodlog.util;

public class DbConnectionSqliteInitcode {
    static String code() {
        return """
            CREATE TABLE IF NOT EXISTS `day` (
            `id` uuid PRIMARY KEY NOT NULL,
            `date` date,
            `notes` text
            );

            CREATE TABLE IF NOT EXISTS `emotion` (
            `id` uuid PRIMARY KEY NOT NULL,
            `name` varchar(255),
            `type` varchar(255)
            );

            CREATE TABLE IF NOT EXISTS `entry` (
            `id` uuid PRIMARY KEY NOT NULL,
            `day_id` uuid NOT NULL,
            `date_entered` datetime,
            `mood_score` int,
            `comment` text,
            FOREIGN KEY (`day_id`) REFERENCES `day`(`id`)
            );

            CREATE TABLE IF NOT EXISTS `emotion_entry` (
            `emotion_id` uuid NOT NULL,
            `entry_id` uuid NOT NULL,
            FOREIGN KEY (`emotion_id`) REFERENCES `emotion`(`id`),
            FOREIGN KEY (`entry_id`) REFERENCES `entry`(`id`)
            );
            """;
    }
}
