package com.zipcodewilmington.froilansfarm.animal;

import com.zipcodewilmington.froilansfarm.animal.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.edible.Edible;

import java.util.Objects;

public class Person implements NoiseMaker, Eater {

    private String name;



    public Person(String name){
        this.name = name;

    }



    public void eat(Edible food) {

    }

    public void makeNoise() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

}
