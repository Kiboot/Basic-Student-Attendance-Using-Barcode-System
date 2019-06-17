package kibs.mcm.edu.ph.bsaub.model;

public class Note {
    public static final String TABLE_NAME = "stud_tbl";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String studname;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Note() {
    }

    public Note(int id, String name, String timestamp) {
        this.id = id;
        this.studname = name;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return studname;
    }

    public void setNote(String name) {
        this.studname = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
