public class Kangaroo extends Herbivore implements PopulationIslands{
    private String nameAnimal = "kangaroo";
    private Double weightAnimal = 47.0;
    private int maxSpeedAnimal = 2;
    private Double fullSaturationAnimal = 7.0;
    private int maxTactAnimal = 8;
    private String avatarAnimal ="\uD83E\uDD98";
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
    public Kangaroo reproduction() {
        return new Kangaroo();
    }
}
