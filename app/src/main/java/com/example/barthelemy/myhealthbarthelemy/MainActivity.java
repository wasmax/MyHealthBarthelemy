package com.example.barthelemy.myhealthbarthelemy;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.barthelemy.myhealthbarthelemy.Database.Database;
import com.example.barthelemy.myhealthbarthelemy.Provider.PersonneContentProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL = "content://com.example.barthelemy.myhealthbarthelemy/persons/2";

        Intent i = new Intent(URL);
        startActivity(i);
    }
}
