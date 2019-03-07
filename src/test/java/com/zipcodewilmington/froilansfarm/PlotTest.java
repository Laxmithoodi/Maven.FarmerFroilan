package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Horse;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.edible.EarCorn;
import com.zipcodewilmington.froilansfarm.edible.EdibleEgg;
import com.zipcodewilmington.froilansfarm.edible.Tomato;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlotTest {

    private Plot plot;

    @Before
    public void setUp() throws Exception {
        plot = new Plot();
        morningRoutines();
    }

    @Test
    public void testMonday() {
        Farmer frolianda =  plot.getFroilanda();
        CropDuster cropDuster = new CropDuster(); //get ...
        cropDuster.fly();
        Field field = new Field(); //
        field.getCropRows().forEach(cropDuster::fertilize);

    }

    @Test
    public void testTuesday() {

    }


    private void morningRoutines() {
        List<Person> farmers = plot.getFarm().getFarmHouse().getItems();
        farmers.forEach(person -> {
            if(person instanceof Farmer) {
                for (Horse horse : plot.getFarm().getHorses()) {
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });
        plot.getFarm().getHorses().forEach(horse -> horse.eat(new EarCorn()));

        getFroilanFarmer().eat(new EarCorn());
        plot.getFroilan().eat(new Tomato());
        plot.getFroilan().eat(new Tomato());
        for(int i = 0; i < 5; ++i) {
            plot.getFroilan().eat(new EdibleEgg());
        }

        //to continue

    }
    Farmer getFroilanFarmer(){
        return (Farmer) plot.getFarm().getFarmHouse().getItems();
        return plot.getFarm().addFarmerToFarm("froilan");

    }

}