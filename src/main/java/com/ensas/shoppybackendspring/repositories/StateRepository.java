package com.ensas.shoppybackendspring.repositories;


import com.ensas.shoppybackendspring.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

    @Query("select s from State s where s.country.code = :code")
    List<State> findByCountryCode(@Param("code") String code);
}
