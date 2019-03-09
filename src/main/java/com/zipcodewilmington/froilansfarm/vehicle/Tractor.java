package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.edible.EarCorn;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.crop.Crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tractor extends FarmVehicle {

    List<Crop> harvestedCrops = new ArrayList<>();

    public void harverst(Crop crop){
        harvestedCrops.add(crop);
    }

    public String makeNoise() {
        return " beep!";
    }

    public CornStalk popEarCorn(){
        Optional<Crop> earCornCrop = harvestedCrops.stream()
                .filter(crop -> crop instanceof CornStalk)
                .findFirst();
        CornStalk crop = (CornStalk) earCornCrop.orElse(null);
        harvestedCrops.remove(crop);
        return crop;
    }

    public TomatoPlant popTomatoPlant(){
        Optional<Crop> tomatoPlatCrop = harvestedCrops.stream()
                .filter(crop -> crop instanceof TomatoPlant)
                .findFirst();
        TomatoPlant crop =  (TomatoPlant) tomatoPlatCrop.orElse(null);
        harvestedCrops.remove(crop);
        return crop;
    }

    public GenericVegetation popGenericVegetation(){
        Optional<Crop> genericVegetationPlatCrop = harvestedCrops.stream()
                .filter(crop -> crop instanceof GenericVegetation)
                .findFirst();
        GenericVegetation crop =  (GenericVegetation) genericVegetationPlatCrop.orElse(null);
        harvestedCrops.remove(crop);
        return crop;
    }
}
