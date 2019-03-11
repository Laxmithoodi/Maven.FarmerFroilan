package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.mammal.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Aircraft;

import java.util.List;

public class CropDuster extends FarmVehicle implements Aircraft {


    public String makeNoise() {
        return "horn";
    }

    @Override
    public void fly(Rider rider) {
        hasRidden = true;
        rider.printRider();
        System.out.println("  for Crop Duster!!");
    }

    @Override
    public void operate(Farm farm) {
        super.operate(farm);
        List<CropRow> cropRows = farm.getCropRows();
        for (CropRow row : cropRows) {
            System.out.println(("Fertilising : " + row.toString()));
            row.fertilize();
        }
    }
}
