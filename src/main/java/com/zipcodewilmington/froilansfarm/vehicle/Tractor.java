package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.FarmVehicle;

public class Tractor implements FarmVehicle {
    public void harverst(Crop crop){

    }

    public void operate(Farm farm) {

    }

    public String makeNoise() {
        return " beep!";

    }
}
