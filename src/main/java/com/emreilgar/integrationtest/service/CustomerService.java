package com.emreilgar.integrationtest.service;

import com.emreilgar.integrationtest.repository.ICustomerRepository;
import com.emreilgar.integrationtest.repository.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {

        this.repository = repository;
    }

    public Customer save(String name,String address,String telephone){
       if(repository.findAll().stream().filter(x->x.getName().equals(name)).count()>0) {
           throw new IllegalArgumentException("Kişi zaten kayıtlı");
       }return repository.save(Customer.builder()
                .name(name)
                .address(address)
                .telephone(telephone)
                .build());

    }
    public boolean findByCustomerId(Long customerId){
       return repository.existsById(customerId);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
