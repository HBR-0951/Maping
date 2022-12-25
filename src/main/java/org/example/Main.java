package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = userLogin();
        user.OnStart();

    }
    public static User userLogin(){
        String userName;
        String userPsd;
        User user;


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

        return user;
    }


}