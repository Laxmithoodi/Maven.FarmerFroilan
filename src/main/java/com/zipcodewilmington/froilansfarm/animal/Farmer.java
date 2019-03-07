package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Botanist;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.edible.Edible;
import com.zipcodewilmington.froilansfarm.storage.Farm;

import java.util.function.Supplier;

public class Farmer extends Person implements Rider, Botanist {

    public Farmer(String name) {
        super(name);
    }

    public void eat(Edible food) {

    }

    public void mount(Rideable rideable) {

    }

    public void dismount(Rideable rideable) {

    }

    public <T extends Crop> void plant(Supplier<T> cropSupplier, int numberOfCrops, CropRow cropRow) {
        cropRow.addCropRow(cropSupplier, numberOfCrops);
    }


}
