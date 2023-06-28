import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BaseDatosSQLite extends SQLiteOpenHelper {

    protected SQLiteDatabase db;

    public BaseDatosSQLite(@Nullable Context context) {
        super(context, "notes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table notes (id integer primary key autoincrement not null, title text, priority int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notes");
    }

    public void insertNote(String title, int priority) {
        db = this.getReadableDatabase();
        db.execSQL("INSERT INTO notes (title, priority) VALUES ('" + title + "', " + priority + ")");
    }

    public void deleteAllNotes() {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notes");
    }

    public void deleteNote(int id) {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notes WHERE id=" + id);
    }

    public void updateNote(int id, String title, int priority) {
        db = this.getWritableDatabase();
        db.execSQL("UPDATE notes SET title='" + title + "', priority=" + priority + "  WHERE id=" + id);
    }

    public int numberOfNotes() {
        int num = 0;
        db = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(db, "notes");
        return num;
    }

    public ArrayList<String> getAllNotes() {
        ArrayList<String> filas = new ArrayList<String>();
        Cursor res = null;
        String contenido = "";
        if (numberOfNotes() > 0) {
            db = this.getReadableDatabase();
            res = db.rawQuery("SELECT * FROM notes ORDER BY priority ASC", null);
            res.moveToFirst();
            while (res.isAfterLast() == false) {
                contenido = res.getInt(res.getColumnIndex("id")) + ".-" + res.getString(res.getColumnIndex("title"));
                filas.add(contenido);
                res.moveToNext();
            }
        }
        return filas;
    }

    public Note getNote(int id) {

        Note n = null;
        Cursor res = null;
        String contenido = "";

        if (numberOfNotes() > 0) {

            db = this.getReadableDatabase();
            res = db.rawQuery("SELECT * FROM notes WHERE id=" + id + " ORDER BY priority ASC", null);
            res.moveToFirst();

            while (res.isAfterLast() == false) {

                //contenido = res.getInt(res.getColumnIndex("id")) + ".-" + res.getString(res.getColumnIndex("title"));
                n = new Note(res.getInt(res.getColumnIndex("id")), res.getString(res.getColumnIndex("title")), res.getInt(res.getColumnIndex("priority")));
                res.moveToNext();
            }
        }
        return n;
    }


    public void close() {
        db.close();
    }
}
