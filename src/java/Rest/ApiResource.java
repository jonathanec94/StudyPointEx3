/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Domain.Spiller;
import com.google.gson.Gson;
import java.util.ArrayList;
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
@Path("AllPlayerNames")
public class ApiResource {
String hej;
    ArrayList<Spiller> players = new ArrayList<Spiller>();
    @Context
        private UriInfo context;

    public ApiResource() {
        if(players.isEmpty())
        {
           Spiller s1 = new Spiller(1, "James Rodríguez", "Columbia");
           Spiller s2 = new Spiller(2, "Thomas Mueller", "Tyskland");
           Spiller s3 = new Spiller(3, "Messi", "Argentina");
           Spiller s4 = new Spiller(4, "Neymar", "Brazilien");
           Spiller s5 = new Spiller(5, "Van Persie", "Holland");
           players.add(s1); players.add(s2); players.add(s3); players.add(s4); players.add(s5);
        }
        
        
    }

    @GET
    @Produces("application/json")
    public String getPlayers() {
     Gson g = new Gson();
     String clubjason = g.toJson(players);
     return clubjason;
    }
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public String getOne(@PathParam("id") int id )
    {
     String res = "{\"errCode\": 404, \"errMsg\" : \"No player found with the given ID\" }";
        for (int i = 0; i < players.size(); i++) {
           if(players.get(i).getId() == id)
           {
               res = players.get(i).toString();
              
           }
        
    }
        return res;
    }

    /**
     * PUT method for updating or creating an instance of ApiResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putXml(String content) {
     
    }
}
