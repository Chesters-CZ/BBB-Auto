package cz.educanet.BBBAuto;

import cz.educanet.BBBAuto.Resources.LoginDatabase;
import cz.educanet.BBBAuto.Resources.Auto;
import cz.educanet.BBBAuto.Resources.AutoDB;
import cz.educanet.BBBAuto.Resources.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("tweets")
public class Auta {

    @GET
    public Response GetAllCars() {
        return Response.ok(AutoDB.autoList.toString()).build();
    }

    @POST
    public Response AddCar(@QueryParam("SPZ") String spz, @QueryParam("barva") String barva, @QueryParam("brand") String brand, @QueryParam("model") String model, @QueryParam("rokvyroby") int rokVyroby, @QueryParam("serialno") String serialNo, @QueryParam("bourane") boolean bourane, @QueryParam("pohon") Auto.Palivo pohon, @QueryParam("horsepower") int horsepower, @QueryParam("razeni") Auto.Transmission razeni, @QueryParam("klimatizace") boolean klimatizace, @QueryParam("username") String username, @QueryParam("password") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).password.equals(password) && LoginDatabase.userList.get(i).username.equals(username)) {
                        AutoDB.autoList.add(new Auto(spz, barva, brand, model, rokVyroby, serialNo, bourane, pohon, horsepower, razeni, klimatizace));
                        return Response.status(201).build();
            }
        }
        return Response.status(401, "This combination of username and password does not exist.").build();
    }

    @DELETE
    public Response AddCar(@QueryParam("SPZ") String spz, @QueryParam("rokvyroby") int rokVyroby, @QueryParam("serialno") String serialNo, @QueryParam("username") String username, @QueryParam("password") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).password.equals(password) && LoginDatabase.userList.get(i).username.equals(username)) {
                for (int j = 0; j < AutoDB.autoList.size(); j++) {
                    if (AutoDB.autoList.get(i).SPZ.equals(spz) && AutoDB.autoList.get(i).rokVyroby == rokVyroby && AutoDB.autoList.get(i).serialNo.equals(serialNo)) {
                            return Response.ok("removed car with SPZ " + spz).build();
                    }
                }
                return Response.status(404, "This car does not exist.").build();
            }
        }
        return Response.status(401, "This combination of username and password does not exist.").build();
    }
}
