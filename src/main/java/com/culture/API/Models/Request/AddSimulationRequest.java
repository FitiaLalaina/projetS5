package com.culture.API.Models.Request;

import com.culture.API.Models.Culture;
import com.culture.API.Models.Plot;
import com.culture.API.Models.Ressource;

public class AddSimulationRequest {
    public Integer idSimulation;
    public Plot plot;
    public Culture culture;
    public Ressource ressource;
    public int quantity;
}
