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
public class Friend {
    private String username;
    private String friend;
    private Date timestamp;

    public Friend(String _username, String _friend, Date _timestamp)
    {
        username = _username;
        friend = _friend;
        timestamp = _timestamp;
    }

    public boolean save()
    {
        DBCollection table = Connection.getTable("friends");

        BasicDBObject document = new BasicDBObject();
        document.put("username", username);
        document.put("friend", friend);
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
}
