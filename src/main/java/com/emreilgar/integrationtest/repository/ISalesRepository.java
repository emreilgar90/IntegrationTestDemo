package com.emreilgar.integrationtest.repository;

import com.emreilgar.integrationtest.repository.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends JpaRepository<Sales,Long> {
}
