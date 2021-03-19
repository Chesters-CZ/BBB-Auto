package cz.educanet.BBBAuto;

import cz.educanet.twitternt.Resources.LoginDatabase;
import cz.educanet.twitternt.Resources.Tweet;
import cz.educanet.twitternt.Resources.TweetDatabase;
import cz.educanet.twitternt.Resources.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("tweets")
public class Tweets {

    @GET
    public Response GetAllTweets() {
        return Response.ok(TweetDatabase.tweetsList.toString()).build();
    }

    //TODO: Malik - get tweets od jednoho uživatele, pass + uname input a response budou buď všechny tweety od uživatele nebo 404

    @POST
    public Response PostTweet(@QueryParam("user") String username, @QueryParam("pass") String password, @QueryParam("head") String header, @QueryParam("body") String body) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).password.equals(password) && LoginDatabase.userList.get(i).username.equals(username)) {
                if (header.length() <= 128) {
                    if (body.length() <= 1024) {
                        TweetDatabase.tweetsList.add(new Tweet(header, new User(username, password), body));
                        return Response.status(201).build();
                    } else return Response.status(413, "The body is too big").build();
                } else return Response.status(413, "The header is too big").build();
            }
        }
        return Response.status(401, "This combination of username and password does not exist.").build();
    }

    @DELETE
    public Response RemoveTweet(@QueryParam("user") String username, @QueryParam("pass") String password, @QueryParam("head") String header, @QueryParam("body") String body) {
        for (int i = 0; i < TweetDatabase.tweetsList.size(); i++) {
            if (TweetDatabase.tweetsList.get(i).header.equals(header) && TweetDatabase.tweetsList.get(i).body.equals(body)) {
                if (TweetDatabase.tweetsList.get(i).author.equals(new User(username, password))) {
                    TweetDatabase.tweetsList.remove(i);
                    return Response.ok("removed post " + header).build();
                } else return Response.status(401, "supplied credentials do not match author credentials.").build();
            }
        }
        return Response.status(404, "This post does not exist.").build();
    }

    //TODO: David - přidat liketweet metodu, asiže put, nejlíp tak, aby se kontrolovalo kdo likuje, tzn. max. 1 like/uživatel. klidně uprav i tweet classu a udělej něco jako .likes a .likedBy
}
