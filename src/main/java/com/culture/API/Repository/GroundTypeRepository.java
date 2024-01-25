package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.*;

@Repository
public interface GroundTypeRepository extends JpaRepository<GroundType, Long>{
    GroundType save(GroundType groundType);
    List<GroundType> findAll();
}