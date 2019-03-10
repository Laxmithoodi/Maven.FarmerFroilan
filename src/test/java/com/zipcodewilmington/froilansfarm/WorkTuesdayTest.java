package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.Tractor;
import org.junit.Assert;
import org.junit.Test;

public class WorkTuesdayTest {
    Plot froilanFarm;
    Farmer frolianFarmer;

    public WorkTuesdayTest(){
        froilanFarm = new Plot();
        frolianFarmer = froilanFarm.getFarm().getFarmHouse().getFarmer(FarmerNames.frolian.toString());
    }

    @Test
    public void testHarvest() {
        Tractor tractor = froilanFarm.getFarm().getTractor();
        frolianFarmer.mount(tractor);
        Field field = froilanFarm.getFarm().getField();
        field.getItems().forEach(cropRow -> cropRow.getItems()
                .forEach(tractor::harverst));

        int newNumber = tractor.getNumberOfHarvestedItems();
        Assert.assertEquals(newNumber, 195);
    }

    }
