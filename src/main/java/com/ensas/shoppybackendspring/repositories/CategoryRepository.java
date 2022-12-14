package com.ensas.shoppybackendspring.repositories;

import com.ensas.shoppybackendspring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
