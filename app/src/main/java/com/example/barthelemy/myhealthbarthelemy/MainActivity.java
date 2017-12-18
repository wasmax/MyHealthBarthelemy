package com.example.barthelemy.myhealthbarthelemy;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.barthelemy.myhealthbarthelemy.Database.Database;
import com.example.barthelemy.myhealthbarthelemy.Model.Personne;
import com.example.barthelemy.myhealthbarthelemy.Provider.PersonneContentProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri URL = Uri.parse("content://com.example.barthelemy.myhealthbarthelemy/login/Wasmax");
        Cursor cursor = getContentResolver().query(URL, new String[]{"nomPersonne", "prenomPersonne"},null,null,null);
    }
}
