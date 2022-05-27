package Animal;

import Plants.Plants;

import java.util.List;
import java.util.Map;

public class Deer extends Animal {
    private Double currentTact;
    private String nameAnimal = "deer";
    private Double weightAnimal = 170.0;
    private int maxSpeedAnimal = 3;
    private Double fullSaturationAnimal = 26.0;
    private int maxTactAnimal = 4;
    private String avatarAnimal = "\uD83E\uDD8C";
    public Map mapOfMenu = Map.of(new Plants(false, false), 100);
    private boolean isEaten;
    private boolean isExtra;
    private boolean isWeek;

    public Deer(Double currentTact, boolean isEaten, boolean isExtra, boolean isWeek) {
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
    public Deer reproduction() {
        return new Deer(26.0, false, false, false);
    }

    @Override
    List<Animal> move(Map<String, List<Object>> map) {
        return null;
    }

    @Override
    void end(Map<String, List<Object>> map) {

    }
}
