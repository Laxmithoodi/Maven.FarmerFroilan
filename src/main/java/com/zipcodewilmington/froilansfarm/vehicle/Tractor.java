package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.edible.EarCorn;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.storage.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tractor extends FarmVehicle {

    List<Crop> harvestedCrops = new ArrayList<>();

    public int getNumberOfHarvestedItems(){
        return harvestedCrops.size();
    }
    public void harverst(Crop crop){
        harvestedCrops.add(crop);
    }

    @Override
    public void operate(Farm farm) {
        super.operate(farm);
        Field field = farm.getField();

        field.getItems().forEach(cropRow -> cropRow.getItems()
                .forEach(this::harverst));

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
