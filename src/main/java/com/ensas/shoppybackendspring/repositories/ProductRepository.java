package com.ensas.shoppybackendspring.repositories;

import com.ensas.shoppybackendspring.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(nativeQuery = true,value="select * from product ORDER BY random()")
    Page<Product> getRandomProducts(Pageable pageable);

    @Query("select p from Product p where p.category.id = :categoryId")
    Page<Product> findByCategoryId(@Param("categoryId") long categoryId, Pageable pageable);

    @Query(nativeQuery = true,value="select * from product where name like :kw ORDER BY random()")
    Page<Product> searchInRandomProducts(@Param("kw") String keyword, Pageable pageable);
    @Query("select p from Product p where p.name like :keyword AND p.category.id = :categoryId")
    Page<Product> searchByNameInCategoryId(@Param("keyword") String keyword,
                               @Param("categoryId") long categoryId,
                               Pageable pageable);
}
