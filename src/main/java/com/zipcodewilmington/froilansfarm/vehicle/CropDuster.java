package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.mammal.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Aircraft;

public class CropDuster extends FarmVehicle implements Aircraft {


    public String makeNoise() {
        return "horn";
    }

    public void fertilize(CropRow cropRow){
        cropRow.getItems().stream().forEach(crop->crop.setHasBeenFertilized(true));
        System.out.println(("Fertilising : " + cropRow.toString()));
    }

    @Override
    public void fly(Rider rider) {
        hasRidden = true;
        rider.printRider();
        System.out.println("  for Crop Duster!!");
    }
}
