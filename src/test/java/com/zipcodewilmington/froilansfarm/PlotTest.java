package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import org.junit.Before;

public class PlotTest {

    private Plot plot;
    private FarmHouse farmHouse;
    Farmer  frolianFarmer;
    Farmer froilandaFarmer;


    @Before
    public void setUp() throws Exception {
        plot = new Plot();
        frolianFarmer = plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolian.toString());
        froilandaFarmer = plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolianda.toString());
    }

}