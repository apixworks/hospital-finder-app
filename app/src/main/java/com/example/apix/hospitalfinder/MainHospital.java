package com.example.apix.hospitalfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Apix on 15/01/2017.
 */

public class MainHospital extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ServiceViewAdapter adapter;
    RecyclerView.ItemDecoration decoration;
    TextView distView;
    TextView hospTitle;
    TextView category;
    TextView phoneNo;
    TextView emailNo;
    ImageView hospPic;

    String[] services = {"Inpatient Care","Transitional Care","Surgical Services",
            "Digital Radiology","Physical Therapy","Full-Service Laboratory",
            "24/7 Emergency Services","Cancer center","Diabetes Center","Maternal Care",
            "Gastroenterology(GI) Center","Rehabilitation Services","Renal Dialysis Center",
            "Respiratory Care Services","Pediatric Services","Medical Imaging/X-Ray Services",
            "Interventional Radiology","Cardiology"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_main);

        recyclerView = (RecyclerView)findViewById(R.id.services_recycler);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        decoration = new DividerItemDecoration(recyclerView.getContext(),RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        adapter = new ServiceViewAdapter(services,getApplicationContext());
        recyclerView.setAdapter(adapter);

        distView = (TextView)findViewById(R.id.dist_View);
        hospTitle = (TextView)findViewById(R.id.hosp_title);
        category = (TextView)findViewById(R.id.category);
        phoneNo = (TextView)findViewById(R.id.phone_no);
        emailNo = (TextView)findViewById(R.id.email_no);
        hospPic = (ImageView)findViewById(R.id.hosp_pic);

        String hospitalname = getIntent().getStringExtra("hospitalname");
        String hospcategory = getIntent().getStringExtra("hospitalcategory");
        String hospphone = getIntent().getStringExtra("hospitalphone");
        String hospemail = getIntent().getStringExtra("hospitalemail");

        hospTitle.setText(hospitalname);
        category.setText(hospcategory);
        phoneNo.setText(hospphone);
        emailNo.setText(hospemail);

        if(hospitalname.equals("Benjamin Mkapa Hospital")){
            hospPic.setImageResource(R.drawable.benjaminhosp);
        }else if(hospitalname.equals("Dodoma Christian Medical Centre")){
            hospPic.setImageResource(R.drawable.domchrist);  
        }

        distView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DistMapsActivity.class));
            }
        });

    }
}
