package kibs.mcm.edu.ph.bsaub.model;

public class SqliteEntry {
    public static final String TABLE_NAME = "studtbl";
    public static final String COLUMN_ID = "entryid";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SID = "studid";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String studname;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_SID + " INTEGER"
                    + ")";

    public SqliteEntry() {
    }

    public SqliteEntry(int id, String name, String timestamp, int sid) {
        this.id = id;
        this.studname = name;
        this.timestamp = timestamp;
        this.sid = sid;
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
