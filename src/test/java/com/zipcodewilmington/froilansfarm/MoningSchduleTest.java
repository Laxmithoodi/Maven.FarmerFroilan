package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.mammal.Chicken;
import com.zipcodewilmington.froilansfarm.mammal.Farmer;
import com.zipcodewilmington.froilansfarm.mammal.Horse;
import com.zipcodewilmington.froilansfarm.mammal.Person;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MoningSchduleTest {

    private Plot plot;
    private Farmer  frolianFarmer;
    private Farmer  froilandaFarmer;


    @Before
    public void setUp() {
        plot = new Plot();
        plot.getFarm().fertilise();
        plot.getFarm().harvest();
        frolianFarmer = plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolian.toString());
        froilandaFarmer = plot.getFarm().getFarmHouse().getFarmer(FarmerNames.frolianda.toString());
    }

    @Test
    public void morningRoutines() {
        List<Person> farmers = plot.getFarm().getFarmHouse().getItems();

        //RideHorse
        rideHorse();
        checkAllHorsesAreRidden();

        feedHorses();
        checkAllHorsesAte();

        feedChicken();
        checkAllChickensAte();

        haveBreakfast();
        checkIfFarmersHadBreakfast();
    }

    private void checkAllChickensAte() {
        List<Chicken> chickensThatDidNotEat = plot.getFarm().getChickens().stream()
                .filter(chicken->chicken.numberOfFoodTaken() == 0)
                .collect(Collectors.toList());

        Assert.assertEquals(chickensThatDidNotEat.size(), 0);
    }

    private void checkIfFarmersHadBreakfast() {
        Assert.assertNotEquals(froilandaFarmer.numberOfFoodTaken(), 0);
        Assert.assertNotEquals(frolianFarmer.numberOfFoodTaken(), 0);

    }

    private void rideHorse(){
        FarmHouse farmHouse = plot.getFarm().getFarmHouse();
        farmHouse.getItems().forEach(person ->{
            if(person instanceof Farmer){
                for(Horse horse : plot.getFarm().getHorses()){
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });
    }

    private void checkAllHorsesAte(){
        List<Horse> horsesThatDidNotEat = plot.getFarm().getHorses().stream()
                .filter(horse->horse.numberOfFoodTaken() == 0)
                .collect(Collectors.toList());

        Assert.assertEquals(horsesThatDidNotEat.size(), 0);

    }

    private void checkAllHorsesAreRidden(){
        List<Horse> horsesThatDidNotRide = plot.getFarm().getHorses().stream()
                .filter(horse->horse.hasRidden() == false)
                .collect(Collectors.toList());

        Assert.assertEquals(horsesThatDidNotRide.size(), 0);

    }

    private void feedHorses(){

        plot.getFarm().getHorses().forEach(horse -> {
            for(int i = 0; i < 3; i++){
                CornStalk cornStalk = plot.getFarm().getHarvestedCornStalk();
                horse.eat(cornStalk.yield());
            }
        });
    }

    private void feedChicken(){
        plot.getFarm().getChickens().forEach(chicken -> {
            for(int i = 0; i < 3; i++){
                GenericVegetation vegetation = plot.getFarm().getHarvestedGenericVegetation();
                chicken.eat(vegetation.yield());
            }
        });
    }

    private void haveBreakfast(){

        //Froilan Eats Breakfast
        CornStalk cornStalk = plot.getFarm().getHarvestedCornStalk();
        frolianFarmer.eat(cornStalk.yield());

        for(int i = 0; i < 2; i++){
            TomatoPlant tomatoPlant = plot.getFarm().getHarvestedTomatoPlant();
            frolianFarmer.eat(tomatoPlant.yield());
        }
        for(int i = 0; i < 5; i++){
            frolianFarmer.eat(plot.getFarm().popEdibleEgg());
        }

        //Froilanda Eats Breakfast
        for(int i = 0; i < 2; i++) {
            cornStalk = plot.getFarm().getHarvestedCornStalk();
            froilandaFarmer.eat(cornStalk.yield());
        }

        TomatoPlant tomatoPlant = plot.getFarm().getHarvestedTomatoPlant();
        froilandaFarmer.eat(tomatoPlant.yield());

        for(int i = 0; i < 2; i++){
            froilandaFarmer.eat(plot.getFarm().popEdibleEgg());
        }

    }

}
