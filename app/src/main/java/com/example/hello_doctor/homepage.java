package com.example.hello_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class homepage extends AppCompatActivity {
    private CardView addPatientCardView,viewDoctors,medicalInfo,takeAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        
        addPatientCardView=findViewById(R.id.addPatientId);
        medicalInfo=findViewById(R.id.viewMedicalInfoId);
        viewDoctors=findViewById(R.id.viewDoctorsId);
        takeAppointment=findViewById(R.id.appointmentId);

        addPatientCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),patient_layout.class);
                startActivity(intent);
            }
        });

        viewDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), com.example.hello_doctor.viewDoctors.class);
                startActivity(intent);
            }
        });

        medicalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),medical_Info.class);
                startActivity(intent);
            }
        });
        takeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),take_Appointment.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.optionsId){
            Intent intent=new Intent(getApplicationContext(),visitProfile.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}