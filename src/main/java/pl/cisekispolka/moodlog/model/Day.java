package pl.cisekispolka.moodlog.model;

import java.util.Date;
import java.util.UUID;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "day")
public class Day {
    @DatabaseField(generatedId = true)
    private UUID id;
    @DatabaseField(dataType = DataType.DATE)
    private Date date;
    @DatabaseField
    private String notes;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
