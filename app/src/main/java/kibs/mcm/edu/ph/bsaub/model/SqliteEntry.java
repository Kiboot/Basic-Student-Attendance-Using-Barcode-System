package kibs.mcm.edu.ph.bsaub.model;

public class SqliteEntry {
    public static final String TABLE_NAME = "studtbl";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SID = "sid";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private int sid;
    private String studname;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_SID + " INTEGER,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public SqliteEntry() {
    }

    public SqliteEntry(int id, int sid, String name, String timestamp) {
        this.id = id;
        this.sid = sid;
        this.studname = name;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public int getSId() {
        return sid;
    }

    public String getSname() {
        return studname;
    }

    public void setName(String name) {
        this.studname = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSId(int sid) {
        this.sid = sid;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
