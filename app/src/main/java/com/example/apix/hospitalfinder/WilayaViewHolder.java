package com.example.apix.hospitalfinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;


/**
 * Created by ali on 1/5/17.
 */

public class WilayaViewHolder extends ChildViewHolder {

    TextView wilayaTextView;
    Wilaya wilaya;

    public WilayaViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        wilayaTextView = (TextView) itemView.findViewById(R.id.wilaya1);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,wilaya.getName(),Toast.LENGTH_SHORT).show();
                if(wilaya.getName().equals("DODOMA(M)")) {
                    context.startActivity(new Intent(context, HospitalActivity.class));
                }
            }
        });

    }

    public void bind(@NonNull Wilaya wilaya) {
        wilayaTextView.setText(wilaya.getName());
        this.wilaya = wilaya;
    }

}
