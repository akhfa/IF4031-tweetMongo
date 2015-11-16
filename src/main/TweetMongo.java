package main;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by akhfa on 16/11/15.
 */

public class TweetMongo {
    public static void main(String [] args)
    {
        try
        {
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB("13513601");

            DBCollection table = db.getCollection("users");

            BasicDBObject document = new BasicDBObject();

            document.put("name", "akhfa2");
            document.put("umur", "22");
            document.put("createdDate", new Date());
            table.insert(document);

            System.out.println("okeee");
        }catch (UnknownHostException e)
        {

        }

    }
}
