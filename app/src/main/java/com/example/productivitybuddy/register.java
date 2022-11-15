package com.example.productivitybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    //links
    private TextView already_txt;
    private Button signup_btn;


    //defines the data
    private EditText f_name, l_name, u_email, password0, password2;

    // authenticate
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //initialize firebase instance
        mAuth = FirebaseAuth.getInstance();


        //referencing
        f_name = findViewById(R.id.fname);
        l_name = findViewById(R.id.lname);
        u_email = findViewById(R.id.email);
        password0 = findViewById(R.id.password);
        password2 = findViewById(R.id.password1);

        // confirm if the current user exists, takes to login screen direct
        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }


        //on clicking the register button
        signup_btn = findViewById(R.id.button);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the user input data
                String email = u_email.getText().toString();
                String password = password0.getText().toString();
                String password1 = password2.getText().toString();
                String fname = f_name.getText().toString();
                String lname = l_name.getText().toString();

                //validating user input

                if (TextUtils.isEmpty(fname)) {
                    f_name.setError("First name is required");
                    return;
                }
                if (TextUtils.isEmpty(lname)) {
                    l_name.setError("last name is required");
                }
                if (TextUtils.isEmpty(password)) {
                    password0.setError("Password is required");
                }
                if (TextUtils.isEmpty(password1)) {
                    password2.setError(" confirm Password is required");
                }

                if (password.length() < 8) {
                    password0.setError("Password must be atleast 8 characters");
                    return;
                }
                if (!password1.equals(password)) {
                    password2.setError("passwords do not match");
                    return;
                }
                //validation is complete
                //create user
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(register.this, "Successful Registration",
                                            Toast.LENGTH_SHORT).show();

                                    //i signup is successful take user to main activity
                                    Intent intent = new Intent(register.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(register.this, "Registration failed!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });


    }
}