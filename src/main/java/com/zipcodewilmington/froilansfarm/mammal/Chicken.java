package com.zipcodewilmington.froilansfarm.mammal;

import com.zipcodewilmington.froilansfarm.mammal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.mammal.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.edible.Edible;
import com.zipcodewilmington.froilansfarm.edible.EdibleEgg;

import java.util.ArrayList;
import java.util.List;

public class Chicken implements Animal, Produce {

    private boolean hasBeenFertilized = true;
    List<Edible> foodTaken = new ArrayList<>();


    public void eat(Edible food) {
        foodTaken.add(food);
    }

    public String makeNoise() {
        return "Cluck";
    }

    public Edible yield() {
        makeNoise();
        Edible edible = null;
        if(hasBeenFertilized)
            edible =  new EdibleEgg();
        return edible;
    }

    public int numberOfFoodTaken() {
        return foodTaken.size();
    }
}
