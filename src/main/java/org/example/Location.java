package org.example;

import java.util.ArrayList;

public class Location {
    private String name = "";
    private ArrayList<Integer> coordinate = new ArrayList<Integer>();
    private int x;
    private int y;


    private ArrayList<ArrayList<Integer>> range = new ArrayList<>();
    public int rangeLimit = 1;

    public Location(String name,int x, int y){
        this.name = name;

        this.x = x;
        this.y = y;
        coordinate.add(x);
        coordinate.add(y);
        putRange();
    }

    public ArrayList<Integer> Coordinate(){
        return  coordinate;
    }
    private void putRange(){
        int i, j;
        for(i = -rangeLimit; i <= rangeLimit; i++){
            for(j = -rangeLimit; j <= rangeLimit; j++){
                ArrayList<Integer> coordinate = new ArrayList<>();
                coordinate.add(this.x + i);
                coordinate.add(this.y + j);
                range.add(coordinate);
            }
        }
//        System.out.println();
    }
    public ArrayList<ArrayList<Integer>> getRange(){
        return range;
    }
    public String name(){
        return this.name;
    }
    public String ToString(){
        return this.name +
                " ("+ this.x +", "+ this.y + ")";
    }

}
