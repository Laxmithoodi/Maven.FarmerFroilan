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
    private FarmHouse farmHouse;
    Farmer  frolianFarmer;
    Farmer froilandaFarmer;


    @Before
    public void setUp() throws Exception {
        plot = new Plot();
        frolianFarmer = plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolian.toString());
        froilandaFarmer = plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolianda.toString());
        morningRoutines();
    }

    @Test
    public void testMonday() {
        froilandaFarmer =  plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolianda.toString());
        CropDuster cropDuster = new CropDuster(); //get ...
        cropDuster.fly(froilandaFarmer);
        Field field = new Field(); //
        plot.getFarm().getField().getItems().forEach(cropDuster::fertilize);

    }

    @Test
    public void testTuesday() {

    }


    private void morningRoutines() {
        List<Person> farmers = plot.getFarm().getFarmHouse().getItems();
        farmHouse = new FarmHouse();
        farmers.forEach(person -> {
            if(person instanceof Farmer) {
                for (Horse horse : plot.getFarm().getHorses()) {
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });

        plot.getFarm().getHorses().forEach(horse -> horse.eat(new EarCorn()));

        froilandaFarmer.eat(new EarCorn());
        frolianFarmer.eat(new Tomato());
        Farmer frolianda =  plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolianda.toString());
        for(int i = 0; i < 5; ++i) {
            frolianFarmer.eat(new EdibleEgg());
        }


        //to continue

    }

}