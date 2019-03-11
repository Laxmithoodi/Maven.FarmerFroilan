package com.zipcodewilmington.froilansfarm.storage;

import com.zipcodewilmington.froilansfarm.mammal.Chicken;
import com.zipcodewilmington.froilansfarm.mammal.Horse;
import com.zipcodewilmington.froilansfarm.mammal.Person;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.edible.Edible;
import com.zipcodewilmington.froilansfarm.edible.EdibleEgg;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicle.Tractor;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Farm {
    Field field;
    List<Stable> stables = new ArrayList<Stable>();
    List<ChickenCoop> chickenCoops = new ArrayList<ChickenCoop>();
    FarmHouse farmHouse;
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    List<Edible> harvestedEgg = new ArrayList<>();

    public Farm(){
        farmHouse = new FarmHouse();
        field = new Field();
    }

    public void addChickenCoop(ChickenCoop chickenCoop) {
        chickenCoops.add(chickenCoop);
    }

    public void addVehicles(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public <T extends Crop> void CreateCropRowInField(Supplier<T> cropSupplier, int numberOfCrops) {
        CropRow cropRow = new CropRow();
        cropRow.addCropRow(cropSupplier, numberOfCrops);

        field.add(cropRow);
    }

    public <H extends ChickenCoop, A extends Chicken>
    void addChickenCoopToFarm(Supplier<H> houseSupplier, Supplier<A> animalSupplier,
                                                          int numberOfCoops, int numberOfChickens)
    {
        for (int i = 0; i < numberOfCoops; i++) {

            ChickenCoop chickenCoop = houseSupplier.get();
            addChickenCoop(chickenCoop);
        }
        for (int i = 0; i < numberOfChickens; i++) {
            chickenCoops.get(i%numberOfCoops).add(animalSupplier.get());
        }
    }

    public <H extends Stable, A extends Horse>
    void addStablesToFarm(Supplier<H> houseSupplier, Supplier<A> animalSupplier,
                          int numberOfStables, int numberOfHorses) {
        for (int i = 0; i < numberOfStables; i++) {
            Stable stable = houseSupplier.get();
            stables.add(stable);
        }
        for (int i = 0; i < numberOfHorses; i++) {
            stables.get(i%numberOfStables).add(animalSupplier.get());
        }
    }

    public void addFarmerToFarmHouse(Person person) {
         farmHouse.add(person);
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public List<Horse> getHorses() {
        return stables.stream()
                .flatMap(horses-> horses.getItems().stream())
                .collect(Collectors.toList());
    }
    public List<Chicken> getChickens() {
        return chickenCoops.stream()
                .flatMap(chickens-> chickens.getItems().stream())
                .collect(Collectors.toList());
    }

    public Field getField() {
        return field;
    }

    public CropDuster getCropDuster(){
        Optional<Vehicle> filteredVehicle = vehicles.stream()
                .filter(vehicle -> vehicle instanceof CropDuster)
                .findFirst();

        return (CropDuster)filteredVehicle.orElse(null);

    }

    public Tractor getTractor(){

        Optional<Vehicle> filteredVehicle = vehicles.stream()
                .filter(vehicle -> vehicle instanceof Tractor)
                .findFirst();

        return (Tractor) filteredVehicle.orElse(null);

    }

    public List<CropRow> getCropRows(){
        return field.getItems();
    }

    public CornStalk getHarvestedCornStalk(){
        return getTractor().popEarCorn();

    }

    public TomatoPlant getHarvestedTomatoPlant(){
        return getTractor().popTomatoPlant();
    }

    public GenericVegetation getHarvestedGenericVegetation(){
        return getTractor().popGenericVegetation();
    }

    public EdibleEgg popEdibleEgg(){
        EdibleEgg egg = (EdibleEgg)harvestedEgg.get(0);
        harvestedEgg.remove(egg);
        return egg;
    }

    public void harvest(){
        field.getItems().forEach(cropRow -> cropRow.getItems()
                        .forEach(crop->getTractor().harverst(crop)));

        getChickens().stream()
                .forEach(chicken -> harvestedEgg.add(chicken.yield()));
    }

    public void fertilise(){
        CropDuster cropDuster = getCropDuster();
        cropDuster.operate(this);
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    public List<Vehicle> getAircrafts() {
        return vehicles.stream()
                .filter(vehicle -> vehicle instanceof Tractor)
                .collect(Collectors.toList());

    }
}
