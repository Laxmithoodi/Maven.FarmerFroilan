package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.animal.Chicken;
import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CropDusterTest {

    FroilanFarm froilanFarm = new FroilanFarm();
    CropDuster cropduster = new CropDuster();




    @Test

    public void testNoise(){

        String expected = "horn";
        String actual = cropduster.makeNoise();

      Assert.assertEquals(expected, actual);

    }



    @Test
    public void testCropDuster(){


        Farmer farmer = froilanFarm.getFarm().getFarmHouse().getFarmer("froilanda");

        List<CropRow> cropRows = froilanFarm.getFarm().getCropRows();
        CropDuster cropDuster = froilanFarm.getFarm().getCropDuster();

        farmer.mount(cropDuster);
        cropDuster.fly(farmer);
        int expected = 5;

        for (CropRow row : cropRows) {
            cropDuster.fertilize(row);


        }
        for (CropRow croprow : cropRows);


        }

       // Assert.assertTrue(true, );








}
