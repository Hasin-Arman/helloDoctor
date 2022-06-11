package com.example.hello_doctor;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.os.Bundle;
import android.widget.ListView;

public class viewDoctors extends AppCompatActivity {
    private ListView listView;
   private String[] doctors;
    private int[] docPic={R.drawable.habibur,R.drawable.abdullah,
            R.drawable.mosharrof,R.drawable.joysree,R.drawable.shuvra,R.drawable.sohely,R.drawable.tajimul,
            R.drawable.abdur,R.drawable.forhad,R.drawable.jesmin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctors);

        doctors=getResources().getStringArray(R.array.doctors);
        listView=findViewById(R.id.listviewID);

        CustomAdapter adapter=new CustomAdapter(docPic,doctors,this);
        listView.setAdapter(adapter);

    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        MenuItem menuItem=menu.findItem(R.id.searchId);

        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}