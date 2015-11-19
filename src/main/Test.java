package main;

import model.Follower;
import model.Friend;
import model.Tweet;
import model.User;

import java.util.Date;

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
//        User user = new User("akhfa9", "akhfa");
//        if(user.save())
//            System.out.println("Success");
//        else
//            System.out.println("failed");
//        System.out.print(User.isExist("akhfa9"));

//        Friend friend = new Friend("a", "b", new Date());
//        friend.save();

//        Follower follower = new Follower("a", "b", new Date());
//        follower.save();

        Tweet tweet = new Tweet("akhfa", "siiipppp");
        System.out.print(tweet.save());
    }
}
