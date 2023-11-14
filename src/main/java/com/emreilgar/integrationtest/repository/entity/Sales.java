package com.emreilgar.integrationtest.repository.entity;

import jakarta.persistence.*;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tblSales")
@ToString

public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long customerId;
    String product;
    Double price;
    int piece; //adet
    Double totalPrice;
    Long date;
}
