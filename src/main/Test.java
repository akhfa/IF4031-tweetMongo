package main;

import model.User;

/**
 * Created by akhfa on 16/11/15.
 */
public class Test {
    public static void main(String [] args)
    {
        userTest();
    }

    private static void userTest()
    {
        User user = new User("akhfa9", "akhfa");
        if(user.save())
            System.out.println("Success");
        else
            System.out.println("failed");
    }
}
