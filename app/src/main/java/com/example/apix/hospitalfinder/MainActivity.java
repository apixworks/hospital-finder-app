package com.example.apix.hospitalfinder;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;


import java.sql.Array;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String url = "jdbc:mysql://192.168.43.80:3306/hospital_finder";
    private static final String user = "didi";
    private static final String pass = "didi123";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Mkoa> mkoaList;
    MkoaAdapter adapter;
    FloatingActionButton floatingActionButton;
    //RecyclerView.ItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mkoaList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        setData();

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });


        adapter = new MkoaAdapter(mkoaList, this);
        adapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onParentExpanded(int parentPosition) {
                String gameName = mkoaList.get(parentPosition).getgName();
                Toast.makeText(MainActivity.this, "Expanded: " + gameName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onParentCollapsed(int parentPosition) {
                String gameName = mkoaList.get(parentPosition).getgName();
                Toast.makeText(MainActivity.this, "Collapsed: " + gameName, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);


        //decoration = new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL);
        //recyclerView.addItemDecoration(decoration);

    }


    public void setData() {
       /* Wilaya arusha1 = new Wilaya("Arusha Mjini");
        Wilaya arusha2 = new Wilaya("Karatu");
        Wilaya arusha3 = new Wilaya("Longido");
        Wilaya arusha4 = new Wilaya("Meru");
        Wilaya arusha5 = new Wilaya("Monduli");
        Wilaya arusha6 = new Wilaya("Ngorongoro");


        Wilaya dar1 = new Wilaya("Ilala");
        Wilaya dar2 = new Wilaya("Kinondoni");
        Wilaya dar3 = new Wilaya("Kinondoni");

        Wilaya dodoma1 = new Wilaya("Bahi");
        Wilaya dodoma2 = new Wilaya("Dodoma Mjini");
        Wilaya dodoma3 = new Wilaya("Kondoa");
        Wilaya dodoma4 = new Wilaya("Mpwapwa");
        Wilaya dodoma5 = new Wilaya("Kongwa");
        Wilaya dodoma6 = new Wilaya("Chamwino");
        Wilaya dodoma7 = new Wilaya("Chemba");

        Wilaya iringa1 = new Wilaya("Iringa Mjini");
        Wilaya iringa2 = new Wilaya("Kilolo");
        Wilaya iringa3 = new Wilaya("Mufindi");

        Wilaya kagera1 = new Wilaya("Biharamulo");
        Wilaya kagera2 = new Wilaya("Bukoba");
        Wilaya kagera3 = new Wilaya("Karagwe");
        Wilaya kagera4 = new Wilaya("Muleba");
        Wilaya kagera5 = new Wilaya("Ngara");
        Wilaya kagera6 = new Wilaya("Kyerwa");
        Wilaya kagera7 = new Wilaya("Mishenyi");

        Wilaya kigoma1 = new Wilaya("Kasulu");
        Wilaya kigoma2 = new Wilaya("Kibondo");
        Wilaya kigoma3 = new Wilaya("Kigoma Mjini");
        Wilaya kigoma4 = new Wilaya("Buhigwe");
        Wilaya kigoma5 = new Wilaya("Kakonko");
        Wilaya kigoma6 = new Wilaya("Uvinza");

        Wilaya kilimanjaro1 = new Wilaya("Hai");
        Wilaya kilimanjaro2 = new Wilaya("Moshi Mjini");
        Wilaya kilimanjaro3 = new Wilaya("Mwanga");
        Wilaya kilimanjaro4 = new Wilaya("Rombo");
        Wilaya kilimanjaro5 = new Wilaya("Same");
        Wilaya kilimanjaro6 = new Wilaya("Siha");

        Mkoa arusha = new Mkoa("Mkoa Wa ARUSHA", Arrays.asList(arusha1,arusha2,arusha3,arusha4,arusha5,arusha6));
        Mkoa dar = new Mkoa("Mkoa Wa DAR ES SALAAM", Arrays.asList(dar1,dar2,dar3));
        Mkoa dodoma = new Mkoa("Mkoa Wa DODOMA", Arrays.asList(dodoma1,dodoma2,dodoma3,dodoma4,dodoma5,dodoma6,dodoma7));
        Mkoa iringa = new Mkoa("Mkoa Wa IRINGA", Arrays.asList(iringa1, iringa2, iringa3));
        Mkoa kagera = new Mkoa("Mkoa Wa KAGERA", Arrays.asList(kagera1,kagera2,kagera3, kagera4,kagera5,kagera6,kagera7));
        Mkoa kigoma = new Mkoa("Mkoa Wa KIGOMA", Arrays.asList(kigoma1, kigoma2,kigoma3,kigoma4,kigoma5,kigoma6));
        Mkoa kilimanjaro = new Mkoa("Mkoa Wa KILIMANJARO", Arrays.asList(kilimanjaro1,kilimanjaro2,kilimanjaro3,kilimanjaro4,kilimanjaro5,kilimanjaro6));
        Mkoa lindi = new Mkoa("Mkoa Wa LINDI", Arrays.asList(kigoma1,kigoma2,kigoma3,kigoma4,kigoma5));
        Mkoa mara = new Mkoa("Mkoa Wa MARA", Arrays.asList(kigoma5,kigoma6,kagera4,kagera5,kagera7));

        mkoaList = Arrays.asList(arusha,dar,dodoma,iringa,kagera,kigoma,kilimanjaro,lindi,mara);*/

        mkoaList.clear();

        try{
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from region");




            while(rs.next()){
                Mkoa newMkoa = new Mkoa();
                newMkoa.setgName("Mkoa Wa "+rs.getString(2));
                Log.d(TAG, "setData: "+rs.getString(2));

                Statement st1 = con.createStatement();
                ResultSet rw = st1.executeQuery("select * from district where r_id = "+rs.getInt(1));
                List<Wilaya> wilayaList = new ArrayList<>();
                while(rw.next()){
                    Wilaya newWilaya = new Wilaya(rw.getString(3));
                    wilayaList.add(newWilaya);
                }
                newMkoa.setWilaya(wilayaList);
                mkoaList.add(newMkoa);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}