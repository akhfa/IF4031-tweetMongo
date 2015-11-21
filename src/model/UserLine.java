package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import helper.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Date;

/**
 * Created by akhfa on 16/11/15.
 */
public class UserLine {
    private String username;
    private Date time;
    private String tweet_id;
    public UserLine(String _username, Date _time, String _tweet_id)
    {
        this.username = _username;
        this.time = _time;
        this.tweet_id = _tweet_id;
    }

    public boolean save()
    {
        DBCollection table = Connection.getTable("userline");

        BasicDBObject document = new BasicDBObject();
        document.put("username", username);
        document.put("time", time);
        document.put("tweet_id", tweet_id);

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
}
