package com.ensas.shoppybackendspring.repositories;

import com.ensas.shoppybackendspring.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query("select c from Country c where c.code = :code")
    Optional<Country> findByCode(@Param("code") String code);
}
