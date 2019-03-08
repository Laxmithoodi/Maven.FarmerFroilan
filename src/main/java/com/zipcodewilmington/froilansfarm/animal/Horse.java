package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.animal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.edible.Edible;

public class Horse implements Animal, Rideable {
    public void eat(Edible food) {

    }

    public String makeNoise() {
        return "neigh";

    }
}
