package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.animal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.edible.Edible;

public class Horse implements Animal, Rideable {


    boolean hasRidden;

    public boolean isHasRidden() {
        return hasRidden;
    }

    @Override
    public boolean hasRidden() {
        return hasRidden;
    }

    public void setHasRidden(boolean hasRidden) {
        this.hasRidden = hasRidden;
    }

    public void eat(Edible food) {

    }

    public String makeNoise() {
        return "neigh";

    }

    @Override
    public void printRideableObject() {
        System.out.println( this.getClass().toString());
    }
}
