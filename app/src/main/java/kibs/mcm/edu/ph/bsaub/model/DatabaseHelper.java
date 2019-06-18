package kibs.mcm.edu.ph.bsaub.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import kibs.mcm.edu.ph.bsaub.model.SqliteEntry;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "attendance_db";

    public DatabaseHelper(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);}
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(SqliteEntry.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + SqliteEntry.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertNote(String note) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(SqliteEntry.COLUMN_NAME, note);

        // insert row
        long id = db.insert(SqliteEntry.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public SqliteEntry getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(SqliteEntry.TABLE_NAME,
                new String[]{SqliteEntry.COLUMN_ID, SqliteEntry.COLUMN_NAME, SqliteEntry.COLUMN_TIMESTAMP},
                SqliteEntry.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        SqliteEntry note = new SqliteEntry(
                cursor.getInt(cursor.getColumnIndex(SqliteEntry.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(SqliteEntry.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(SqliteEntry.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<SqliteEntry> getAllNotes() {
        List<SqliteEntry> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + SqliteEntry.TABLE_NAME + " ORDER BY " +
                SqliteEntry.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SqliteEntry note = new SqliteEntry();
                note.setId(cursor.getInt(cursor.getColumnIndex(SqliteEntry.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(SqliteEntry.COLUMN_NAME)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(SqliteEntry.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + SqliteEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(SqliteEntry note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SqliteEntry.COLUMN_NAME, note.getNote());

        // updating row
        return db.update(SqliteEntry.TABLE_NAME, values, SqliteEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(SqliteEntry note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SqliteEntry.TABLE_NAME, SqliteEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
