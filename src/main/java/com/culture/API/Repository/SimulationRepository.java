package com.culture.API.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Plot;
import com.culture.API.Models.Simulation;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation , Integer>{
    Simulation save(Simulation simulation);
    List<Simulation> findAll();
    Simulation findFirstByPlotOrderByDateSimulationDesc(Plot plot);
}
