package dragon.bakuman.iu.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    private static final String TAG = "ContactDbHelper";


    public static final String DATABASE_NAME = "contact_db";

    public static final int DATABASE_VERSION = 1;

    //query to create table
    public static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_NAME + "(" + ContactContract.ContactEntry.CONTACT_ID + " number, " + ContactContract.ContactEntry.NAME + " text, " + ContactContract.ContactEntry.EMAIL + " text);";

    public static final String DROP_TABLE = "drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper(Context context){
        
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "ContactDbHelper: Database created. ");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: TABLE is created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }
}
