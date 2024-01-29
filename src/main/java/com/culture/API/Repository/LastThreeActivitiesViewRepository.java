package com.culture.API.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.culture.API.Models.LastThreeActivitiesView;

public interface LastThreeActivitiesViewRepository extends JpaRepository<LastThreeActivitiesView, Integer> {

    List<LastThreeActivitiesView> findByidPlot(int idPlot);
    List<LastThreeActivitiesView> findTop3ByIdPlotOrderByDateSimulationDesc(int idPlot);

}
