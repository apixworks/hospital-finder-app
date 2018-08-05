package com.example.apix.hospitalfinder;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

/**
 * Created by ali on 1/5/17.
 */


public class Mkoa implements Parent<Wilaya> {
    public String gName;
    public List<Wilaya> wilaya;

    public Mkoa() {

    }

    public void setgName(String gName){
        this.gName=gName;
    }

    public void setWilaya(List<Wilaya> wilaya) {
        this.wilaya = wilaya;
    }
//
//        public Mkoa(String mName, List<Wilaya> mWilaya){
//        gName=mName;
//        wilaya = mWilaya;
//    }

    public String getgName(){
        return gName;
    }

    @Override
    public List<Wilaya> getChildList() {
        return wilaya;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }


}
