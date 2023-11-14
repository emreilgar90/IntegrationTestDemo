package com.emreilgar.integrationtest.service;

import com.emreilgar.integrationtest.repository.ICustomerRepository;
import com.emreilgar.integrationtest.repository.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private ICustomerRepository repository;

    @Test
    void save() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>()); //
        Mockito.when(repository.save(ArgumentMatchers.any(Customer.class))).thenReturn(
                Customer.builder().
                        id(1L).
                        name("Emre").
                        address("İstanbul").
                        telephone("05554443322")
                        .build());
        Customer customer= customerService.save("Emre","İstanbul","05553332211");
        assertNotNull(customer.getId(),"Müşteri kayıt işleminde id Null dönmüştür.");
    }

    @Test
    void saveAdVarsa(){
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(Customer.builder()
                .id(1L)
                .name("Emre")
                .address("İstanbul")
                .telephone("05554443322")
                .build())); //
        Mockito.when(repository.save(ArgumentMatchers.any(Customer.class))).thenReturn(
                Customer.builder().
                        id(1L).
                        name("Emre").
                        address("İstanbul").
                        telephone("05554443322")
                        .build());
        assertThrows(IllegalArgumentException.class,()->{
            customerService.save("Emre","İstanbul","05553332211");
        });
    }
//    @Test
//    void findCustomerIdNotExist(){
//        Mockito.when(repository.existsById(1L)).thenReturn(true);
//       // Mockito.when(repository.existsById(0L)).thenReturn(n);
//
//    }

}