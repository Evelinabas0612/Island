import Animal.*;
import Animal.Predator;
import Animal.Herbivore;
import Plants.Plants;

import java.util.*;
import java.util.stream.Stream;

public class IslindLife {


    public List<List<Object>> allEat(List<List<Object>> listCellAnimal) {
        Integer staticOfEatenAnimal = 0;
        Integer staticOfEatenPlants = 0;
        for (List list : listCellAnimal) {
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) list.get(i);
                    Integer foodPlants = herbivore.eat((Animal) herbivore, listCellAnimal);
                    staticOfEatenPlants = staticOfEatenPlants + foodPlants;
                    System.out.println("!!!!!!!!" + staticOfEatenPlants);
                }

                if (list.get(i) instanceof Predator) {
                    Predator predator = (Predator) list.get(i);
                    Integer foodAnimal = predator.eat((Animal) predator, listCellAnimal);
                    staticOfEatenAnimal = staticOfEatenAnimal + foodAnimal;
                    System.out.println("!!!!!!!!" + staticOfEatenAnimal);

                }


            }

        }
        return listCellAnimal;
    }

    public void allDelete(List<List<Object>> listCellAnimal) {
        List<Animal> listOfDelete = new ArrayList();
        Stream stream = listCellAnimal.stream();
        stream.forEach(lists -> {
            for (List<Object> list : listCellAnimal) {
                if (!list.get(0).getClass().equals(Plants.class)) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {

                        Animal animal = (Animal) list.get(i);
                        if (animal.isEaten() || animal.isExtra() || animal.isWeek()) {
                            listOfDelete.add(animal);
                        } else {
                            continue;
                        }

                    }
                }
            }

            System.out.println("=============" + listOfDelete);

        });


    }

    public List<Object> allReproduction(List<List<Object>> listCellAnimal) {
        List<Object> listNewObject = new ArrayList<>();
        Stream stream = listCellAnimal.stream();
        stream.forEach(lists -> {
            for (List<Object> list : listCellAnimal) {
                if (!list.get(0).getClass().equals(Plants.class)) {

                    if (!list.isEmpty() && list.size() % 2 == 0) {
                        int size = list.size() / 2;
                        int count = 1;
                        List listType = new ArrayList<>();
                        while (count <= size) {

                            Animal newborn = (Animal) list.get(0);
                            listType.add(newborn.reproduction());
                            count++;
                        }
                        listNewObject.add(listType);

                    }


                }


            }

        });
        return listNewObject;
    }

}