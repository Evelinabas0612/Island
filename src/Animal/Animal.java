package Animal;

import java.util.List;
import java.util.Map;

public abstract class Animal {
    private Integer maxOnCell;
    private String nameAnimal;
    private Double weightAnimal;
    private int maxSpeedAnimal;
    private Double fullSaturationAnimal;
    private String avatarAnimal;
    private Map  mapOfMenu;
    private boolean isEaten; // пометка съедено ли животное
    private boolean isExtra; //не лишнее ли животное на клетке
    private boolean isWeek; //// пометка, что животное полностью истощено

    public Animal(Double weightAnimal, Double fullSaturationAnimal) {
        this.weightAnimal = weightAnimal;
        this.fullSaturationAnimal = fullSaturationAnimal;
    }

    public Integer getCurrentTact() {
        return maxOnCell;
    }

    public void setCurrentTact(Integer maxOnCell) {
        this.maxOnCell= maxOnCell;
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

    public String getAvatarAnimal() {
        return avatarAnimal;
    }

    public void setAvatarAnimal(String avatarAnimal) {
        this.avatarAnimal = avatarAnimal;
    }

    public Map getMapOfMenu() {
        return mapOfMenu;
    }

    public void setMapOfMenu(Map mapOfMenu) {
        this.mapOfMenu = mapOfMenu;
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

    public boolean isWeek() {
        return isWeek;
    }

    public void setWeek(boolean week) {
        isWeek = week;
    }



    public abstract Animal reproduction();
    abstract List<Animal> move(Map<String, List<Object>> map);
    abstract void end(Map<String, List<Object>> map);



}
