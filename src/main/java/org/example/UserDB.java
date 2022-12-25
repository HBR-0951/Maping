package org.example;

import java.util.ArrayList;

public class UserDB {
    public static ArrayList<User> userDB = new ArrayList<>();

    public static void OnInitialized(){
        userDB.add(new User("joe", "1234"));
        userDB.add(new User("david", "2345"));
        userDB.add(new User("cindy", "3456"));
    }

    public static boolean hasUser(User aUser){
        for (User user: userDB) {
            if(aUser.GetUserName().contentEquals(user.GetUserName()) && aUser.GetUserPsd().contentEquals(user.GetUserPsd())){
                return  true;
            }
        }
        return false;
    }


}
