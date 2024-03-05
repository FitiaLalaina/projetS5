package com.culture.API.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Yield;

@Repository
public interface YieldRepository extends JpaRepository<Yield , Integer>{
    Yield save(Yield yield);
    List<Yield> findAll();
}