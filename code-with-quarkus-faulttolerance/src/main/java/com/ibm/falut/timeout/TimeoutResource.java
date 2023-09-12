package com.ibm.falut.timeout;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.util.List;

@Path("timeout")
public class TimeoutResource {

    @Inject
    TimeoutService timeoutService;

    @GET
    @Timeout(1000)
    @Fallback(fallbackMethod = "getProductFallback")
    public List<String> getProducts() throws InterruptedException {
        return timeoutService.getProducts();
    }

    //Fallback api
    public List<String> getProductFallback() {
        return List.of("Sorry Try afer some time");
    }
}
