package Animal;

import Plants.Plants;

import java.util.List;
import java.util.Map;

public class Duck extends Animal{
    private Integer maxOnCell = 200;;
    private String nameAnimal = "duck";
    private Double weightAnimal =1.0;
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
}
