package com.example.hello_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private FirebaseAuth mAuth;
    private EditText  signInEmail;
    private CardView takeAppointments,addPatient,viewDoctors,viewProfile;
    private EditText  signInPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        textView=findViewById(R.id.signUpId);
        
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,sign_up.class);
                startActivity(intent);
            }
        });

        button=findViewById(R.id.loginButton);
        signInEmail=findViewById(R.id.userId);
        signInPassword=findViewById(R.id.passwordId);
        takeAppointments=findViewById(R.id.appointmentId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                  userLogin();
                 Intent intent=new Intent(MainActivity.this,homepage.class);
                 startActivity(intent);
            }
        });

    }

    private void userLogin() {

        String email=signInEmail.getText().toString().trim();
        String password=signInPassword.getText().toString().trim();

        //checking the validity of the email
        if (email.isEmpty()) {
            signInEmail.setError("Enter an email address");
            signInEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signInEmail.setError("Enter a valid email address");
            signInEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            signInPassword.setError("Enter a password");
            signInPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            signInPassword.setError("Minimum length of the password should be 6");
            signInPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(MainActivity.this,homepage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}