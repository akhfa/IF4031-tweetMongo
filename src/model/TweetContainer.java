package model;

/**
 * Created by akhfa on 16/11/15.
 */
public class TweetContainer {
    private String username;
    private String body;
    public TweetContainer(String _username, String _body)
    {
        this.username = _username;
        this.body = _body;
    }

    public String getUsername()
    {
        return username;
    }

    public String getBody()
    {
        return body;
    }
}
