package com.example.hello_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class take_Appointment extends AppCompatActivity {

    private EditText name,gender,phone,birth,address,date;
    private Button submit;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_appointment);

        databaseReference= FirebaseDatabase.getInstance().getReference("Appointments");

        name=findViewById(R.id.nameId);
        gender=findViewById(R.id.genderId);
        phone=findViewById(R.id.phoneId);
        birth=findViewById(R.id.birthId);
        address=findViewById(R.id.addressId);
        date=findViewById(R.id.dateId);

        submit=findViewById(R.id.submitId);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String nameText=name.getText().toString().trim();
        String genderText=gender.getText().toString().trim();
        String phoneText=phone.getText().toString().trim();
        String birthText=birth.getText().toString().trim();
        String addressText=address.getText().toString().trim();
        String dateText=date.getText().toString().trim();

        String key=databaseReference.push().getKey();
        Appointment appointmentForm=new Appointment(nameText,genderText,phoneText,birthText,addressText,dateText);
        databaseReference.child(key).setValue(appointmentForm);
        Toast.makeText(getApplicationContext(), "Appointment Submitted", Toast.LENGTH_SHORT).show();
    }
}