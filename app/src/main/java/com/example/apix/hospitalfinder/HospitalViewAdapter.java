package com.example.apix.hospitalfinder;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class HospitalViewAdapter extends RecyclerView.Adapter<HospitalViewAdapter.HospitalViewHolder> {

    String[] hospitals;
    Context context;
    List<String> list1;
    List<String> list2;
    List<String> list3;
    List<String> list4;
    String[] name;
    String[] phone;
    String[] email;
    String[] category;

    private static final String url = "jdbc:mysql://192.168.43.80:3306/hospital_finder";
    private static final String user = "didi";
    private static final String pass = "didi123";

    public HospitalViewAdapter(String[] hospitals,Context context) {
        super();
        this.hospitals=hospitals;
        this.context=context;
    }

    public class HospitalViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;


        public HospitalViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.hospital);
            imageView = (ImageView)itemView.findViewById(R.id.hosp);
            list1 = new ArrayList();
            list2 = new ArrayList();
            list3 = new ArrayList();
            list4 = new ArrayList();
            final Intent objIntent = new Intent(context, MainHospital.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        try{
                            list1.clear();
                            list2.clear();
                            list3.clear();
                            list4.clear();
                            StrictMode.ThreadPolicy policy =
                                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
                            StrictMode.setThreadPolicy(policy);

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(url, user, pass);


                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery("select * from hospital");

                            while (rs.next()){
                                Log.d("main", "onClick: "+rs.getString(3));
                                    list1.add(rs.getString(3));
                                   list2.add(rs.getString(4));
                                   list3.add(rs.getString(5));
                                   list4.add(rs.getString(6));
                            }

                            name = new String[list1.size()];
                            phone = new String[list2.size()];
                            email = new String[list3.size()];
                            category = new String[list4.size()];

                            name = list1.toArray(name);
                            phone = list2.toArray(phone);
                            email = list3.toArray(email);
                            category = list4.toArray(category);

                            objIntent.putExtra("hospitalname",textView.getText());
                            for(int i=0;i<name.length;i++) {
                                if(textView.getText().equals(name[i])) {
                                    objIntent.putExtra("hospitalphone", phone[i]);
                                    objIntent.putExtra("hospitalemail", email[i]);
                                    objIntent.putExtra("hospitalcategory", category[i]);
                                }
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    context.startActivity(objIntent);
                }
            });
        }
    }
    @Override
    public HospitalViewAdapter.HospitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_item,null);
        HospitalViewHolder hospitalViewHolder = new HospitalViewHolder(item);
        return hospitalViewHolder;
    }

    @Override
    public void onBindViewHolder(HospitalViewAdapter.HospitalViewHolder holder, int position) {
        holder.textView.setText(hospitals[position]);
    }

    @Override
    public int getItemCount() {
        return hospitals.length;
    }
}
