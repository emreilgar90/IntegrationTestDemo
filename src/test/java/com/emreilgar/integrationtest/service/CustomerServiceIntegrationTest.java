package com.emreilgar.integrationtest.service;

import com.emreilgar.integrationtest.repository.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerServiceIntegrationTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void save(){
        Customer customer = customerService.save("Emre","İstanbul","0536 500 00 00 ");
        Assertions.assertNotNull(customer.getId());
        System.out.println(customer.toString());

    }
}
