package com.culture.API.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.SimulationDetailsView;

@Repository
public interface SimulationDetailsViewRepository extends JpaRepository<SimulationDetailsView , Integer>{
    List<SimulationDetailsView> findAll();
}
