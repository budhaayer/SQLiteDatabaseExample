package csitmnr.sqlitedatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE_NO TEXT,EMAIL TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name,String phone_no,String email){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME",name);
        contentValues.put("PHONE_NO",phone_no);
        contentValues.put("EMAIL",email);

        long result = sqLiteDatabase.insertOrThrow(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }
    public Cursor searchData(String phone_no){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String query = "SELECT * FROM "+TABLE_NAME+" WHERE PHONE_NO ='"+phone_no+"'";

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        return cursor;

    }
}
