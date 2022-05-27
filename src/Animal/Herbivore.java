package Animal;

import Plants.Plants;

import java.util.HashMap;
import java.util.List;

public interface Herbivore {
    Integer eat(Animal animal, List<List<Object>> listCellAnimal);
}
