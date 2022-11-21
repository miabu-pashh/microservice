package com.nagarro.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/itemServiceFallBack")
    public String ItemServiceFallBackMethod(){
        return "Item service is taking longer than usual"+
                "Please try again later";
    }

    @GetMapping("/itemDetailsServiceFallBack")
    public String ItemDetailsServiceFallBackMethod(){
        return "Item Details service is taking longer than usual"+
                "Please try again later";
    }

    @GetMapping("/customerServiceFallBack")
    public String CustomerServiceFallBackMethod(){
        return "customer  service is taking longer than usual"+
                "Please try again later";
    }


}
