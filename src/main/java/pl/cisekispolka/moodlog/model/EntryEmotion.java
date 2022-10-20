package pl.cisekispolka.moodlog.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "entry_emotion")
public class EntryEmotion {
    @DatabaseField(foreign = true)
    private Emotion emotion_id;
    @DatabaseField(foreign = true)
    private Entry entry_id;
}
