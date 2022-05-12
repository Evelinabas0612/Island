public class Caterpillar extends Herbivore implements PopulationIslands {
    private String nameAnimal = "caterpillar";
    private Double weightAnimal = 0.01;
    private int maxSpeedAnimal = 1;
    private Double fullSaturationAnimal = 0.0025;
    private int maxTactAnimal = 1;
    private String avatarAnimal = "\uD83D\uDC1B";
    public boolean isEaten = false;
    public boolean isExtra = false;

    @Override
    public String getNameAnimal() {
        return nameAnimal;
    }

    @Override
    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    @Override
    public Double getWeightAnimal() {
        return weightAnimal;
    }

    @Override
    public void setWeightAnimal(Double weightAnimal) {
        this.weightAnimal = weightAnimal;
    }

    @Override
    public int getMaxSpeedAnimal() {
        return maxSpeedAnimal;
    }

    @Override
    public void setMaxSpeedAnimal(int maxSpeedAnimal) {
        this.maxSpeedAnimal = maxSpeedAnimal;
    }

    @Override
    public Double getFullSaturationAnimal() {
        return fullSaturationAnimal;
    }

    @Override
    public void setFullSaturationAnimal(Double fullSaturationAnimal) {
        this.fullSaturationAnimal = fullSaturationAnimal;
    }

    @Override
    public int getMaxTactAnimal() {
        return maxTactAnimal;
    }

    @Override
    public void setMaxTactAnimal(int maxTactAnimal) {
        this.maxTactAnimal = maxTactAnimal;
    }

    @Override
    public String getAvatarAnimal() {
        return avatarAnimal;
    }

    @Override
    public void setAvatarAnimal(String avatarAnimal) {
        this.avatarAnimal = avatarAnimal;
    }


    @Override
    public Caterpillar reproduction() {
        return new Caterpillar();
    }
}
