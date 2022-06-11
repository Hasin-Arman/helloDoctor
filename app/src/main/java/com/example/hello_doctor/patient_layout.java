package com.example.hello_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class patient_layout extends AppCompatActivity {

    private EditText name,age,gender,disease,phone;
    private Button submit;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_layout);

        databaseReference= FirebaseDatabase.getInstance().getReference("patients");

        name=findViewById(R.id.nameId);
        age=findViewById(R.id.ageId);
        gender=findViewById(R.id.genderId);
        disease=findViewById(R.id.diseaseId);
        phone=findViewById(R.id.phoneId);
        submit=findViewById(R.id.submitId);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        Encryption encryption=new Encryption();
        String nameText= null;
        try {
            nameText = encryption.encryptData( name.getText().toString().trim());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        String ageText= null;
        try {
            ageText = encryption.encryptData( age.getText().toString().trim());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        String genderText= null;
        try {
            genderText = encryption.encryptData( gender.getText().toString().trim());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        String diseaseText= null;
        try {
            diseaseText = encryption.encryptData( disease.getText().toString().trim());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        String phoneText= null;
        try {
            phoneText = encryption.encryptData( phone.getText().toString().trim());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        String key=databaseReference.push().getKey();
        patient victim=new patient(nameText,ageText,genderText,diseaseText,phoneText);
        databaseReference.child(key).setValue(victim);
        Toast.makeText(getApplicationContext(), "Patient Details Added", Toast.LENGTH_SHORT).show();
    }

}