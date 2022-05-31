package Animal;

import Plants.Plants;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Duck extends Animal implements Predator, Herbivore {
    private Integer maxOnCell = 200;
    ;
    private String nameAnimal = "duck";
    private Double weightAnimal = 1.0;
    private int maxSpeedAnimal = 1;
    private Double fullSaturationAnimal = 0.15;
    private int maxTactAnimal = 4;
    private String avatarAnimal = "\uD83E\uDD86";
    public Map mapOfMenu = Map.of(new Caterpillar(0.01, 0.0025), 90, new Plants(1.0), 100);
    private boolean isEaten = false;
    private boolean isExtra = false;
    private boolean isWeek = false;

    @Override
    public Map getMapOfMenu() {
        return mapOfMenu;
    }

    @Override
    public void setMapOfMenu(Map mapOfMenu) {
        this.mapOfMenu = mapOfMenu;
    }

    @Override
    public boolean isWeek() {
        return isWeek;
    }

    @Override
    public void setWeek(boolean week) {
        isWeek = week;
    }

    public Duck(Double weightAnimal, Double fullSaturationAnimal) {
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
    public Duck reproduction() {
        return new Duck(1.0, 0.15);
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
        Integer countEatenAnimal = 0;
        List<Animal> listFood = new ArrayList<>();
        Duck duck = (Duck) animal;
        for (Object entry : mapOfMenu.keySet()) {
            if (!entry.getClass().equals(Plants.class)) {
                listFood.add((Animal) entry);
            }
        }
        int number = new Random().nextInt(0, listFood.size());
        Animal randomIndexOfListFood = (Animal) listFood.get(number);
        Integer proc = (Integer) mapOfMenu.get(listFood.get(number));
        int randBeEaten = new Random().nextInt(0, 101);
        if (randBeEaten <= proc) {
            if (duck.getFullSaturationAnimal() <= this.getFullSaturationAnimal()) {

                double calories = randomIndexOfListFood.getWeightAnimal();
                double fullSaturationNow = duck.getFullSaturationAnimal();

                Iterator iterator = listCellAnimal.iterator();
                while (iterator.hasNext()) {
                    List<Object> iteratorList = (List<Object>) iterator.next();
                    if (!iteratorList.isEmpty() && iteratorList.get(0).getClass().equals(listFood.get(number).getClass())) {
                        ListIterator litrSub = iteratorList.listIterator();
                        while (litrSub.hasNext()) {
                            Animal animalOfEaten = (Animal) litrSub.next();
                            if (!animalOfEaten.isEaten()) {
                                animalOfEaten.setEaten(true);

                                countEatenAnimal++;


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

                duck.setFullSaturationAnimal(fullSaturationNow);


            }

        }

        return countEatenAnimal;

    }

    @Override
    public Integer eatHerbivore(Animal animal, List<List<Object>> listCellAnimal) {
        Integer countEatenPlants = 0;

        Duck duck = (Duck) animal;
        List<Plants> listFood = new ArrayList<>();
        for (Object entry : mapOfMenu.keySet()) {
            if (entry.getClass().equals(Plants.class)) {
                listFood.add((Plants) entry);
            }
        }


        Plants indexOfListFood = listFood.get(0);


        if (duck.getFullSaturationAnimal() <= this.getFullSaturationAnimal()) {
            double calories = indexOfListFood.getWeightPlants();
            double fullSaturationNow = duck.getFullSaturationAnimal();

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
            duck.setFullSaturationAnimal(fullSaturationNow);


        }

        return countEatenPlants;

    }

}

