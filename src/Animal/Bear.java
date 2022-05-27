package Animal;

import java.util.List;
import java.util.Map;

public class Bear extends Animal{
    private Double currentTact;
    private String nameAnimal = "bear";
    private Double weightAnimal = 250.0;
    private int maxSpeedAnimal = 2;
    private Double fullSaturationAnimal = 38.0;
    private int maxTactAnimal = 15;
    private String avatarAnimal = "\uD83D\uDC3B";
    public Map mapOfMenu = Map.of(new Snake(1.0, false, false, false), 80, new Horse(45.0, false, false, false), 40, new Deer(26.0, false, false, false), 80, new Rabbit(1.0, false,false,false), 80, new Hamster(1.0, false,false,false),90,new Goat(10.0, false, false, false),70,new Sheep(7.0, false, false, false),70, new Duck(1.0, false,false,false),10,new Cow(53.0, false, false, false),20,new Kangaroo(7.0, false, false, false),50);
    private boolean isEaten;
    private boolean isExtra;
    private boolean isWeek;

    public Bear(Double currentTact, boolean isEaten, boolean isExtra, boolean isWeek) {
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
    public Bear reproduction() {
        return new Bear(38.0, false, false, false);
    }

    @Override
    List<Animal> move(Map<String, List<Object>> map) {
        return null;
    }

    @Override
    void end(Map<String, List<Object>> map) {

    }
}
