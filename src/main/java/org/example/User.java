package org.example;

public class User {
    private String userName = "";
    private String password = "";

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
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
