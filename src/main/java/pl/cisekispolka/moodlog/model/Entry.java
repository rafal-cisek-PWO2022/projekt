package pl.cisekispolka.moodlog.model;

import java.sql.Timestamp;
import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "entry")
public class Entry {
    @DatabaseField(generatedId = true)
    private UUID id;
    @DatabaseField(foreign = true)
    private Day day_id;
    @DatabaseField
    private Timestamp date_entered;
    @DatabaseField
    private int mood_score;
    @DatabaseField
    private String comment;

    public Timestamp getDate_entered() {
        return date_entered;
    }
    public void setDate_entered(Timestamp date_entered) {
        this.date_entered = date_entered;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Day getDay_id() {
        return day_id;
    }
    public void setDay_id(Day day_id) {
        this.day_id = day_id;
    }
    public int getMood_score() {
        return mood_score;
    }
    public void setMood_score(int mood_score) {
        this.mood_score = mood_score;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
