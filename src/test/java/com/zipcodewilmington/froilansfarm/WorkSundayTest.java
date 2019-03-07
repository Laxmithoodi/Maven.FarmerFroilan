package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class WorkSundayTest {

//Farmer extends Person
    @Test

        public void testCropRow() {
        String name = "Froilan";

        FroilanFarm froilanFarm = new FroilanFarm();
        List<Person> farmer = froilanFarm.getFarm().getFarmHouse().getItems();
        Person person = new Person(name);
           farmer.add(person);

            CropRow cropRow = new CropRow();


            cropRow.addCropRow(TomatoPlant::new, 5);
            int countOfCrops = cropRow.getItems().size();
             Assert.assertEquals(countOfCrops, 5);
        System.out.println("CropRow1:" + countOfCrops);

    }

    @Test

    public void testCropRow2() {
        CropRow cropRow = new CropRow();


        cropRow.addCropRow(CornStalk::new, 8);
        int countOfCrops = cropRow.getItems().size();
        Assert.assertEquals(countOfCrops, 8);
        System.out.println("CropRow2:" + countOfCrops);

    }

    @Test

    public void testCropRow3() {
        CropRow cropRow = new CropRow();

        cropRow.addCropRow(GenericVegetation::new, 10);
        int countOfCrops = cropRow.getItems().size();
        Assert.assertEquals(countOfCrops, 10);

        System.out.println("CropRow3:" + countOfCrops);

    }

}
