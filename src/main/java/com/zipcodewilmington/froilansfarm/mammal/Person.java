package com.zipcodewilmington.froilansfarm.mammal;

import com.zipcodewilmington.froilansfarm.mammal.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.mammal.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.edible.Edible;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements NoiseMaker, Eater {

    private String name;
    List<Edible> foodTaken = new ArrayList<>();

    public int numberOfFoodTaken(){
        return foodTaken.size();
    }

    public String getName() {
        return name;
    }

    public Person(String name){
        this.name = name;

    }


    public void eat(Edible food) {
        foodTaken.add(food);
    }

    public String makeNoise() {
        return "shout!";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

}
