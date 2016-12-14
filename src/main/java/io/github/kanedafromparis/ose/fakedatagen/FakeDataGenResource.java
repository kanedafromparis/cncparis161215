package io.github.kanedafromparis.ose.fakedatagen;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;

@RequestScoped
@Path("/data")
public class FakeDataGenResource {
    @Path("/data/v1")
    @GET()
    @Produces("application/json")
    public HashMap<String, String> getData(@QueryParam("deep") Integer deep
    ) {
        HashMap<String, String> theInsult = new HashMap<>();
        theInsult.put("insult", new FakeDataGenerator().generateFakeData());
        return theInsult;
    }
}