package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(100,200);
        map.showMapList();

        while(true){
            Scanner scanner = new Scanner(System.in);
            String name;
            int x;
            int y;
            System.out.print("Enter new Location:\n" +
                                "Name: ");
            name = scanner.next();
            System.out.println("location:");
            System.out.print("x:");
            x = scanner.nextInt();
            System.out.print("y:");
            y = scanner.nextInt();


            if(map.PutLocation(new Location(name, x, y))){
                System.out.println("put Success");
            }
            else{
                System.out.println("put failed");
            }
            map.showMapList();

        }

    }
}