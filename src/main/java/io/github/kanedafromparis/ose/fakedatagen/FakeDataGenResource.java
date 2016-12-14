package io.github.kanedafromparis.ose.fakedatagen;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("data") 
@RequestScoped

public class FakeDataGenResource {

    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    /**
     *
     * @param asyncResponse
     * @param deep
     */
    @Path("v1")    
    @GET()
    @Produces("application/json")
    public void getData(@Suspended
    final AsyncResponse asyncResponse, @QueryParam(value = "deep")
    final Integer deep) {
        executorService.submit(() -> {
            asyncResponse.resume(doGetData(deep));
        });
    }

    private HashMap<String, List<FDGCompany>> doGetData(@QueryParam("deep") Integer deep) {
        HashMap<String, List<FDGCompany>> companies = new HashMap<>();
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();     
        List<FDGCompany> companiesLst = fakeDataGenerator.generateFakeData(5,6);
        String buffer = fakeDataGenerator.toJSon(companiesLst);
        companies.put("companies", companiesLst);
        return companies;
    }

    
}