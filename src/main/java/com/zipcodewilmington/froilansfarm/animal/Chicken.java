package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.animal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.edible.Edible;
import com.zipcodewilmington.froilansfarm.edible.EdibleEgg;

public class Chicken implements Animal, Produce {

    private boolean hasBeenFertilized = true;

    public void eat(Edible food) {

    }

    public String makeNoise() {
        return "Cluck";
    }

    public Edible yield() {
        makeNoise();
        if(hasBeenFertilized)
            return new EdibleEgg();
        return null;
    }

    public boolean isHasBeenFertilized() {
        return hasBeenFertilized;
    }

    public void setHasBeenFertilized(boolean hasBeenFertilized) {
        this.hasBeenFertilized = hasBeenFertilized;
    }
}
