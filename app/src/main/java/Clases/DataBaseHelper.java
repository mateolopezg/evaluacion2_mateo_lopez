package Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "cliente.db";
    public static final String TABLE_NAME = "cliente_table";
    public static final String COL_1 = "CODIGO";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "SALARIO";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, CODIGO TEXT, NOMBRE TEXT, SALARIO TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String codigo, String nombre, String sueldo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, codigo);
        cv.put(COL_2, nombre);
        cv.put(COL_3, sueldo);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from cliente_table", null);
        return res;
    }

    public boolean update(String codigo, String nombre, String sueldo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, codigo);
        cv.put(COL_2, nombre);
        cv.put(COL_3, sueldo);
        db.update(TABLE_NAME, cv, "CODIGO = ?", new String[]{codigo});
        return true;
    }

    public Integer delete(String codigo) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "CODIGO = ?", new String[]{codigo});
    }
}
