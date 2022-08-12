package com.ensas.shoppybackendspring.repositories;

import com.ensas.shoppybackendspring.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByCategoryId(Long id, Pageable pageable);
}
