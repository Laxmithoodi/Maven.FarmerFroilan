package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.mammal.Horse;
import com.zipcodewilmington.froilansfarm.mammal.Person;
import org.junit.Test;

import java.util.List;

public class WorkWeekDay1Test {
    Plot plot;
    public WorkWeekDay1Test(){
        plot = new Plot();
    }
    @Test
    public void morningTest(){
     }

    public void RideHorse(){
        List<Person> farmerList = plot.getFarm().getFarmHouse().getItems();
        farmerList.forEach(person -> {
            if(person instanceof Farmer) {
                for (Horse horse : plot.getFarm().getHorses()) {
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });
    }
}
