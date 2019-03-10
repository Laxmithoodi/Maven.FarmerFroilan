package com.zipcodewilmington.froilansfarm;




import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.mammal.Chicken;
import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.mammal.Horse;
import com.zipcodewilmington.froilansfarm.storage.ChickenCoop;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.storage.Stable;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicle.Tractor;
/**
 * Created by leon on 2/26/18.
 */
public class Plot {

    private final Farm farm;

    public Farm getFarm() {
        return farm;
    }

    //Construct the farm
    public Plot() {
        farm = new Farm();

        addFieldToFarm();
        addChickenCoopToFarm();
        addStablesToFarm();
        addVehiclesToFarm();
        addFarmHouseToFarm();


    }

    private void addVehiclesToFarm() {
        this.farm.addVehicles(new CropDuster());
        this.farm.addVehicles(new Tractor());
        this.farm.addVehicles(new Tractor());
    }


    private void addFarmHouseToFarm() {
        farm.addFarmerToFarmHouse(new Farmer(FarmerNames.frolian.toString()));
        farm.addFarmerToFarmHouse(new Farmer(FarmerNames.frolianda.toString()));
    }


    private void addFieldToFarm() {
        farm.CreateCropRowInField(CornStalk::new, 100);
        farm.CreateCropRowInField(TomatoPlant::new, 50);
        farm.CreateCropRowInField(GenericVegetation::new, 15);
        farm.CreateCropRowInField(GenericVegetation::new, 15);
        farm.CreateCropRowInField(GenericVegetation::new, 15);
    }


    private void addChickenCoopToFarm() {
        this.farm.addChickenCoopToFarm(ChickenCoop::new, Chicken::new, 4, 15);
    }

    private void addStablesToFarm() {
        this.farm.addStablesToFarm(Stable::new, Horse::new,3, 10);
    }
}
