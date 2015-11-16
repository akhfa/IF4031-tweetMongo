package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
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
        DB db = Connection.getDatabase();

        DBCollection table = db.getCollection("users");

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

        if(response.get("ok").equals(1l))
            return true;
        else
            return false;
    }
}
