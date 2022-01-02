package com.example.a9_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    Intent si;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tv = findViewById(R.id.text1);
        tv.setText("Author : Noa Shetrit\n\n" +
                "Description: hiii :)\n" +
                "the application gives you 3 options:\n" +
                "1 -  add 1 to the counter\n" +
                "2 - reset counter\n" +
                "3 - exit and save last results\n" +
                "this program work with Shared Preferences.\n" +
                "Have a gooood day ;))) " );
        tv.setTextSize(20);

    }

    public void back(View view) {
        /*close activity - when we press exit, it will close the whole application, even this activity*/
        finish();
    }
}