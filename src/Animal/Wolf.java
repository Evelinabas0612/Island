package Animal;


import Plants.Plants;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Wolf extends Animal implements Predator {
    private Double currentTact;
    private String nameAnimal = "wolf";
    private Double weightAnimal = 50.0;
    private int maxSpeedAnimal = 3;
    private Double fullSaturationAnimal = 8.0;
    private int maxTactAnimal = 10;
    private String avatarAnimal = "\uD83D\uDC3A";
    public Map mapOfMenu = Map.of(new Horse(45.0, false, false, false), 10, new Deer(26.0, false, false, false), 15, new Rabbit(1.0, false, false, false), 60, new Hamster(1.0, false, false, false), 80, new Goat(10.0, false, false, false), 60, new Sheep(7.0, false, false, false), 70, new Duck(1.0, false, false, false), 40, new Cow(53.0, false, false, false), 10, new Kangaroo(7.0, false, false, false), 15);
    private boolean isEaten;
    private boolean isExtra;
    private boolean isWeek;


    public Wolf(Double currentTact, boolean isEaten, boolean isExtra, boolean isWeek) {
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


    public boolean isWeek() {
        return isWeek;
    }


    public void setWeek(boolean week) {
        isWeek = week;
    }


    public boolean isEaten() {
        return isEaten;
    }


    public void setEaten(boolean eaten) {
        isEaten = eaten;

    }


    public boolean isExtra() {
        return isExtra;
    }


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
    public Wolf reproduction() {
        return new Wolf(1.0, false, false, false);
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
        List listOfEatenAnimal = new ArrayList();
        Wolf wolf = (Wolf) animal;
        int number = new Random().nextInt(0, mapOfMenu.size());
        List<Animal> listFood = new ArrayList(mapOfMenu.keySet());
        Animal randomIndexOfListFood = listFood.get(number);
        Integer proc = (Integer) mapOfMenu.get(listFood.get(number));
        int randBeEaten = new Random().nextInt(0, 101);
        if (randBeEaten <= proc) {
            if (wolf.getFullSaturationAnimal() <= this.getFullSaturationAnimal()) {

                double calories = randomIndexOfListFood.getWeightAnimal();
                double fullSaturationNow = wolf.getFullSaturationAnimal();

                Iterator iterator = listCellAnimal.iterator();
                while (iterator.hasNext()) {
                    List<Object> iteratorList = (List<Object>) iterator.next();
                    if (!iteratorList.isEmpty() && iteratorList.get(0).getClass().equals(listFood.get(number).getClass())) {
                        ListIterator litrSub = iteratorList.listIterator();
                        while (litrSub.hasNext()) {
                            Animal animalOfEaten = (Animal) litrSub.next();
                            if (!animalOfEaten.isEaten()) {
                                animalOfEaten.setEaten(true);
                                System.out.println(animalOfEaten);
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

                wolf.setFullSaturationAnimal(fullSaturationNow);


            }

        }

        return countEatenAnimal;

        }

    }






