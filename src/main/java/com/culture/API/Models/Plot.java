package com.culture.API.Models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.culture.API.Repository.*;

@Entity
public class Plot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlot;

    @ManyToOne
    @JoinColumn(name="idField")
    private Field field;

    @Basic
    private double area;

    @ManyToOne
    @JoinColumn(name="idGroundType")
    private GroundType groundType;

    public int getIdPlot() {
        return idPlot;
    }

    public void setIdPlot(int idPlot) {
        this.idPlot = idPlot;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public GroundType getGroundType() {
        return groundType;
    }

    public void setGroundType(GroundType groundType) {
        this.groundType = groundType;
    }

    public Plot(){

    }

    public Plot(int idPlot, Field field, double area, GroundType groundType) {
        this.idPlot = idPlot;
        this.field = field;
        this.area = area;
        this.groundType = groundType;
    }

    public static Plot savePlot(Plot plot, PlotRepository plotRepository){
        Plot plot2 = plotRepository.save(plot);
        return plot2;
    }

}
