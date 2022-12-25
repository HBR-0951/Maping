package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName;
        String userPsd;
        User user;
        int functionID;
        String name;
        int x;
        int y;

        UserDB.OnInitialized();
        Scanner scanner = new Scanner(System.in);


        do{
            System.out.println("Login: ");
            System.out.print("Username: ");
            userName = scanner.next();
            System.out.print("Password: ");
            userPsd = scanner.next();
            user = new User(userName, userPsd);
        }while (!user.isLogIn());

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
}