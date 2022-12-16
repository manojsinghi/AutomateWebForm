package com.example.drools;

import com.example.GenericConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@RestController
public class OfferController {
//    @Autowired
//    private KieContainer kieContainer;

    @Autowired
    GenericConfig genericConfig;
    @GetMapping("/order")
    public void orderNow(HttpServletRequest httpServletRequest) throws Exception {
//        KieSession session = kieContainer.newKieSession();
//        session.insert(order);
//        session.fireAllRules();
//        return order;
         genericConfig.setUp();
    }

}