package com.zipcodewilmington.froilansfarm.storage;

import com.zipcodewilmington.froilansfarm.animal.Chicken;
import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Horse;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.animal.interfaces.Animal;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.edible.Edible;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.FarmVehicle;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Farm {
    Field field;
    List<Stable> stables = new ArrayList<Stable>();
    List<ChickenCoop> chickenCoops = new ArrayList<ChickenCoop>();
    FarmHouse farmHouse;
    List<Vehicle> vehicles = new ArrayList<Vehicle>();

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

    public void setFarmHouse(FarmHouse farmHouse) {
        this.farmHouse = farmHouse;
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

    public Aircraft getAvailableAirCraft(){
        Aircraft aircraft = null;
        for (Vehicle vehicle: vehicles){
            if(vehicle instanceof Aircraft){
                vehicles.remove(vehicle);
                aircraft = (Aircraft) vehicle;
                break;
            }
        }
        return  aircraft;
    }

    public FarmVehicle getAvailableFarmVehicle(){
        FarmVehicle farmVehicle = null;
        for (Vehicle vehicle: vehicles){
            if(vehicle instanceof Aircraft){
                vehicles.remove(vehicle);
                farmVehicle = (FarmVehicle) vehicle;
                break;
            }
        }
        return  farmVehicle;
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public List<Horse> getHorses() {
        List<Horse> horses = new ArrayList<Horse>();
        for(Stable stable : stables){
            horses.addAll(stable.getItems());
        }
        return horses;
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

    public List<CropRow> getCropRows() {
        return null;
    }
}
