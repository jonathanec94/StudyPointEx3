/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Domain.Spiller;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author jones
 */
@Path("")
public class ApiResource {

    String hej;
    ArrayList<Spiller> players = new ArrayList<Spiller>();
    @Context
    private UriInfo context;

    public ApiResource() {
        if (players.isEmpty()) {
            Spiller s1 = new Spiller(1, "James Rodríguez", "Columbia");
            Spiller s2 = new Spiller(2, "Thomas Mueller", "Tyskland");
            Spiller s3 = new Spiller(3, "Messi", "Argentina");
            Spiller s4 = new Spiller(4, "Neymar", "Brazilien");
            Spiller s5 = new Spiller(5, "Van Persie", "Holland");
            players.add(s1);
            players.add(s2);
            players.add(s3);
            players.add(s4);
            players.add(s5);
        }

    }

    @Path("AllPlayerNames")
    @GET
    @Produces("application/json")
    public String getPlayers() {
        Gson g = new Gson();
        String clubjason = g.toJson(players);
        return clubjason;
    }

    @Path("AllPlayersFromWeb")
    @GET
    @Produces("application/json")
    public String getPlayersFromWeb() {
         URL url;
         String jsonStr = null;
        try {
             url = new URL("http://footballpool.dataaccess.eu/data/info.wso/AllPlayerNames/JSON/debug?bSelected=");
            URLConnection con = url.openConnection();
            Scanner scan = new Scanner(con.getInputStream());
            
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
            }
            System.out.println(jsonStr);
            scan.close();
        } catch (IOException ex) {
            Logger.getLogger(ApiResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonStr;
    }

    @GET
    @Produces("application/json")
    @Path("player/{id}")
    public String getOnePlayer(@PathParam("id") int id) {
        Gson g = new Gson();
        String res = "{\"errCode\": 404, \"errMsg\" : \"No player found with the given ID\" }";
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                res = g.toJson(players.get(i));
            }
        }
        return res;
    }

    @PUT
    @Consumes("application/json")
    public void putXml(String content) {

    }
}
