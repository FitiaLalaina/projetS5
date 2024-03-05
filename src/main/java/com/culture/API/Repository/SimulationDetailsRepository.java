package com.culture.API.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Action;
import com.culture.API.Models.Plot;
import com.culture.API.Models.Simulation;
import com.culture.API.Models.SimulationDetails;

@Repository
public interface SimulationDetailsRepository extends JpaRepository<SimulationDetails , Integer>{
    SimulationDetails save(SimulationDetails simulation);
    List<SimulationDetails> findAll();
    List<SimulationDetails> findAllBySimulation(Simulation simulation);
    List<SimulationDetails> findAllBySimulationAndRessource_Action(Simulation simulation, Action action);
    SimulationDetails findFirstBySimulationAndRessource_Action_Name(Simulation simulation, String actionName);
    SimulationDetails findFirstBySimulationAndSimulation_PlotAndRessource_Action_Name(Simulation simulation, Plot plot, String actionName);
}
