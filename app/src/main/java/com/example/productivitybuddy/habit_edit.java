package com.example.productivitybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class habit_edit extends AppCompatActivity {
    Button mbutton2,mbutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_edit);
        mbutton2=findViewById(R.id.button2);
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(habit_edit.this, MainActivity.class);
                startActivity(intent);

            }
        });//end
    }
}