package com.emreilgar.integrationtest.service;

import com.emreilgar.integrationtest.repository.ISalesRepository;
import com.emreilgar.integrationtest.repository.entity.Sales;
import org.springframework.stereotype.Service;

@Service
public class SalesService {
    private final ISalesRepository repository;

    public SalesService(ISalesRepository repository, CustomerService customerService) {
        this.repository = repository;
        this.customerService = customerService;
    }
    private final CustomerService customerService;

    public Long satis(Long customerId,String product,Double price,int piece) throws Exception {
        if (!customerService.findByCustomerId(customerId))
            throw new Exception("Böyle bir müşteri yok.");
        if (piece > 0 && price > 0){
            Sales sales= repository.save(Sales.builder().id(customerId)
                    .product(product)
                    .price(price)
                    .piece(piece)
                    .totalPrice(price * piece)
                    .build());
            return sales.getId();
    }else
            throw new IllegalArgumentException("Adet ve Fiyat bilgileri hatalı.");

    }
}
