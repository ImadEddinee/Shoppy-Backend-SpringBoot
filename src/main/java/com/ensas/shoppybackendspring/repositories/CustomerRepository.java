package com.ensas.shoppybackendspring.repositories;

import com.ensas.shoppybackendspring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
