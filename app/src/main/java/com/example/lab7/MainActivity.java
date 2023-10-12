package com.example.lab7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt_basicWidget;
    Button bt_basicDialog;
    Button bt_listDialog;
    Button bt_basicToast;
    Button bt_myToast;
    Button bt_exception;
    EditText ed_first;
    EditText ed_second;
    AlertDialog.Builder mydialog;
    final CharSequence[]mItems = {"Red", "Green"," Blue"};
    boolean[] check_array = {true,false,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_basicDialog = (Button) findViewById(R.id.buttonBasicDialog);
        bt_listDialog = (Button) findViewById(R.id.buttonListDialog);
        mydialog=new AlertDialog.Builder(this);
        mydialog.setTitle("This is Dialog");
        //mydialog.setMessage("Do you want to Close this app?");
        mydialog.setIcon(R.drawable.ic_launcher_background);
        bt_basicDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.setPositiveButton("Yes",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        MainActivity.this.finish();
                        dialog.cancel();
                    }
                });
                mydialog.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });
                mydialog.setNeutralButton("Cancel", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        });
                AlertDialog alertDialog = mydialog.create(); // Create Dialog
                alertDialog.show(); //Display Dialog
            }
        });
        bt_listDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mydialog.setItems(mItems,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(MainActivity.this, "Clicked ",
                                Toast.LENGTH_SHORT).show();
                    }
                });*/
                /*mydialog.setSingleChoiceItems(mItems,-1,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(MainActivity.this, "Clicked ",
                                Toast.LENGTH_SHORT).show();
                    }
                });*/
                mydialog.setMultiChoiceItems(mItems,check_array,new
                        DialogInterface.OnMultiChoiceClickListener(){
                            public void onClick(DialogInterface dialog,int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this, "Clicked ",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = mydialog.create(); // Create Dialog
                alertDialog.show(); //Display Dialog
            }
        });
        bt_basicToast = (Button) findViewById(R.id.buttonDefaultToast);
        bt_basicToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Toast 1 here!",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "Toast 2 here!",Toast.LENGTH_LONG).show();
                //Another way
                Context context = getApplicationContext(); //MainActivity
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0); //Toast Location
                toast.show();
            }
        });
        bt_myToast = (Button) findViewById(R.id.buttonMyToast);
        bt_myToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inf=getLayoutInflater();
                View
                        view=inf.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_layout_root))
                        ;
                ImageView iv=(ImageView)view.findViewById(R.id.image);
                iv.setImageResource(R.drawable.ic_launcher_background);
                TextView tv=(TextView)view.findViewById(R.id.text);
                tv.setText("This is Toast with Image");
                Context c=getApplicationContext();
                String x="tui la toast do";
                int display_time=Toast.LENGTH_SHORT;
                Toast t=new Toast(c);
                t.setGravity(Gravity.TOP|Gravity.LEFT, 50,50);
                t.setDuration(display_time);
                t.setView(view);
                t.show();
            }
        });

        bt_exception = (Button) findViewById(R.id.buttonException);
        ed_first = (EditText) findViewById(R.id.editTextFrist);
        ed_second = (EditText) findViewById(R.id.editTextSecond);
        bt_exception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int mysum = Integer.parseInt(ed_first.getText().toString())
                            +Integer.parseInt(ed_second.getText().toString());
                    Toast.makeText(getApplicationContext(),"Result: "
                            +String.valueOf(mysum) , Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), e.toString() ,
                            Toast.LENGTH_SHORT).show();
                }
                finally {
                    Toast.makeText(getApplicationContext(), "Finally" ,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_basicWidget = (Button) findViewById(R.id.buttonWidget);
        bt_basicWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(MainActivity.this, MyWidgetActivity.class);
                startActivity(send);
            }
        });
    }
}