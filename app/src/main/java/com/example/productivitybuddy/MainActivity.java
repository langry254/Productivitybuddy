package com.example.productivitybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //number of selected tab. default value is 1 cause the first tab is selected by default
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

                    //set timer fragment
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                            .replace(androidx.fragment.R.id.fragment_container_view_tag,timerFragment.class,null).commit();


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
}