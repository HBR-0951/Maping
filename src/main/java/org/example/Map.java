package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

public class Map {
    private int width = 0;
    private int length = 0;
    private ArrayList<Location> mapList = new ArrayList<>();


    public Map(int length, int width){
        this.width = width;
        this.length = length;
        OnInitialized();
    }
    private void OnInitialized(){
        InitialLocation();
    }
    private void InitialLocation(){
        PutLocation(new Location("hospital", 30, 50));
        PutLocation(new Location("supermarket", 50, 70));
        PutLocation(new Location("supermarket", 70, 30));
    }
    public boolean PutLocation(Location newLocation){
        if(mapList.isEmpty()){
            mapList.add(newLocation);
            return true;
        }
        if(!isOutBounder(newLocation) && !isOverlap(newLocation)){
            mapList.add(newLocation);
            return true;
        }

        return false;
    }

    private boolean isOutBounder(Location newLocation){
        if (newLocation.Coordinate().get(0) <= this.width){
            if(newLocation.Coordinate().get(1) <= this.length){
                return false;
            }
        }
        System.out.println("new Location is out of bounder!");
        return true;
    }

    private boolean isOverlap(Location newLocation){
        int i;
        for (Location location: mapList) {
            System.out.println("\nmap:\n"+
                    "("+location.Coordinate().get(0) +", "+ location.Coordinate().get(1)+")\n");
            for(i = 0; i < newLocation.getRange().size(); i++){
                System.out.println("("+newLocation.getRange().get(i).get(0) +", "+ newLocation.getRange().get(i).get(1)+")");
                if(newLocation.getRange().get(i).get(0) == location.Coordinate().get(0)){
                    if(newLocation.getRange().get(i).get(1) == location.Coordinate().get(1)){
                        System.out.println("new Location is overlap " + location.name());
                        return  true;
                    }
                }
            }

        }
        return false;
    }

    public void showMapList(){
        for (Location location: mapList) {
            System.out.println(location.name() + " (" + location.Coordinate().get(0) + ", "+location.Coordinate().get(1) +")");
        }
    }
//    public void drawMap(){
//        int i,j;
//        ArrayList<ArrayList<Integer>> allLocation = AllLocation();
////        char map[][] = new char[this.width][this.length];
//        for(j = 0; j < this.width; j++){
//            for(i = 0; i < this.length; i++){
////                for (ArrayList<Integer> coordinate: allLocation) {
////                    if(i == coordinate.get(0) && j == coordinate.get(1)){
////                        allLocation.remove(coordinate);
//                        System.out.print("x");
////                    }
////                }
////                map[i][j] = '-';
//                System.out.print("-");
//            }
//            System.out.println();
//        }
//
//    }
//    private ArrayList<ArrayList<Integer>> AllLocation(){
//        int i;
//        ArrayList<ArrayList<Integer>> allLocation = new ArrayList<>();
//        for (Location location: mapList) {
//            for(i = 0; i < location.getRange().size(); i++){
//                ArrayList<Integer> coordinate = new ArrayList<>();
//                coordinate.add(location.getRange().get(i).get(0));
//                coordinate.add(location.getRange().get(i).get(1));
//                allLocation.add(coordinate);
//            }
//        }
//        return allLocation;
//    }
//


}
