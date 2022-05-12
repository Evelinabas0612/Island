import java.util.ArrayList;

public class Plants implements PopulationIslands {
    private String namePlants = "plants";
    private Double weightPlants = 1.0;
    private String avatarPlants = "\uD83C\uDF3F";
    public boolean isEaten = false;
    public boolean isExtra = false;

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

    public String getAvatarPlants() {
        return avatarPlants;
    }

    public void setAvatarPlants(String avatarPlants) {
        this.avatarPlants = avatarPlants;
    }



    @Override
    public Plants reproduction() {
        return new Plants();
    }
}
