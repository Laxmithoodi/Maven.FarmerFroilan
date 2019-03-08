package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.animal.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.FarmVehicle;

public class CropDuster implements FarmVehicle, Aircraft {


    public void operate(Farm farm) {

    }

    public void makeNoise() {

    }
    public void fertilize(CropRow cropRow){

    }

    @Override
    public void fly(Rider rider) {

    }
}
