package com.ibm.falut.cb;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("cb")
public class CircuitBreakerResource {

    @Inject
    CircuitBreakerService circuitBreakerService;

    private AtomicLong counter = new AtomicLong(0);

    @GET
    @CircuitBreaker(requestVolumeThreshold = 4)
    @Fallback(fallbackMethod = "fallback")
    public List<String> getProdcts() {
        maybeFail();
        return circuitBreakerService.getProducts();
    }

    public List<String> fallback() {
        return List.of("Fallback Response");
    }
    private void maybeFail() {
        final Long invocationNumber = counter.getAndIncrement();
        //alernate 2 success and 2 failing invocations
        if (invocationNumber % 4 > 1) {
            throw new RuntimeException("Service Failed");
        }
    }

}
