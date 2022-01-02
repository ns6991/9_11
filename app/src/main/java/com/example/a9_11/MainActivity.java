package com.example.a9_11;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Noa Shetrit ns6991@bs.amalnet.k12.il
 * @version 1.1
 * @since 2/1/2022
 * try and practice Activity Lifecycle
 *  using a Shared Preferences file
 */

public class MainActivity extends AppCompatActivity {
    int counter;
    String str;
    EditText et;
    TextView tv;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        tv = findViewById(R.id.num);
        et = findViewById(R.id.et);
        si = new Intent(this, credits.class);


    }

    @Override
    public void onStart() {
        super.onStart();
        settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        counter = settings.getInt("COUNTER", 0);
        str = settings.getString("STR", "");
        tv.setText(counter + "");
        tv.setTextSize(25);

        et.setText(str + "");


    }


    @Override
    public void onStop() {
        super.onStop();
        settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        editor = settings.edit();
        editor.putInt("COUNTER", counter); //write to file
        editor.putString("STR", str);
        editor.commit(); //close
    }


    public void plus1(View view) {
        /**
        * add 1 to count and set it to text view*/
        counter++;
        tv.setText(counter + "");
        tv.setTextSize(25);

    }


    public void reset(View view) {
        /**
        * reset the counter*/
        counter = 0;
        tv.setText(0 + "");
        tv.setTextSize(25);
    }


    public void close(View view) {
        /**
         * close and exit the application.
         */
        if(et.getText().equals(null)) str = " ";
        else str = et.getText().toString();
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * save string and go to credits activity*/
        if(et.getText().equals(null)) str = " ";
        else str = et.getText().toString();
        startActivity(si);
        return true;
    }
}