package com.example.productivitybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Task_edit extends AppCompatActivity {
    Button mbutton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);

        //the back button

        mbutton5 = findViewById(R.id.button5);
        mbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Task_edit.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}