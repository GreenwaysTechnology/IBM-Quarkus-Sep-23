package com.ibm.falut.retry;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Path("retry")
public class RetryResource {

    @Inject
    RetryService retryService;

    private AtomicLong counter = new AtomicLong(0);
    private float failRatio = 0.5f;

    @GET
    @Retry(maxRetries = 4, retryOn = RuntimeException.class)
    @Fallback(fallbackMethod = "fallbackProducts")
    public List<String> getProducts() throws InterruptedException {
        final Long invocationNumber = counter.getAndIncrement();
        maybeFail(String.format("RetryResouce#getProducts invocation %d failed", invocationNumber));
        return retryService.getProducts();
    }

    public List<String> fallbackProducts(){
        return List.of("Fallback Products");
    }

    private void maybeFail(String failureMessage) {
        if (new Random().nextFloat() < failRatio) {
            System.out.println(failureMessage);
            throw new RuntimeException("Resource failed");
        }
    }
}
