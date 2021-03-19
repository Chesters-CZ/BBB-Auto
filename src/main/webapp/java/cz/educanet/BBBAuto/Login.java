package cz.educanet.BBBAuto;

import cz.educanet.twitternt.Resources.LoginDatabase;
import cz.educanet.twitternt.Resources.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("login")
public class Login {

    @GET
    public Response GetUserLogin(@QueryParam("user") String username, @QueryParam("pass") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).password.equals(password) && LoginDatabase.userList.get(i).username.equals(username))
                return Response.ok(i).build();
        }
        return Response.status(404, "This combination of username and password does not exist.").build();
    }

    @POST
    public Response RegisterUser(@QueryParam("user") String username, @QueryParam("pass") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).username.equals(username))
                return Response.status(409, "cannot have two users using the same username").build();
        }

        LoginDatabase.userList.add(new User(username, password));
        return Response.status(201).build();
    }

    @DELETE
    public Response RemoveUser(@QueryParam("user") String username, @QueryParam("pass") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).password.equals(password) && LoginDatabase.userList.get(i).username.equals(username)) {

                LoginDatabase.userList.remove(i);
                return Response.ok("removed user " + username).build();
            }
        }
        return Response.status(404, "This combination of username and password does not exist.").build();
    }
}
