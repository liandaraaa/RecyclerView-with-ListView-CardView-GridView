package com.lianda.beginner.myrecyclerview;

import java.util.ArrayList;

/**
 * Created by lenovo on 19/10/2017.
 */

public class WaterfallData {

    public static String [][] data = new String[][] {
            {"Curug Bidadari", "Tiket masuk : Rp 5000,00"},
            {"Curug Cilember", "Tiket masuk : Rp 4000,00"},
            {"Curug Leuwi Hejo", "Tiket masuk : Rp 4500,00"},
            {"Curug Cikoneng", "Tiket masuk : Rp 3500,00"},
            {"Curug Nangka", "Tiket masuk : Rp 3000,00"},
    };

    public static int [] photo = new int[] {
            R.drawable.bidadari, R.drawable.cilember, R.drawable.hejo, R.drawable.koneng, R.drawable.nangka
    };

    public static ArrayList<Waterfall> getListData(){
        Waterfall waterfall = null;
        ArrayList<Waterfall> list = new ArrayList<>();

        for (int i = 0; i<data.length; i++){
            waterfall = new Waterfall();

            waterfall.setName(data[i][0]);
            waterfall.setPrice(data[i][1]);
            waterfall.setPhoto(photo[i]);

            list.add(waterfall);
        }
        return list;
    }
}
