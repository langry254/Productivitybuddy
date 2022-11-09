package com.example.productivitybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

     //links
    private Button s_button;
    private EditText l_email,l_password;
    EditText memail,mpassword;

    TextView mforgot,msign;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        l_email = findViewById(R.id.email);
        l_password = findViewById(R.id.password);
        msign = findViewById(R.id.sign);
        mforgot = findViewById(R.id.forgot);

        //initialize firebase
        mAuth = FirebaseAuth.getInstance();

        //Go to main activity after login
        s_button = (Button) findViewById(R.id.button);
        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccount();
            }
        });
        //If user has no account
        msign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),
                        register.class));

            }
        });
    }
        private void loginUserAccount(){
            String email, password;
            email=l_email.getText().toString();
            password=l_password.getText().toString();
            if (TextUtils.isEmpty(email)){
                Toast.makeText(getApplicationContext(),"PLease Enter your email",
                        Toast.LENGTH_LONG).show();
                return;
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(getApplicationContext(),"PLease Enter your password",
                        Toast.LENGTH_LONG).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Welcome login succesful",
                                        Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(login.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"login failed,Try again",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }





    }
