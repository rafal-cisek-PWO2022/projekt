package pl.cisekispolka.moodlog.model;

import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "emotion")
public class Emotion {
    private enum EmotionType {
        POSITIVE,
        NEGATIVE,
        NEUTRAL;
    }

    @DatabaseField(generatedId = true)
    private UUID id;
    @DatabaseField
    private String name;
    @DatabaseField
    private EmotionType type;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public EmotionType getType() {
        return type;
    }
    public void setType(EmotionType type) {
        this.type = type;
    }


}
