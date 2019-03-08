package com.zipcodewilmington.froilansfarm.storage;

import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Person;

import java.util.ArrayList;
import java.util.List;

public class FarmHouse extends Storage<Person>{

  public  Farmer getFarmer(String name){

        Farmer farmer = null;
        int index = items.indexOf(new Person(name));
        Person person = items.get(index);
        if(person instanceof Farmer)
            farmer =  (Farmer)person;
        return farmer;
    }

}
