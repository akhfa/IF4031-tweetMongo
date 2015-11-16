package model;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by akhfa on 16/11/15.
 */
public class Connection {
    public static DB getDatabase()
    {
        DB db = null;
        try
        {
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            db = mongoClient.getDB("13513601");

        }catch (UnknownHostException e)
        {
            System.out.println("cannot connect to database.");
            System.exit(1);
        }

        return db;
    }
}
