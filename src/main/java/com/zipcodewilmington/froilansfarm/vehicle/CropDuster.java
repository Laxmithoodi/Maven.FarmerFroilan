package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.FarmVehicle;

public class CropDuster implements FarmVehicle, Aircraft {
    public void fly() {

    }

    public void operate(Farm farm) {

    }

    public String makeNoise() {
        return "horn";



    }
    public void fertilize(CropRow cropRow){

    }
}
