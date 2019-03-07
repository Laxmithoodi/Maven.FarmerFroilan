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
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import com.zipcodewilmington.froilansfarm.storage.Stable;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicle.Tractor;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 2/26/18.
 */
public class Plot {
    private final Farm farm;

//    private final Farmer froilan = new Farmer("Froilan");
//    private final Farmer froilanda = new Farmer("Froilanda");
//    private final FarmHouse  farmHouse = new FarmHouse();

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
        farm.addVehicles(new CropDuster());
        farm.addVehicles(new Tractor());
        farm.addVehicles(new Tractor());
    }

    private void addFarmHouseToFarm() {
     farm.addFarmerToFarm(new Farmer("froilan"));
     farm.addFarmerToFarm(new Farmer("froilanda"));


    }

    private void addFieldToFarm() {
        farm.CreateCropRowInField(CornStalk::new, 5);
        farm.CreateCropRowInField(TomatoPlant::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
    }

//    public Farmer getFroilan() {
//        return froilan;
//    }
//
//    public Farmer getFroilanda() {
//        return froilanda;
//    }
//
//    public List<Farmer> getFarmers() {
//        return Stream.of(froilan, froilanda).collect(Collectors.toList());
//    }

    private void addChickenCoopToFarm() {
        farm.addChickenCoopToFarm(ChickenCoop::new, Chicken::new, 4, 15);
    }

    private void addStablesToFarm() {
        farm.addStablesToFarm(Stable::new, Horse::new,3, 10);
    }



    public void rideHorse() {
        List<Person> farmerList = farm.getFarmHouse().getItems();
        farmerList.forEach(person -> {
            if(person instanceof Farmer) {
                for (Horse horse : farm.getHorses()) {
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });
    }
}
