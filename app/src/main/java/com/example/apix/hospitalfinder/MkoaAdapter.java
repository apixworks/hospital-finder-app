package com.example.apix.hospitalfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.List;

/**
 * Created by ali on 1/5/17.
 */

public class MkoaAdapter extends ExpandableRecyclerAdapter<Mkoa, Wilaya, MkoaViewHolder, WilayaViewHolder> {

    List<Mkoa> mkoaList;
    LayoutInflater inflater;
    Context context;

    public MkoaAdapter(@NonNull List<Mkoa> parentList, Context context) {
        super(parentList);
        mkoaList = parentList;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public MkoaViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View mkoaView = inflater.inflate(R.layout.layout_parent, parentViewGroup, false);
        MkoaViewHolder mkoaViewHolder = new MkoaViewHolder(mkoaView);
        return mkoaViewHolder;
    }


    @NonNull
    @Override
    public WilayaViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View wilayaView = inflater.inflate(R.layout.layout_child, childViewGroup, false);
        return new WilayaViewHolder(wilayaView, context);
    }

    @Override
    public void onBindParentViewHolder(@NonNull MkoaViewHolder parentViewHolder, int parentPosition, @NonNull Mkoa parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull WilayaViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Wilaya child) {
        childViewHolder.bind(child);
    }


}
