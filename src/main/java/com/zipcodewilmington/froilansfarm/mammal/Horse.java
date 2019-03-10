package com.zipcodewilmington.froilansfarm.mammal;

import com.zipcodewilmington.froilansfarm.mammal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.mammal.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.edible.Edible;

import java.util.ArrayList;
import java.util.List;

public class Horse implements Animal, Rideable {


    boolean hasRidden;
    List<Edible> foodTaken;

    public Horse() {
        foodTaken = new ArrayList<Edible>();
    }

    public int numberOfFoodTaken(){
        return foodTaken.size();
    }

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
        foodTaken.add(food);
    }

    public String makeNoise() {
        return "neigh";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
