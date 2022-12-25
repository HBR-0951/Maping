package org.example;

import java.util.Scanner;

public class User {
    private String userName = "";
    private String password = "";

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public void OnStart(){
        int functionID;
        String name;
        int x;
        int y;

        Scanner scanner = new Scanner(System.in);
        Map map = new Map(100,200);
        map.showMapList();

        while(true){
            System.out.println("1: Enter new Location\n" +
                    "2: Read the Location");
            System.out.print("FunctionID: ");
            functionID = scanner.nextInt();
            switch (functionID){
                case 1:
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
                    break;
                case 2:
                    System.out.println("Enter Location coordinate");
                    System.out.print("x:");
                    x = scanner.nextInt();
                    System.out.print("y:");
                    y = scanner.nextInt();
                    System.out.print("Output:" + map.FindLocation(x, y));
                    break;
                default:
                    System.out.println("Please choose again!");
            }

            map.showMapList();

        }
    }
    public String GetUserName(){
        return this.userName;
    }
    public String GetUserPsd(){
        return this.password;
    }
    public boolean isLogIn(){
        if(UserDB.hasUser(this)){
            System.out.println("Login Success");
            return true;
        }
        System.out.println("Login failed!\nPlease login again!");
        return false;
    }

}