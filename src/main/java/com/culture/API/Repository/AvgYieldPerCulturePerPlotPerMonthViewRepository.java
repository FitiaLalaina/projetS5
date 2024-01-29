package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culture.API.Models.AvgYieldPerCulturePerPlotPerMonthView;

public interface AvgYieldPerCulturePerPlotPerMonthViewRepository extends JpaRepository<AvgYieldPerCulturePerPlotPerMonthView, Integer> {
    List<AvgYieldPerCulturePerPlotPerMonthView> findByIdPlotAndMonth(int idPlot, int month);
    // List<AvgYieldPerCulturePerPlotPerMonthView> findByIdPlot(int idPlot);
}

