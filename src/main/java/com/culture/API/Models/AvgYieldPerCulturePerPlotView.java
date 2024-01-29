package com.culture.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AvgYieldPerCulturePerPlotView {

    @Id
    private int idPlot;
    private int idCulture;
    private String cultureName;
    private double avgYield;


    public int getIdPlot() {
        return idPlot;
    }

    public void setIdPlot(int idPlot) {
        this.idPlot = idPlot;
    }

    public int getIdCulture() {
        return idCulture;
    }

    public void setIdCulture(int idCulture) {
        this.idCulture = idCulture;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName;
    }

    public double getAvgYield() {
        return avgYield;
    }

    public void setAvgYield(double avgYield) {
        this.avgYield = avgYield;
    }

    public AvgYieldPerCulturePerPlotView(int idPlot, int idCulture, String cultureName, double avgYield) {
        this.idPlot = idPlot;
        this.idCulture = idCulture;
        this.cultureName = cultureName;
        this.avgYield = avgYield;
    }

    public AvgYieldPerCulturePerPlotView() {
    }
}
