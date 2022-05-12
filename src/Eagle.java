public class Eagle extends Predator implements PopulationIslands{
    private String nameAnimal = "eagle";
    private Double weightAnimal = 6.0;
    private int maxSpeedAnimal = 4;
    private Double fullSaturationAnimal = 1.0;
    private int maxTactAnimal = 5;
    private String avatarAnimal ="\uD83E\uDD85";
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
    public Eagle reproduction() {
        return new Eagle();
    }
}
