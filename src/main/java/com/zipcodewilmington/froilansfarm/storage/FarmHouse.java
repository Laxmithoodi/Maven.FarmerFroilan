package com.zipcodewilmington.froilansfarm.storage;

import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.mammal.Person;

public class FarmHouse extends Storage<Person>{


    public Farmer getFarmer(String name){
        Farmer farmer = null;

        int index = items.indexOf(new Person(name));
        Person person = items.get(index);
        if(person instanceof Farmer)
            farmer =  (Farmer)person;
        return farmer;
    }

}
