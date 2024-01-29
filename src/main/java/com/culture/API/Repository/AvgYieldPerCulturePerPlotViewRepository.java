package com.culture.API.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.culture.API.Models.AvgYieldPerCulturePerPlotView;

public interface AvgYieldPerCulturePerPlotViewRepository extends JpaRepository<AvgYieldPerCulturePerPlotView, Integer> {

    List<AvgYieldPerCulturePerPlotView> findAll();

}
