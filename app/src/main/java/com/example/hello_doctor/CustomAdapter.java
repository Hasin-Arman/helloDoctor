package com.example.hello_doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int docPic[];
    String[] doctors;
    Context context;
    LayoutInflater inflater;

    public CustomAdapter(int[] docPic, String[] doctors, Context context) {
        this.docPic = docPic;
        this.doctors = doctors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return doctors.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
           inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView=inflater.inflate(R.layout.sample_view,parent,false);
        }
          ImageView docImage= (ImageView)  convertView.findViewById(R.id.doctorImgId);
          TextView docInfo= (TextView) convertView.findViewById(R.id.docId);

          docImage.setImageResource(docPic[position]);
          docInfo.setText(doctors[position]);

        return convertView;
    }
}
