package model;

import com.mongodb.*;
import helper.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Created by akhfa on 16/11/15.
 */
public class User {
    private String username;
    private String password;

    public User(String _username)
    {
        this.username = _username;
    }

    public User (String _username, String _password)
    {
        this.username = _username;
        this.password = _password;
    }

    public boolean save()
    {
        DBCollection table = Connection.getTable("users");

        BasicDBObject document = new BasicDBObject();
        document.put("username", username);
        document.put("password", password);

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

    public boolean exist()
    {
        DBCollection table = Connection.getTable("users");
        BasicDBObject query = new BasicDBObject("username", username);
        DBObject doc = table.findOne(query);
        return doc != null;
    }

    public boolean login()
    {
        DBCollection table = Connection.getTable("users");
        BasicDBObject query = new BasicDBObject("username", username);
        DBObject doc = table.findOne(query);
        return doc.get("password").equals(password);
    }
}
