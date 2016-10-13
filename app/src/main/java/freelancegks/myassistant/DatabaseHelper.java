package freelancegks.myassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SriBhargavi on 13-10-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int Database_version = 1;
    private static final String Database_Name = "Registration.db";
    private static final String Table_Name= "Registration";
    private static final String Column_ID = "id";
    private static final String Column_Name= "name";
    private static final String Column_UName= "username";
    private static final String Column_Email= "email";
    private static final String Column_Pass= "passwords";
    SQLiteDatabase db;

private static final String  Table_Create="create  table "+Table_Name+ " (id integer primary key not null ,"+ "name text not null , username text not null, email text not null, passwords text not null);";

    public DatabaseHelper(Context context){
        super(context, Database_Name, null, Database_version);
    }
    @Override
    public void  onCreate(SQLiteDatabase db){
        db.execSQL(Table_Create);
        this.db = db;
    }

    public void deletetable(SQLiteDatabase db){
        db.execSQL("delete from "+ Table_Name);
        this.db=db;

    }

     public void insertcontact(Contacts C){
        db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

         String query = "Select * from Registration";
         Cursor cursor = db.rawQuery(query,null);

         int count = cursor.getCount();
         values.put(Column_ID,count);

        values.put(Column_Name,C.getName());
        values.put(Column_UName,C.getUname());
        values.put(Column_Email,C.getEmail());
        values.put(Column_Pass,C.getPass());

        db.insert(Table_Name,null,values);

    }

    public String searchpass(String EmailAddr){
        db = this.getReadableDatabase();

        String query = "select email , passwords from "+Table_Name;
        Cursor cursor = db.rawQuery(query , null);

        String a,b;
        b="not found";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                Log.d("a",a.toString());
                if (a.equals(EmailAddr)){
                    b = cursor.getString(1);
                    Log.d("b",b.toString());
                    break;
                }
            }while(cursor.moveToNext());
        }
        Log.d("b final",b.toString());
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "Drop table if exists "+Table_Name;
        db.execSQL(query);
        this.onCreate(db);
    }

}

