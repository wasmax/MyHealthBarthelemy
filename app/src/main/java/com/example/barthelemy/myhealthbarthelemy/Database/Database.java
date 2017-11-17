package com.example.barthelemy.myhealthbarthelemy.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Max on 17/11/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myhealth.db";

    public Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Personne ( "
                + "idPersonne INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ," +
                " nomPersonne VARCHAR NOT NULL ," +
                " prenomPersonne VARCHAR NOT NULL ," +
                " agePersonne INTEGER NOT NULL ," +
                " poidsPersonne INTEGER NOT NULL ," +
                " dateMajPersonne DATE NOT NULL ," +
                " loginPersonne VARCHAR NOT NULL );");

        Date currentTime = Calendar.getInstance().getTime();

        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(1,'Meiller','Kévin',34,120,"+currentTime.getTime()+",'kéké'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(2,'Lafont','Antoine',24,75,"+currentTime.getTime()+",'manène'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(3,'Daclin','Vincent',22,75,"+currentTime.getTime()+",'Jura'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(4,'Bidault','Guillaume',72,33,"+currentTime.getTime()+",'StringJohanne'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(5,'Dereims','Léonard',24,93,"+currentTime.getTime()+",'Zidane'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(6,'Walter','Maxime',23,65,"+currentTime.getTime()+",'MisterWalt'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(7,'Barthélémy','Maxime',23,90,"+currentTime.getTime()+",'Wasmax'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(8,'Cloup','Valentin',23,76,"+currentTime.getTime()+",'Jimmy'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(9,'Kiene','Benjamin',22,60,"+currentTime.getTime()+",'Benny'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(10,'Manca','Ruslan',22,75,"+currentTime.getTime()+",'Exelion'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(11,'Fernandez','Thomas',22,67,"+currentTime.getTime()+",'Trouelle'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(12,'Revenu','Simon',22,78,"+currentTime.getTime()+",'KFC'); ");
        sqLiteDatabase.execSQL("INSERT INTO \"Personne\" VALUES(13,'Potherat','Léonard',31,92,"+currentTime.getTime()+",'DjLeop'); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}