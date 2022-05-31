package Animal;

import Plants.Plants;

import java.util.*;

public class Hamster extends Animal implements Herbivore{
    private Integer maxOnCell = 500;
    private String nameAnimal = "hamster";
    private Double weightAnimal = 0.03;
    private int maxSpeedAnimal = 1;
    private Double fullSaturationAnimal = 0.075;
    private int maxTactAnimal = 3;
    private String avatarAnimal = "\uD83D\uDC39";
    public Map mapOfMenu = Map.of(new Plants(1.0), 100);
    private boolean isEaten = false;
    private boolean isExtra = false;
    private boolean isWeek = false;

    public Hamster(Double weightAnimal, Double fullSaturationAnimal) {
        super(weightAnimal, fullSaturationAnimal);

    }

    @Override
    public Integer getCurrentTact() {
        return maxOnCell;
    }

    @Override
    public void setCurrentTact(Integer maxOnCell) {
        this.maxOnCell = maxOnCell;
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
    public Hamster reproduction() {
        return new Hamster(0.03, 0.075);
    }

    @Override
    List<Animal> move(Map<String, List<Object>> map) {
        return null;
    }

    @Override
    void end(Map<String, List<Object>> map) {

    }

    @Override
    public Integer eatHerbivore(Animal animal, List<List<Object>> listCellAnimal) {
        Integer countEatenPlants = 0;

        Hamster hamster = (Hamster) animal;
        List<Plants> listFood = new ArrayList(mapOfMenu.keySet());
        Plants indexOfListFood = listFood.get(0);;

        if(hamster.getFullSaturationAnimal() <= this.getFullSaturationAnimal()) {
            double calories = indexOfListFood.getWeightPlants();
            double fullSaturationNow = hamster.getFullSaturationAnimal();

            Iterator iterator = listCellAnimal.iterator();
            while (iterator.hasNext()) {

                List<Object> iteratorList = (List<Object>) iterator.next();
                if (!iteratorList.isEmpty() && iteratorList.get(0).getClass().equals(listFood.get(0).getClass())) {

                    ListIterator litrSub = iteratorList.listIterator();
                    while (litrSub.hasNext()) {
                        Plants plantsOfEaten = (Plants) litrSub.next();
                        if (!plantsOfEaten.isEaten()) {
                            plantsOfEaten.setEaten(true);

                            countEatenPlants++;


                        } else {
                            continue;
                        }
                        break;
                    }
                }
            }
            if (calories <= this.fullSaturationAnimal - fullSaturationNow) {
                fullSaturationNow = fullSaturationNow + calories;
            } else {

                fullSaturationNow = fullSaturationAnimal;
            }
            hamster.setFullSaturationAnimal(fullSaturationNow);



        }

        return countEatenPlants;

    }

}
