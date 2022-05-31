package Animal;

import java.util.*;

public class Eagle extends Animal implements Predator {
    private Integer maxOnCell = 20;
    private String nameAnimal = "eagle";
    private Double weightAnimal = 6.0;
    private int maxSpeedAnimal = 4;
    private Double fullSaturationAnimal = 1.0;
    private int maxTactAnimal = 5;
    private String avatarAnimal = "\uD83E\uDD85";
    public Map mapOfMenu = Map.of(new Fox(4.0, 1.0), 10, new Rabbit(3.0, 0.45), 90, new Hamster(0.03, 0.075), 90, new Duck(1.0, 0.15), 80);
    private boolean isEaten = false;
    private boolean isExtra = false;
    private boolean isWeek = false;

    public Eagle(Double weightAnimal, Double fullSaturationAnimal) {
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

    @Override
    public Eagle reproduction() {
        return new Eagle(6.0, 1.0);
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

        Eagle eagle = (Eagle) animal;
        int number = new Random().nextInt(0, mapOfMenu.size());
        List<Animal> listFood = new ArrayList(mapOfMenu.keySet());
        Animal randomIndexOfListFood = listFood.get(number);
        Integer proc = (Integer) mapOfMenu.get(listFood.get(number));
        int randBeEaten = new Random().nextInt(0, 101);
        if (randBeEaten <= proc) {
            if (eagle.getFullSaturationAnimal() <= this.getFullSaturationAnimal()) {

                double calories = randomIndexOfListFood.getWeightAnimal();
                double fullSaturationNow = eagle.getFullSaturationAnimal();

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

                eagle.setFullSaturationAnimal(fullSaturationNow);


            }

        }

        return countEatenAnimal;

    }

}

