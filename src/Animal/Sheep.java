package Animal;

import Plants.Plants;

import java.util.*;

public class Sheep extends Animal implements Herbivore {
    private Double currentTact;
    private String nameAnimal = "sheep";
    private Double weightAnimal = 45.0;
    private int maxSpeedAnimal = 1;
    private Double fullSaturationAnimal = 7.0;
    private int maxTactAnimal = 5;
    private String avatarAnimal ="\uD83D\uDC11";
    public Map mapOfMenu = Map.of(new Plants(false, false), 100);
    private boolean isEaten;
    private boolean isExtra;
    private boolean isWeek;

    public Sheep(Double currentTact, boolean isEaten, boolean isExtra, boolean isWeek) {
        super(currentTact);
        this.isEaten = isEaten;
        this.isExtra = isExtra;
        this.isWeek = isWeek;
    }

    @Override
    public Double getCurrentTact() {
        return currentTact;
    }

    @Override
    public void setCurrentTact(Double currentTact) {
        this.currentTact = currentTact;
    }

    @Override
    public boolean isWeek() {
        return isWeek;
    }

    @Override
    public void setWeek(boolean week) {
        isWeek = week;
    }

    @Override
    public boolean isEaten() {
        return isEaten;
    }

    @Override
    public void setEaten(boolean eaten) {
        isEaten = eaten;

    }

    @Override
    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public Double getWeightAnimal() {
        return weightAnimal;
    }

    public void setWeightAnimal(Double weightAnimal) {
        this.weightAnimal = weightAnimal;
    }

    public int getMaxSpeedAnimal() {
        return maxSpeedAnimal;
    }

    public void setMaxSpeedAnimal(int maxSpeedAnimal) {
        this.maxSpeedAnimal = maxSpeedAnimal;
    }

    public Double getFullSaturationAnimal() {
        return fullSaturationAnimal;
    }

    public void setFullSaturationAnimal(Double fullSaturationAnimal) {
        this.fullSaturationAnimal = fullSaturationAnimal;
    }

    public int getMaxTactAnimal() {
        return maxTactAnimal;
    }

    public void setMaxTactAnimal(int maxTactAnimal) {
        this.maxTactAnimal = maxTactAnimal;
    }

    public String getAvatarAnimal() {
        return avatarAnimal;
    }

    public void setAvatarAnimal(String avatarAnimal) {
        this.avatarAnimal = avatarAnimal;
    }



    @Override
    public Sheep reproduction() {
        return new Sheep(7.0, false, false, false);
    }

    @Override
    List<Animal> move(Map<String, List<Object>> map) {
        return null;
    }

    @Override
    void end(Map<String, List<Object>> map) {

    }

    @Override
    public Integer eat(Animal animal, List<List<Object>> listCellAnimal) {
        Integer countEatenPlants = 0;
        List listOfEatenPlants = new ArrayList();
        Sheep sheep = (Sheep) animal;
        List<Plants> listFood = new ArrayList(mapOfMenu.keySet());
        Plants indexOfListFood = listFood.get(0);;
        //Integer proc = (Integer) mapOfMenu.get(indexOfListFood);
        if(sheep.fullSaturationAnimal <= this.getFullSaturationAnimal()) {
            double calories = indexOfListFood.getWeightPlants();
            double fullSaturationNow = sheep.fullSaturationAnimal;

            Iterator iterator = listCellAnimal.iterator();
            while (iterator.hasNext()) {
                List<Object> listIterator = (List<Object>) iterator.next();
                if (listIterator.get(0).getClass().equals(listFood.get(0).getClass())) {
                    Collection<Object> collection = listIterator;
                    listOfEatenPlants = (collection.stream().takeWhile(object -> object.getClass().equals(listFood.get(0).getClass()) && listFood.get(0).isEaten() == false).findFirst().stream().toList());

                }
            }
                if (calories <= this.fullSaturationAnimal - fullSaturationNow) {
                    fullSaturationNow = fullSaturationNow + calories;
                } else {

                    fullSaturationNow = fullSaturationAnimal;
                }
                sheep.setFullSaturationAnimal(fullSaturationNow);



            }
        Plants plantsFood =(Plants) listOfEatenPlants.get(0);

        plantsFood.setEaten(true);
        System.out.println(plantsFood + "$$$$$$$" + plantsFood.isEaten());
        countEatenPlants ++;

        return countEatenPlants;

    }

}

