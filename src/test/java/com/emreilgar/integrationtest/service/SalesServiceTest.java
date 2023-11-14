package com.emreilgar.integrationtest.service;

import com.emreilgar.integrationtest.repository.ISalesRepository;

import com.emreilgar.integrationtest.repository.entity.Sales;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SalesServiceTest {
    @InjectMocks
    private SalesService salesService;
    @Mock
    private ISalesRepository repository;
    @Mock
    private CustomerService customerService;

    @Test
    void satis() throws Exception {
        Mockito.when(customerService.findByCustomerId(1L)).thenReturn(true); //customerId=1 olan biri sorgulanırsa true dön
        Mockito.when(repository.save(ArgumentMatchers.any(Sales.class))).thenReturn(Sales.builder()
                .id(1L)
                .piece(10)
                .product("ASELSAN")
                .totalPrice(5000D)
                .build());
        Long id= salesService.satis(1L,"ASELSAN", 500D,10);
        Assertions.assertNotNull(id);
    }
    @Test
    void saveMusteriYokIseHataDon(){
        Assertions.assertThrows(Exception.class,()->{salesService.satis(1L,"",0D,0);
    });
    }
    @Test
    void saveAdetFiyatYanlisHataDon(){
        Mockito.when(customerService.findByCustomerId(1L)).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            salesService.satis(1L,"",0D,0);
        });

}
}