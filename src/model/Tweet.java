package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import helper.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by akhfa on 16/11/15.
 */
public class Tweet {
    private String username;
    private String body;

    public Tweet(String _username, String _body)
    {
        this.username = _username;
        this.body = _body;
    }

    public boolean save()
    {
        DBCollection table = Connection.getTable("tweets");

        BasicDBObject document = new BasicDBObject();
        document.put("username", username);
        document.put("body", body);

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
