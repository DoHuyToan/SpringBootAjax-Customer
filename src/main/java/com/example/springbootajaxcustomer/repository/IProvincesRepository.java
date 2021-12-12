package com.example.springbootajaxcustomer.repository;

import com.example.springbootajaxcustomer.model.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvincesRepository extends JpaRepository<Provinces, Long> {
}
