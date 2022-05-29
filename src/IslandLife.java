import Animal.*;
import Animal.Predator;
import Animal.Herbivore;
import Plants.Plants;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class IslandLife {


    public Map<String,Integer> allEat(List<List<Object>> listCellAnimal) {
        Integer staticOfEatenAnimal = 0;
        Integer staticOfEatenPlants = 0;
        Map<String,Integer> mapOfStat = new HashMap<>();
        for (List list : listCellAnimal) {
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) list.get(i);
                    Integer foodPlants = herbivore.eat((Animal) herbivore, listCellAnimal);
                    staticOfEatenPlants = staticOfEatenPlants + foodPlants;
                    //    System.out.println("!!!!!!!!" + staticOfEatenPlants);
                }

                if (list.get(i) instanceof Predator) {
                    Predator predator = (Predator) list.get(i);
                    Integer foodAnimal = predator.eat((Animal) predator, listCellAnimal);
                    staticOfEatenAnimal = staticOfEatenAnimal + foodAnimal;
                    //  System.out.println("!!!!!!!!" + staticOfEatenAnimal);

                }


            }

        }
        mapOfStat.put("Predator",staticOfEatenAnimal);
        mapOfStat.put("Herbivore", staticOfEatenPlants);
        return mapOfStat;
    }

    public List<Object> allDelete(List<List<Object>> listCellAnimal) {
        List<Object> listOfDelete = new ArrayList<>();
        ListIterator litr = listCellAnimal.listIterator();
        while (litr.hasNext()) {
            List<Object> list = (List<Object>) litr.next();
            if (!list.isEmpty() && !list.get(0).getClass().equals(Plants.class)) {

                ListIterator litrSub = list.listIterator();
                while (litrSub.hasNext()) {
                    Animal animal = (Animal) litrSub.next();
                    if (animal.isEaten() || animal.isExtra() || animal.isWeek()) {
                        listOfDelete.add(animal);
                        litrSub.remove();
                    } else {
                        continue;
                    }

                }
            }
        }

        //   System.out.println("=============" + listOfDelete);
        return listOfDelete;
    }

    public Map<Cell, Animal> allMove(Cell[][] newMap, List<List<Object>> listCellAnimal) {
        Map<Cell, Animal> cellMap = new HashMap<Cell, Animal>();
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap.length; j++) {
                Cell cell = new Cell(i, j);
                Cell cellNew = new Cell();

                ListIterator litr = listCellAnimal.listIterator();
                while (litr.hasNext()) {
                    List<Object> list = (List<Object>) litr.next();
                    if (!list.isEmpty() && !list.get(0).getClass().equals(Plants.class) && !list.get(0).getClass().equals(Caterpillar.class)) {

                        ListIterator litrSub = list.listIterator();
                        while (litrSub.hasNext()) {
                            Animal animal = (Animal) litrSub.next();
                            animal.setFullSaturationAnimal(animal.getFullSaturationAnimal()-animal.getFullSaturationAnimal()*0.1);
                            if(animal.getFullSaturationAnimal() <= 0){
                                animal.setWeek(true);

                            }
                            int speedAnimalNow = new Random().nextInt(1, animal.getMaxSpeedAnimal() + 1);
                            int numberMove = new Random().nextInt(0, 6);
                            if (numberMove == 0) {
                                continue;
                            }
                            if (numberMove == 1) {
                                if (cell.getHeight() - speedAnimalNow >= 0) {
                                    cellNew.setHeight(cell.getHeight() - speedAnimalNow);
                                    cellNew.setWidth(cell.getWidth());
                                    cellMap.put(cellNew, animal);
                                    litrSub.remove();
                                }
                            }
                            if (numberMove == 2) {
                                if (cell.getHeight() + speedAnimalNow < newMap.length) {
                                    cellNew.setHeight(cell.getHeight() + speedAnimalNow);
                                    cellNew.setWidth(cell.getWidth());
                                    cellMap.put(cellNew, animal);
                                    litrSub.remove();
                                }
                            }
                            if (numberMove == 3) {
                                if (cell.getWidth() - speedAnimalNow >= 0) {
                                    cellNew.setHeight(cell.getHeight());
                                    cellNew.setWidth(cell.getWidth() - speedAnimalNow);
                                    cellMap.put(cellNew, animal);
                                    litrSub.remove();
                                }

                            }
                            if (numberMove == 4) {
                                if (cell.getWidth() + speedAnimalNow < newMap.length) {
                                    cellNew.setHeight(cell.getHeight());
                                    cellNew.setWidth(cell.getWidth() + speedAnimalNow);
                                    cellMap.put(cellNew, animal);
                                    litrSub.remove();
                                }
                            }
                        }
                    }
                }
                // }
            }
        }
        System.out.println("^^^^^^^^^^^^^^^^!!!!!!!!!!" + cellMap);
        return cellMap;
    }


    public List<Object> allReproduction(List<List<Object>> listCellAnimal) {
        List<Object> listNewObject = new ArrayList<>();
        Stream stream = listCellAnimal.stream();
        stream.forEach(lists -> {
            for (List<Object> list : listCellAnimal) {
                if (!list.isEmpty() && !list.get(0).getClass().equals(Plants.class)) {

                    if (!list.isEmpty() && list.size() % 2 == 0) {
                        int size = list.size() / 2;
                        int count = new Random().nextInt(0, size);
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


    public Integer allPlantsGrow(List<List<Object>> listCellAnimal) {
        Integer countPlantsGrow = 0;
        List <Plants>  listPlants =  new ArrayList<Plants>();
        Stream stream = listCellAnimal.stream();
        stream.forEach(lists -> {
            for (List<Object> list : listCellAnimal) {
                if (!list.isEmpty() && list.get(0).getClass().equals(Plants.class)) {
                    ListIterator litr = list.listIterator();
                    while (litr.hasNext()) {
                        Plants plants = (Plants) litr.next();
                        if (plants.isEaten()) {
                            plants.setEaten(false);
                            listPlants.add(plants);
                        } else {
                            continue;
                        }


                    }

                }
            }
        });
            countPlantsGrow = countPlantsGrow + listPlants.size();
            return countPlantsGrow;
    }

    public void addNewbornsAndMigrants(List <Object> listNewObject,  Map <Cell, Animal> mapOfMove, List<List<Object>> listCellAnimal, Cell[][] newMap){

    }
}