package Plants;

public class Plants {
    private static Integer maxOnCell = 10000;
    private static String avatarPlants = "\uD83C\uDF3F";
    private String namePlants = "plants";
    private Double weightPlants = 1.0;
    private boolean isEaten = false;
    private boolean isExtra = false;

    public Plants(Double weightPlants) {
        this.weightPlants = weightPlants;
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

    public Integer getMaximum() {
        return maxOnCell;
    }

    public String getNamePlants() {
        return namePlants;
    }

    public void setNamePlants(String namePlants) {
        this.namePlants = namePlants;
    }

    public Double getWeightPlants() {
        return weightPlants;
    }

    public void setWeightPlants(Double weightPlants) {
        this.weightPlants = weightPlants;
    }

    public static String getAvatarPlants() {
        return avatarPlants;
    }

    public void setAvatarPlants(String avatarPlants) {
        this.avatarPlants = avatarPlants;
    }


}