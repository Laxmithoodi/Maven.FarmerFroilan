package com.zipcodewilmington.froilansfarm;


import com.sun.scenario.effect.Crop;
import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CropDusterTest {

    Plot froilanFarm;
    Farmer  frolianFarmer;
    Farmer froilandaFarmer;
    CropDuster cropduster = new CropDuster();

    public CropDusterTest() {
        froilanFarm = new Plot();
        frolianFarmer = froilanFarm.getFarm().getFarmHouse().getFarmer(FarmerNames.frolian.toString());
        froilandaFarmer = froilanFarm.getFarm().getFarmHouse().getFarmer(FarmerNames.frolianda.toString());

    }


    @Test
    public void testNoise(){
        String expected = "horn";
        String actual = cropduster.makeNoise();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCropDuster() {

        List<CropRow> cropRows = froilanFarm.getFarm().getCropRows();
        CropDuster cropDuster = froilanFarm.getFarm().getCropDuster();

        froilandaFarmer.mount(cropDuster);
        cropDuster.fly(froilandaFarmer);
        int expected = 5;

        for (CropRow row : cropRows) {
            cropDuster.fertilize(row);
        }

        for (CropRow cropRow : cropRows) {
            Crop[] crops = cropRow.getItems().stream()
                    .filter(crop -> !crop.isHasBeenFertilized())
                    .toArray(Crop[]::new);
            Assert.assertTrue(crops.length == 0);
        }
    }

}
