package com.example.apix.hospitalfinder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Apix on 26/01/2017.
 */

public class ServiceViewAdapter extends RecyclerView.Adapter<ServiceViewAdapter.ServiceViewHolder>{

    String[] services;
    Context context;

    public ServiceViewAdapter(String[] services,Context context){
        super();
        this.services=services;
        this.context=context;
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ServiceViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.service);
        }
    }

    @Override
    public ServiceViewAdapter.ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item,null);
        return new ServiceViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ServiceViewAdapter.ServiceViewHolder holder, int position) {
        holder.textView.setText(services[position]);
    }

    @Override
    public int getItemCount() {
        return services.length;
    }
}
