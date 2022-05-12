package Plants;

public class Plants{
    private static int maximum = 10000;
    private static String avatarPlants = "\uD83C\uDF3F";
    private String namePlants = "plants";
    private Double weightPlants = 1.0;
    public boolean isEaten = false;
    public boolean isExtra = false;

    public static int getMaximum() {
        return maximum;
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


    public Plants reproduction() {
        return new Plants();
    }
}
