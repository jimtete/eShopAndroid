package com.example.eshopproject;

public class IDGenerator {

    public static int sailorId(){
        String id = MainActivity.eshopDatabase.myDao().getMaxProductId();
        if (id==null)return 1;
        int id2 = Integer.parseInt(id);
        return id2+1;
    }


}
