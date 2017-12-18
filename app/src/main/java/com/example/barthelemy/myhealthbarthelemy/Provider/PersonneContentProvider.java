package com.example.barthelemy.myhealthbarthelemy.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;

import com.example.barthelemy.myhealthbarthelemy.Database.Database;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Max on 17/11/2017.
 */

public class PersonneContentProvider extends ContentProvider{
    private SQLiteDatabase db;
    static final String PERSONS_TABLE_NAME = "personne";

    static final String PROVIDER_NAME = "com.example.barthelemy.myhealthbarthelemy";

    static final String _ID = "idPersonne";
    static final String _LOGIN = "loginPersonne";

    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;

    static final int PERSONS_ID = 2;
    static final int PERSONS_LOGIN = 3;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "persons/#", PERSONS_ID);
        uriMatcher.addURI(PROVIDER_NAME, "login/*", PERSONS_LOGIN);
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        Database dbHelper = new Database(context);

        db = dbHelper.getWritableDatabase();

        return (db == null)? false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
            qb.setTables(PERSONS_TABLE_NAME);

        selectionArgs = new String[1];

            int match =  uriMatcher.match(uri);

            switch (match) {

                case PERSONS_ID:
                    qb.appendWhere( _ID + "=?");
                    selectionArgs[0] =  uri.getPathSegments().get(1);
                    break;

                case PERSONS_LOGIN:
                    qb.appendWhere( _LOGIN + "=?");
                    selectionArgs[0] =  uri.getPathSegments().get(1);
                    break;
            }

            if(match == -1){
                return null;
            }

            if (sortOrder == null || sortOrder == ""){
                sortOrder = "idPersonne";
            }

            Cursor c = qb.query(db,	projection,	selection, selectionArgs, null, null, sortOrder);

            c.setNotificationUri(getContext().getContentResolver(), uri);
            return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
