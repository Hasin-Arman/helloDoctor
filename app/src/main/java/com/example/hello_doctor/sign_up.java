package com.example.hello_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {
    private TextView textView;
    private EditText signUpEmail, signUpPassword;
    private Button button;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        textView = findViewById(R.id.signUpText);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.signUpButton);
        signUpEmail = findViewById(R.id.signUpEmailId);
        signUpPassword = findViewById(R.id.signUpPasswordId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });
    }

    private void userRegister() {
        String email = signUpEmail.getText().toString().trim();
        String password = signUpPassword.getText().toString().trim();

        //checking the validity of the email
        if (email.isEmpty()) {
            signUpEmail.setError("Enter an email address");
            signUpEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmail.setError("Enter a valid email address");
            signUpEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            signUpPassword.setError("Enter a password");
            signUpPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            signUpPassword.setError("Minimum length of the password should be 6");
            signUpPassword.requestFocus();
            return;
        }

       mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()) {
                   finish();
                   Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(intent);
               } else {
                   Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
               }
           }
       });

    }
}