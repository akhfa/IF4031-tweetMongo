package model;

import com.mongodb.*;
import helper.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by akhfa on 16/11/15.
 */
public class Follower {
    private String username;
    private String follower;
    private Date timestamp;

    public Follower(String _username, String _follower, Date _timestamp)
    {
        this.username = _username;
        this.follower = _follower;
        this.timestamp = _timestamp;
    }

    public boolean save()
    {
        DBCollection table = Connection.getTable("followers");

        BasicDBObject document = new BasicDBObject();
        document.put("username", username);
        document.put("follower", follower);
        document.put("timestamp", timestamp);

        JSONParser parser = new JSONParser();

        JSONObject response = null;

        try
        {
            response = (JSONObject)parser.parse(table.insert(document).toString());
        }
        catch (ParseException e)
        {
            System.out.println(Response.returnDatabaseError());
            System.exit(1);
        }

        return response.get("ok").equals(1l);
    }

    public static ArrayList<String> getAllFollowerFrom(String _username)
    {
        ArrayList<String> daftarFollower = new ArrayList<>();
        DBCollection collection = Connection.getTable("followers");
        BasicDBObject query = new BasicDBObject("username", _username);
        DBCursor cursor = collection.find(query);

        try {
            while (cursor.hasNext())
            {
                DBObject doc = cursor.next();
                daftarFollower.add(doc.get("follower").toString());
            }
        }
        finally {
            cursor.close();
        }
        return daftarFollower;
    }
}
