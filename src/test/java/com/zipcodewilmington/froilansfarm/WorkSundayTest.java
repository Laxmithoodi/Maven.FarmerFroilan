package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import org.junit.Assert;
import org.junit.Test;




public class WorkSundayTest {


    @Test

        public void testAddTomatoCropRow() {


        Plot froilanFarm = new Plot();
        Farmer  farmer = froilanFarm.getFarm().getFarmHouse().getFarmer("frolian");
        CropRow cropRow= new CropRow();
        farmer.plant(TomatoPlant::new, 5, cropRow);
        froilanFarm.getFarm().getField().add(cropRow);

        int actual = cropRow.getCount();
        Assert.assertEquals(5, actual);
    }


    @Test
    public void testAddCornCropRow() {


        Plot froilanFarm = new Plot();
        Farmer  farmer = froilanFarm.getFarm().getFarmHouse().getFarmer("frolian");
        CropRow cropRow= new CropRow();
        farmer.plant(CornStalk::new, 5, cropRow);
        froilanFarm.getFarm().getField().add(cropRow);

        int actual = cropRow.getCount();
        Assert.assertEquals(5, actual);

    }

    @Test
    public void testAddGenericVegetationCropRow() {


        Plot froilanFarm = new Plot();
        Farmer  farmer = froilanFarm.getFarm().getFarmHouse().getFarmer("frolian");
        CropRow cropRow= new CropRow();
        farmer.plant(GenericVegetation::new, 5, cropRow);
        froilanFarm.getFarm().getField().add(cropRow);

        int actual = cropRow.getCount();
        Assert.assertEquals(5, actual);

    }

//
//    @Test
//
//    public void testCropRow2() {
//        CropRow cropRow = new CropRow();
//
//
//        cropRow.addCropRow(CornStalk::new, 8);
//        int countOfCrops = cropRow.getItems().size();
//        Assert.assertEquals(countOfCrops, 8);
//        System.out.println("CropRow2:" + countOfCrops);
//
//    }
//
//    @Test
//
//    public void testCropRow3() {
//        CropRow cropRow = new CropRow();
//
//        cropRow.addCropRow(GenericVegetation::new, 10);
//        int countOfCrops = cropRow.getItems().size();
//        Assert.assertEquals(countOfCrops, 10);
//
//        System.out.println("CropRow3:" + countOfCrops);
//
//    }

}
