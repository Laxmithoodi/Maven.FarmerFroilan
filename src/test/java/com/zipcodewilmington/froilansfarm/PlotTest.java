package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlotTest {

    private Plot plot;

    @Before
    public void setUp() throws Exception {
        plot = new Plot();
    }

    @Test
    public void PlotTest(){
        checkFieldHasFiveCropRows();
        checkFarmHasFifteenChicken();
        checkFarmHasTenHorse();
        checkFarmHasTwoFarmVehicle();
        checkFarmHasOneAircraft();

    }
    private void checkFieldHasFiveCropRows(){
        long expected = plot.getFarm().getCropRows().stream().count();
        Assert.assertEquals(5, expected);

    }
    private void checkFarmHasFifteenChicken(){
        long expected = plot.getFarm().getChickens().stream().count();
        Assert.assertEquals(15, expected);

    }
    private void checkFarmHasTenHorse(){
        long expected = plot.getFarm().getHorses().stream().count();
        Assert.assertEquals(10, expected);

    }
    private void checkFarmHasTwoFarmVehicle(){
        long expected = plot.getFarm().getVehicles().stream().count();
        Assert.assertEquals(2, expected);

    }
    private void checkFarmHasOneAircraft(){
        long expected = plot.getFarm().getAircrafts().stream().count();
        Assert.assertEquals(1, expected);

    }
}