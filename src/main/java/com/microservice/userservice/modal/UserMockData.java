package com.microservice.userservice.modal;

import java.util.ArrayList;
import java.util.List;

public class UserMockData {

    public static List<User> getUsers() {

        ArrayList<User> arr = new ArrayList<User>();

        User userOne = new User();
        userOne.setUserId(1);
        userOne.setUserName("@geek");
        userOne.setPassword("GeeksforGeeks");

        User userTwo = new User();
        userTwo.setUserId(2);
        userTwo.setUserName("@drash");
        userTwo.setPassword("Darsh123");

        User userThree = new User();
        userTwo.setUserId(3);
        userTwo.setUserName("@bosh");
        userTwo.setPassword("Bosh123");

        arr.add(userOne);
        arr.add(userTwo);
        arr.add(userThree);

        return arr;
    }

}
