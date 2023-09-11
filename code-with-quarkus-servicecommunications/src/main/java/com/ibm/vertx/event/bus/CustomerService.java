package com.ibm.vertx.event.bus;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.enterprise.context.ApplicationScoped;

//Listener
@ApplicationScoped
public class CustomerService {

    //listener methods
    @ConsumeEvent("ibm.customer.service.list")
    //@ConsumeEvent //Name is name bean class with fully qualified Name
    public String getCustomerInfo(String id) {
        System.out.println(id);
        return "Customer Service " + id;
    }

    @ConsumeEvent("com.ibm.customer.service.greet")
    public void sayHello(Message<String> message) {
        System.out.println(message.body());
        System.out.println(message.address());

    }

    //pub- sub - many subscribers or consumers

    @ConsumeEvent("com.ibm.customer.notification")
    public void notification_1(Message<String> message) {
        System.out.println("Listener 1");
        //process the message
        System.out.println(message.body() + " " + message.address());
    }

    @ConsumeEvent("com.ibm.customer.notification")
    public void notification_2(Message<String> message) {
        System.out.println("Listener 2");
        System.out.println(message.body() + " " + message.address());

    }

}
