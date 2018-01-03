package com.example.ashishhooda.aaa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public void RegisterUser(View view)
    {
        EditText txtname0 = (EditText) findViewById(R.id.editText0);
        final String name0 = txtname0.getText().toString();
        EditText txtname = (EditText) findViewById(R.id.editText);
        final String name = txtname.getText().toString();
        EditText txtname1 = (EditText) findViewById(R.id.editText1);
        final String name1 = txtname1.getText().toString();
        EditText txtname2 = (EditText) findViewById(R.id.editText2);
        final String name2 = txtname2.getText().toString();
        EditText txtname3 = (EditText) findViewById(R.id.editText3);
        final String name3 = txtname3.getText().toString();
        EditText txtname4 = (EditText) findViewById(R.id.editText4);
        final String name4 = txtname4.getText().toString();
        EditText txtname5 = (EditText) findViewById(R.id.editText5);
        final String name5 = txtname5.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://agni.iitd.ernet.in/cop290/assign0/register/",
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
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("teamname", name0);
                params.put("entry1", name);
                params.put("name1", name1);
                params.put("entry2", name2);
                params.put("name2", name3);
                params.put("entry3", name4);
                params.put("name3", name5);
                return params;
            }


        };

        requestQueue.add(stringRequest);
    }

    public boolean checkname(String name)
    {
        boolean status = true;
        for(int i = 0;i<name.length();i++)
        {

            int nameint = (int)name.charAt(i);
            if(!((nameint>64 && nameint<91)||(nameint>96 && nameint <123)||nameint ==32))
            {
                status = false;
            }
        }

        return status;
    }
    public boolean checkentrynumber(String entrynumber)
    {
        boolean status = true;
        if(entrynumber.equals(""))
        {
            status = true;
        }
        else {
            if (entrynumber.length() != 11) {
                status = false;
            }
            else {
                if (!(entrynumber.substring(0, 4).equals("2011") || entrynumber.substring(0, 4).equals("2012") || entrynumber.substring(0, 4).equals("2013") || entrynumber.substring(0, 4).equals("2014") || entrynumber.substring(0, 4).equals("2015"))) {
                    status = false;
                }
                switch (entrynumber.substring(4, 7)) {
                    case "cs1":
                        break;
                    case "ee1":
                        break;
                    case "ee3":
                        break;
                    case "mt1":
                        break;
                    case "me1":
                        break;
                    case "me2":
                        break;
                    case "ph1":
                        break;
                    case "tt1":
                        break;
                    case "bb1":
                        break;
                    case "bb5":
                        break;
                    case "cs5":
                        break;
                    case "ch1":
                        break;
                    case "ch7":
                        break;
                    case "ch5":
                        break;
                    case "mt6":
                        break;
                    case "ce1":
                        break;
                    default:
                        status = false;
                        break;
                }
                for (int i = 7; i < 11; i++) {

                    int nameint = (int) entrynumber.charAt(i);
                    if (!(nameint > 47 && nameint < 58)) {
                        status = false;
                    }
                }
            }
        }
        return status;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText firstname = (EditText) findViewById(R.id.editText);
        final EditText firstentry = (EditText) findViewById(R.id.editText1);
        final EditText secondname = (EditText) findViewById(R.id.editText2);
        final EditText secondentry = (EditText) findViewById(R.id.editText3);
        final EditText thirdname = (EditText) findViewById(R.id.editText4);
        final EditText thirdentry = (EditText) findViewById(R.id.editText5);
        final TextView textview2 =(TextView)findViewById(R.id.textView2);
        final TextView textview3 =(TextView)findViewById(R.id.textView3);
        final TextView textview4 =(TextView)findViewById(R.id.textView4);
        final TextView textview5 =(TextView)findViewById(R.id.textView5);
        final TextView textview6=(TextView)findViewById(R.id.textView6);
        final TextView textview7 =(TextView)findViewById(R.id.textView7);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                               public void onFocusChange(View v, boolean hasFocus) {
                                                   if (!hasFocus) {
                                                       String name = firstname.getText().toString();
                                                       if (!(checkname(name))) {
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
                                                        if (!(checkname(name)))
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
        thirdname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                               public void onFocusChange(View v, boolean hasFocus)
                                               {
                                                   if (!hasFocus)
                                                   {
                                                       String name = thirdname.getText().toString();
                                                       if (!(checkname(name)))
                                                       {
                                                           textview6.setText("wrong name format");
                                                       }
                                                       else
                                                       {
                                                           textview6.setText("");
                                                       }
                                                   }
                                               }}
        );
        firstentry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                                public void onFocusChange(View v, boolean hasFocus)
                                                {
                                                    if (!hasFocus)
                                                    {
                                                        String entry = firstentry.getText().toString();
                                                        if (!(checkentrynumber(entry)))
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
                                                         if (!(checkentrynumber(entry)))
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
        thirdentry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                                public void onFocusChange(View v, boolean hasFocus)
                                                {
                                                    if (!hasFocus)
                                                    {
                                                        String entry = thirdentry.getText().toString();
                                                        if (!(checkentrynumber(entry)))
                                                        {
                                                            textview7.setText("wrong entrynumber format");
                                                        }
                                                        else
                                                        {
                                                            textview7.setText("");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
