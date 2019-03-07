package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import org.junit.Assert;
import org.junit.Test;

public class CropDusterTest {



    @Test

    public void testNoise(){
        CropDuster cropduster = new CropDuster();

        String expected = "horn";
        String actual = cropduster.makeNoise();

      Assert.assertEquals(expected, actual);



    }
}
