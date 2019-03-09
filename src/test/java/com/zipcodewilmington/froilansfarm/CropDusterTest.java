package com.zipcodewilmington.froilansfarm;


import com.sun.scenario.effect.Crop;
import com.zipcodewilmington.froilansfarm.animal.Chicken;
import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

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

        frolianFarmer.mount(cropDuster);
        cropDuster.fly(frolianFarmer);
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
