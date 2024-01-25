package com.culture.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.culture.API.Models.*;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long>{
    Plot save(Plot plot);
}