package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.animal.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.edible.Edible;

public class Person implements NoiseMaker, Eater {

    private String name;

    public Person(String name){
        this.name = name;
    }

    public void eat(Edible food) {

    }

    public String makeNoise() {
        return "shout!";

    }
}
