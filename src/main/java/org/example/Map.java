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
            for(ArrayList<Integer> coordinate: newLocation.getRange()){
                if(coordinate.get(0) == location.Coordinate().get(0) && coordinate.get(1) == location.Coordinate().get(1)){
                    return  true;
                }
            }
        }
        return false;
    }


    public void showMapList(){
        System.out.println("\nMap: ");
        for (Location location: mapList) {
            System.out.println(location.name() + " (" + location.Coordinate().get(0) + ", "+location.Coordinate().get(1) +")");
        }
    }

    public String FindLocation(int x, int y){

        for (Location location: mapList) {
            for(ArrayList<Integer> coordinate: location.getRange()){
                if(x == coordinate.get(0) && y == coordinate.get(1)){
                    return location.ToString();
                }
            }
        }
        return "Can't find this place!";
    }

}
