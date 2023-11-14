package com.emreilgar.integrationtest.controller;

import com.emreilgar.integrationtest.dto.CustomerSaveDto;
import com.emreilgar.integrationtest.repository.entity.Customer;
import com.emreilgar.integrationtest.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody CustomerSaveDto dto){
        customerService.save(dto.getName(), dto.getAddress(), dto.getTelephone());
        return ResponseEntity.ok(true);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

}

