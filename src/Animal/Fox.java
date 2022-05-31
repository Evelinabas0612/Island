package Animal;

import java.util.List;
import java.util.Map;

public class Fox extends Animal{
    private Integer maxOnCell = 50;
    private String nameAnimal = "fox";
    private Double weightAnimal = 4.0;
    private int maxSpeedAnimal = 3;
    private Double fullSaturationAnimal = 1.0;
    private int maxTactAnimal = 8;
    private String avatarAnimal = "\uD83E\uDD8A";
    public Map mapOfMenu = Map.of(new Rabbit(3.0, 0.45),90, new Hamster(0.03, 0.075), 90, new Duck(1.0, 0.15), 80);
    private boolean isEaten = false;
    private boolean isExtra = false;
    private boolean isWeek = false;

    public Fox(Double weightAnimal, Double fullSaturationAnimal) {
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
   public Fox reproduction() {
        return new Fox(4.0, 1.0);
    }

    @Override
    List<Animal> move(Map<String, List<Object>> map) {
        return null;
    }

    @Override
    void end(Map<String, List<Object>> map) {

    }
}
