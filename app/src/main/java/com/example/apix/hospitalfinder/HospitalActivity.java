package com.example.apix.hospitalfinder;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apix on 07/01/2017.
 */

public class HospitalActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    HospitalViewAdapter adapter;
    FloatingActionButton floatingActionButton;
    RecyclerView.ItemDecoration decoration;
    List<String> list;

    private static final String url = "jdbc:mysql://192.168.43.80:3306/hospital_finder";
    private static final String user = "didi";
    private static final String pass = "didi123";

    String[] hospital;

    public void  testDB(){

        try{
            list.clear();
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital");

            while (rs.next()){
                list.add(rs.getString(3)) ;
            }
            hospital = new String[list.size()];
            hospital = list.toArray(hospital);


        }catch(Exception e){
            e.printStackTrace();
            //id.setText(e.toString());
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitals_list);
        list = new ArrayList();
        testDB();

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recycler2);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        decoration = new DividerItemDecoration(recyclerView.getContext(),RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(decoration);


        adapter = new HospitalViewAdapter(hospital,getApplicationContext());
        recyclerView.setAdapter(adapter);


    }
}
