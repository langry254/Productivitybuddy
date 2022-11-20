package com.example.productivitybuddy;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {



     //this button is for the bottom sheet


    //number of selected tab. default value is 1 cause the first tab is selected by default


    private int selectedTab = 1;
    FloatingActionButton floatingbtn;
    ImageView mmaincalender;
    DatePickerDialog.OnDateSetListener setListener;
    private Bundle savedInstanceState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //topleft calender icon
        mmaincalender = findViewById(R.id.main_cal);
        mmaincalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcal();


            }
        });
        floatingbtn = findViewById(R.id.floatingActionButton);
        floatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });

        final LinearLayout today_layout = findViewById(R.id.today_layout);
        final LinearLayout habit_layout = findViewById(R.id.habit_layout);
        final LinearLayout task_layout = findViewById(R.id.task_layout);
        final LinearLayout timer_layout = findViewById(R.id.timer_layout);
        final LinearLayout settings_layout = findViewById(R.id.settings_layout);

        final ImageView today_image = findViewById(R.id.today_image);
        final ImageView habit_image = findViewById(R.id.habit_image);
        final ImageView task_image = findViewById(R.id.task_image);
        final ImageView timer_image = findViewById(R.id.timer_image);
        final ImageView settings_image = findViewById(R.id.settings_image);


        final TextView today_text = findViewById(R.id.today_text);
        final TextView habit_text = findViewById(R.id.habit_text);
        final TextView task_text = findViewById(R.id.task_text);
        final TextView timer_text = findViewById(R.id.timer_text);
        final TextView settings_text = findViewById(R.id.settiings_text);



        today_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if home tab is selected or not

                if (selectedTab !=1){

                    //unselected other tabs except for the today tab

                    habit_text.setVisibility(View.GONE);
                    task_text.setVisibility(View.GONE);
                    timer_text.setVisibility(View.GONE);
                    settings_text.setVisibility(View.GONE);


                    habit_image.setImageResource(R.drawable.ic_loop_24);
                    task_image.setImageResource(R.drawable.ic_task_alt_24);
                    timer_image.setImageResource(R.drawable.ic_outline_timer_24);
                    settings_image.setImageResource(R.drawable.ic_outline_settings_24);

                    habit_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    task_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    timer_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    settings_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select the today tab
                    today_text.setVisibility(View.VISIBLE);
                    today_image.setImageResource(R.drawable.ic_today);
                    today_layout.setBackgroundResource(R.drawable.round_back_home_100);

                    //create animation#####
                    ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(500);     // animation duration in milliseconds
                    fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                    today_layout.startAnimation(fade_in);

                    //set first tab to be created
                    selectedTab = 1;

                }

            }
        });



        habit_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if habit tab is selected or not

                if (selectedTab !=2){

                    //unselected other tabs except for the habit tab
                    today_text.setVisibility(view.GONE);
                    task_text.setVisibility(View.GONE);
                    timer_text.setVisibility(View.GONE);
                    settings_text.setVisibility(View.GONE);


                    today_image.setImageResource(R.drawable.ic_today);
                    task_image.setImageResource(R.drawable.ic_task_alt_24);
                    timer_image.setImageResource(R.drawable.ic_outline_timer_24);
                    settings_image.setImageResource(R.drawable.ic_outline_settings_24);

                    today_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    task_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    timer_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    settings_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select the today tab
                    habit_text.setVisibility(View.VISIBLE);
                    habit_image.setImageResource(R.drawable.ic_loop_24);
                    habit_layout.setBackgroundResource(R.drawable.round_back_home_100);

                    //create animation#####
                    ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(500);     // animation duration in milliseconds
                    fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                    habit_layout.startAnimation(fade_in);


                    //set first tab to be created
                    selectedTab = 2;

                }

            }
        });

        task_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if task tab is selected or not

                if (selectedTab !=3){

                    //unselected other tabs except for the task tab
                    today_text.setVisibility(view.GONE);
                    habit_text.setVisibility(View.GONE);
                    timer_text.setVisibility(View.GONE);
                    settings_text.setVisibility(View.GONE);


                    habit_image.setImageResource(R.drawable.ic_loop_24);
                    today_image.setImageResource(R.drawable.ic_today);
                    timer_image.setImageResource(R.drawable.ic_outline_timer_24);
                    settings_image.setImageResource(R.drawable.ic_outline_settings_24);

                    habit_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    today_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    timer_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    settings_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select the task tab
                    task_text.setVisibility(View.VISIBLE);
                    task_image.setImageResource(R.drawable.ic_task_alt_24);
                    task_layout.setBackgroundResource(R.drawable.round_back_home_100);

                    //create animation#####
                    ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(500);     // animation duration in milliseconds
                    fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                    task_layout.startAnimation(fade_in);


                    //set first tab to be created
                    selectedTab = 3;

                }

            }
        });

        timer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if timer tab is selected or not

                if (selectedTab !=4){





                    //unselected other tabs except for the timer tab
                    today_text.setVisibility(view.GONE);
                    habit_text.setVisibility(View.GONE);
                    task_text.setVisibility(View.GONE);
                    settings_text.setVisibility(View.GONE);


                    habit_image.setImageResource(R.drawable.ic_loop_24);
                    task_image.setImageResource(R.drawable.ic_task_alt_24);
                    today_image.setImageResource(R.drawable.ic_today);
                    settings_image.setImageResource(R.drawable.ic_outline_settings_24);

                    habit_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    task_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    today_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    settings_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select the today tab
                   timer_text.setVisibility(View.VISIBLE);
                    timer_image.setImageResource(R.drawable.ic_outline_timer_24 );
                    timer_layout.setBackgroundResource(R.drawable.round_back_home_100);

                    //create animation#####
                    ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(500);     // animation duration in milliseconds
                    fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                    timer_layout.startAnimation(fade_in);


                    //set first tab to be created
                    selectedTab = 4;

                }

            }
        });

        settings_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //move to settings page
                Intent intent = new Intent(MainActivity.this,settings.class);
                startActivity(intent);

                //check if settings tab is selected or not

                if (selectedTab !=5){

                    //unselected other tabs except for the setttings tab
                    today_text.setVisibility(view.GONE);
                    habit_text.setVisibility(View.GONE);
                    task_text.setVisibility(View.GONE);
                    timer_text.setVisibility(View.GONE);



                    habit_image.setImageResource(R.drawable.ic_loop_24);
                    task_image.setImageResource(R.drawable.ic_task_alt_24);
                    timer_image.setImageResource(R.drawable.ic_outline_timer_24);
                    today_image.setImageResource(R.drawable.ic_today);

                    habit_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    task_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    timer_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    today_layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select the today tab
                    settings_text.setVisibility(View.VISIBLE);
                    settings_image.setImageResource(R.drawable.ic_outline_settings_24);
                    settings_layout.setBackgroundResource(R.drawable.round_back_home_100);

                    //create animation#####
                    ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(500);     // animation duration in milliseconds
                    fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                    settings_layout.startAnimation(fade_in);


                    //set first tab to be created
                    selectedTab = 5;

                }

            }
        });






    }
    //function for the calender
    private void showcal() {

        Calendar calendar= Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);


        TextView changedate=findViewById(R.id.changdate);
        DatePickerDialog datePickerDialog= new DatePickerDialog(
                MainActivity.this,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                changedate.setText(date);
            }
        },year,month,day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()- 1000);
        datePickerDialog.show();
    }


    //function for the bottom sheet using the floating action bar.
    private void showDialog() {
        final Dialog dialog= new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet);

        LinearLayout chabit =dialog.findViewById(R.id.crhabit);
        LinearLayout ctask = dialog.findViewById(R.id.crtask);

        chabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent=new Intent(MainActivity.this,habit_edit.class);
                startActivity(intent);

            }
        });
        ctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent=new Intent(MainActivity.this,Task_edit.class);
                startActivity(intent);
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}


