package com.example.ashishhooda.aaa;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {
    MainActivity mainactivity = new MainActivity();

    public void RegisterUser(View view)
    {    EditText team = (EditText) findViewById(R.id.editText0);
        EditText firstname = (EditText) findViewById(R.id.editText);
        EditText firstentry = (EditText) findViewById(R.id.editText1);
        EditText secondname = (EditText) findViewById(R.id.editText2);
        EditText secondentry = (EditText) findViewById(R.id.editText3);
        final String teamname = team.getText().toString();
        final String first_name = firstname.getText().toString();
        final String first_entry = firstentry.getText().toString();
        final String second_name = secondname.getText().toString();
        final String second_entry = secondentry.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(DownloadManager.Request.Method.POST, "http://agni.iitd.ernet.in/cop290/assign0/register/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }

                }) {

            @Override
            protected HashMap<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("teamname", teamname);
                params.put("entry1", first_entry);
                params.put("name1", first_name);
                params.put("entry2", second_entry);
                params.put("name2", second_name);
                params.put("entry3", "");
                params.put("name3", "");
                return params;
            }


        };

        requestQueue.add(stringRequest);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText firstname = (EditText) findViewById(R.id.editText);
        final EditText firstentry = (EditText) findViewById(R.id.editText1);
        final EditText secondname = (EditText) findViewById(R.id.editText2);
        final EditText secondentry = (EditText) findViewById(R.id.editText3);
        final TextView textview2 =(TextView)findViewById(R.id.textView2);
        final TextView textview3 =(TextView)findViewById(R.id.textView3);
        final TextView textview4 =(TextView)findViewById(R.id.textView4);
        final TextView textview5 =(TextView)findViewById(R.id.textView5);
        firstname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                               public void onFocusChange(View v, boolean hasFocus) {
                                                   if (!hasFocus) {
                                                       String name = firstname.getText().toString();
                                                       if (!(mainactivity.checkname(name))) {
                                                           textview2.setText("wrong name format");
                                                       } else {
                                                           textview2.setText("");
                                                       }
                                                   }
                                               }
                                           }
        );
        secondname.setOnFocusChangeListener(new View.OnFocusChangeListener()
                                            {
                                                public void onFocusChange(View v, boolean hasFocus)
                                                {
                                                    if (!hasFocus)
                                                    {
                                                        String name = secondname.getText().toString();
                                                        if (!(mainactivity.checkname(name)))
                                                        {
                                                            textview4.setText("wrong name format");
                                                        }
                                                        else
                                                        {
                                                            textview4.setText("");
                                                        }
                                                    }
                                                }
                                            }
        );
        firstentry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                                public void onFocusChange(View v, boolean hasFocus)
                                                {
                                                    if (!hasFocus)
                                                    {
                                                        String entry = firstentry.getText().toString();
                                                        if (!(mainactivity.checkentrynumber(entry)))
                                                        {
                                                            textview3.setText("wrong entrynumber format");
                                                        }
                                                        else
                                                        {
                                                            textview3.setText("");
                                                        }
                                                    }
                                                }}
        );

        secondentry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                                 public void onFocusChange(View v, boolean hasFocus)
                                                 {
                                                     if (!hasFocus)
                                                     {
                                                         String entry = secondentry.getText().toString();
                                                         if (!(mainactivity.checkentrynumber(entry)))
                                                         {
                                                             textview5.setText("wrong entrynumber format");
                                                         }
                                                         else
                                                         {
                                                             textview5.setText("");
                                                         }
                                                     }
                                                 }}
        );
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
