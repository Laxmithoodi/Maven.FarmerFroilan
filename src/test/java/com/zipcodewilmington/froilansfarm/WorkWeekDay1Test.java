package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Horse;
import com.zipcodewilmington.froilansfarm.animal.Person;
import org.junit.Test;

import java.util.List;

public class WorkWeekDay1Test {
    FroilanFarm froilanFarm;
    public WorkWeekDay1Test(){
        froilanFarm = new FroilanFarm();
    }
    @Test
    public void morningTest(){
     }

    public void RideHorse(){
        List<Person> farmerList = froilanFarm.getFarm().getFarmHouse().getItems();
        farmerList.forEach(person -> {
            if(person instanceof Farmer) {
                for (Horse horse : froilanFarm.getFarm().getHorses()) {
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });
    }
}
