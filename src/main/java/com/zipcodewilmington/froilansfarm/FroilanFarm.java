package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.animal.Chicken;
import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Horse;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.storage.ChickenCoop;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.storage.Stable;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicle.Tractor;

import java.util.List;

/**
 * Created by leon on 2/26/18.
 */
public class FroilanFarm {

    private Farm farm;

    public Farm getFarm() {
        return farm;
    }

    //Construct the farm
    public FroilanFarm() {

        farm = new Farm();
        //addFieldToFarm(farm);
        addChickenCoopToFarm(farm);
        addStablesToFarm(farm);
        addVehiclesToFarm(farm);
        addFarmHouseToFarm(farm);

    }

    private void addVehiclesToFarm(Farm farm) {
        farm.addVehicles(new CropDuster());
        farm.addVehicles(new Tractor());
        farm.addVehicles(new Tractor());
    }

    private void addFarmHouseToFarm(Farm farm) {
        farm.addFarmerToFarmHouse(new Farmer("frolian"));
        farm.addFarmerToFarmHouse(new Farmer("froilanda"));
    }

    private void addFieldToFarm(Farm farm) {


        farm.CreateCropRowInField(CornStalk::new, 5);
        farm.CreateCropRowInField(TomatoPlant::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
    }

    private void addChickenCoopToFarm(Farm farm) {
        farm.addChickenCoopToFarm(ChickenCoop::new, Chicken::new, 4, 15);
    }

    private void addStablesToFarm(Farm farm) {
        farm.addStablesToFarm(Stable::new, Horse::new,3, 10);
    }

}
