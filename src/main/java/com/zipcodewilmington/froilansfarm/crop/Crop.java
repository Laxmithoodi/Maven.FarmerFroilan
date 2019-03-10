package com.zipcodewilmington.froilansfarm.crop;

import com.zipcodewilmington.froilansfarm.mammal.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.edible.Edible;

import java.util.function.Supplier;

public abstract class Crop<T extends Edible> implements Produce {

    private boolean hasBeenFertilized;
    Supplier<T> edibleSupplier;

    public boolean isHasBeenFertilized() {
        return hasBeenFertilized;
    }

    public void setHasBeenFertilized(boolean hasBeenFertilized) {
        this.hasBeenFertilized = hasBeenFertilized;
    }

    public Crop(Supplier<T> edibleSupplier){
        this.edibleSupplier = edibleSupplier;
    }

    public Edible yield() {
        Edible edible = null;
        if(hasBeenFertilized){
            edible =  (Edible) edibleSupplier.get();
        }
        return edible;
    }
}
