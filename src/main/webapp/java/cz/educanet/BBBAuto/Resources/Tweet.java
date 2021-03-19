package cz.educanet.BBBAuto.Resources;

import cz.educanet.twitternt.Resources.User;

public class Tweet{
    public String header;
    public User author;
    public String body;

    public Tweet() {
        this.header = null;
        this.author = null;

        this.body = null;
    }

    public Tweet(String header, User user, String body) {
        this.header = header;
        this.author = user;
        this.body = body;
    }

}
