package com.example.ashishhooda.aaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radiobutton1 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radiobutton3 = (RadioButton) findViewById(R.id.radioButton4);
        final Button button = (Button) findViewById(R.id.button2);
        setSupportActionBar(toolbar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radiogroup.getCheckedRadioButtonId();
                if (radiobutton1 == (RadioButton) findViewById(selectedId)) {
                    Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                    startActivity(i);
                    //setContentView(R.layout.content_main3);
                } else {
                    if (radiobutton3 == (RadioButton) findViewById(selectedId)) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        // setContentView(R.layout.content_main);
                    }
                }
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
