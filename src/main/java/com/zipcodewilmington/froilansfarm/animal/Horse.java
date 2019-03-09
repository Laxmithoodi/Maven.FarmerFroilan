package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.animal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Rideable;
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
    public void printRideableObject() {
        System.out.println( this.getClass().toString());
    }
}
