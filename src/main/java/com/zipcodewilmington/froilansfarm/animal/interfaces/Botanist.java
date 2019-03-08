package com.zipcodewilmington.froilansfarm.animal.interfaces;


import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.crop.Crop;

import java.util.function.Supplier;

public interface Botanist {
    public <T extends Crop> void plant(Supplier<T> cropSupplier, int numberOfCrops, CropRow cropRow);
}
