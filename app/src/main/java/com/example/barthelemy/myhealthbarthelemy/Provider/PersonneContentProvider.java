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

import com.example.barthelemy.myhealthbarthelemy.Database.Database;

import java.util.HashMap;

/**
 * Created by Max on 17/11/2017.
 */

public class PersonneContentProvider extends ContentProvider{
    private SQLiteDatabase db;
    static final String PERSONS_TABLE_NAME = "personne";

    static final String PROVIDER_NAME = "com.example.barthelemy.myhealthbarthelemy";
    static final String URL = "content://" + PROVIDER_NAME + "/person";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "id";

    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;

    static final int PERSONS_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "persons/#", PERSONS_ID);
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

            switch (uriMatcher.match(uri)) {

                case PERSONS_ID:
                    qb.appendWhere( _ID + "=" + uri.getPathSegments().get(1));
                    break;
            }

            if (sortOrder == null || sortOrder == ""){
                sortOrder = "id";
            }

            Cursor c = qb.query(db,	projection,	selection,
                    selectionArgs,null, null, sortOrder);

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
