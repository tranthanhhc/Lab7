package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyWidgetActivity extends AppCompatActivity {
    Button bt_back;
    private TextView mTV;
    private Button bt_Increase;
    private  Button bt_Decrease;
    private float textSize = 16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_widget);

        bt_back = (Button) findViewById(R.id.button7);
        mTV = (TextView)findViewById(R.id.textView);
        bt_Increase = (Button)findViewById(R.id.buttonIncrease);
        bt_Decrease = (Button)findViewById(R.id.buttonDecrease);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt_Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSize += 2;
                mTV.setTextSize(textSize);
            }
        });
        bt_Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSize -= 2;
                mTV.setTextSize(textSize);
            }
        });

    }
}