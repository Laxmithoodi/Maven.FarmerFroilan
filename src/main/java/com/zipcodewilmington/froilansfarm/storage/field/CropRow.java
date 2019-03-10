package com.zipcodewilmington.froilansfarm.storage.field;

import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.storage.Storage;

import java.util.function.Supplier;

public class CropRow  extends Storage<Crop> {

    public <T extends Crop> void addCropRow(Supplier<T> cropSupplier, int numberOfCrops){
        for (int i = 0; i < numberOfCrops; i++) {
            add(cropSupplier.get());
        }
    }

    @Override
    public String toString() {
        String cropStr = "";
        Crop crop = getItems().get(0);
        if(crop != null){
            cropStr = crop.getClass().getSimpleName();
        }
        return "A row of " + cropStr;
    }

    public void fertilize(){
        getItems().stream().forEach(item->item.setHasBeenFertilized(true));
    }
}
