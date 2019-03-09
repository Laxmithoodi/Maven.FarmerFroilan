package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Horse;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.edible.EarCorn;
import com.zipcodewilmington.froilansfarm.edible.EdibleEgg;
import com.zipcodewilmington.froilansfarm.edible.Tomato;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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