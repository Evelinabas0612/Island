import Animal.*;
import Animal.Predator;
import Animal.Herbivore;
import Plants.Plants;

import java.util.*;

import java.util.stream.Stream;

public class IslandLife {


    public Map<String, Integer> allEat(List<List<Object>> listCellAnimal) {
        Integer staticOfEatenAnimal = 0;
        Integer staticOfEatenPlants = 0;
        Map<String, Integer> mapOfStat = new HashMap<>();
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


                }


            }

        }
        mapOfStat.put("Predator", staticOfEatenAnimal);
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
                    if (animal.isEaten() || animal.isWeek()) {
                        listOfDelete.add(animal);
                        litrSub.remove();
                    } else {
                        continue;
                    }

                }
            }
        }


        return listOfDelete;
    }

    public void allMove(Cell[][] newMap) {
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[i].length; j++) {

                List<List<Object>> listCellAnimal = new ArrayList<>(newMap[i][j].getMap().values());

                ListIterator litr = listCellAnimal.listIterator();
                while (litr.hasNext()) {
                    List<Object> list = (List<Object>) litr.next();
                    if (!list.isEmpty() && !list.get(0).getClass().equals(Plants.class) && !list.get(0).getClass().equals(Caterpillar.class)) {

                        ListIterator litrSub = list.listIterator();
                        while (litrSub.hasNext()) {
                            Animal animal = (Animal) litrSub.next();
                            animal.setFullSaturationAnimal(animal.getFullSaturationAnimal() - animal.getFullSaturationAnimal() * 0.1);
                            if (animal.getFullSaturationAnimal() <= 0) {
                                animal.setWeek(true);

                            }
                            int speedAnimalNow = new Random().nextInt(1, animal.getMaxSpeedAnimal() + 1);
                            int numberMove = new Random().nextInt(0, 6);
                            if (numberMove == 0) {
                                continue;
                            }
                            if (numberMove == 1) {
                                int height = i - speedAnimalNow;
                                if (height >= 0) {
                                    List <Animal> listMove = newMap[i - speedAnimalNow][j].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i - speedAnimalNow][j].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                }
                            }
                            if (numberMove == 2) {
                                int height = i + speedAnimalNow;

                                if (height < newMap.length) {

                                    List <Animal> listMove = newMap[i + speedAnimalNow][j].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i + speedAnimalNow][j].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                }
                            }
                            if (numberMove == 3) {

                                int width = j - speedAnimalNow;
                                if (width >= 0) {

                                    List <Animal> listMove  = newMap[i][j - speedAnimalNow].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i][j - speedAnimalNow].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                }

                            }
                            if (numberMove == 4) {

                                int width = j + speedAnimalNow;
                                if (width < newMap.length) {

                                    List <Animal> listMove  = newMap[i][j + speedAnimalNow].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i][j + speedAnimalNow].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                }
                            }
                        }
                    }
                }
            }
        }
        // }
        for (int i = 0; i < newMap.length - 1; i++) {
            for (int j = 0; j < newMap[i].length; j++) {

                Iterator iteratorForExtra = newMap[i][j].getMap().values().iterator();
                while (iteratorForExtra.hasNext()) {
                    List<Object> listExtra = (List<Object>) iteratorForExtra.next();
                    if (!listExtra.isEmpty() && !listExtra.get(0).getClass().equals(Plants.class)) {
                        for (int k = 0; k < listExtra.size(); k++) {
                            Animal animalExtra = (Animal) listExtra.get(k);
                            if (animalExtra.isExtra()) {
                                animalExtra.setExtra(false);
                                listExtra.remove(animalExtra);
                            }


                        }
                    }
                }


            }
        }
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
        List<Plants> listPlants = new ArrayList<>();
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

    public void addNewborns(List<Object> listNewObject, List<List<Object>> listCellAnimal) {

        ListIterator litr = listCellAnimal.listIterator();
        while (litr.hasNext()) {
            List<Object> list = (List<Object>) litr.next();


            if (!list.isEmpty()) {
                for (int i = 0; i < listNewObject.size(); i++) {
                    List<Animal> animalListTemp = (List) listNewObject.get(i);
                    if (!animalListTemp.isEmpty()) {
                        for (Animal animal : animalListTemp) {
                            if (list.get(0).getClass().equals(animal.getClass())) {
                                int countMaxAnimal = animal.getCurrentTact();
                                if (list.size() < countMaxAnimal) {
                                    list.add(animal);

                                }


                            }
                        }
                    }
                }
            } else {
                continue;
            }


        }
    }


    public void addMigrants(Cell[][] newMap) {
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[i].length; j++) {

                List<List<Object>> listCellAnimal = new ArrayList<>(newMap[i][j].getMap().values());

                List<Animal> mapOfMove = newMap[i][j].getMapOfMove();
                if (!mapOfMove.isEmpty()) {
                    ListIterator ListIterMap = mapOfMove.listIterator();
                    while (ListIterMap.hasNext()) {
                        Animal animalMove = (Animal) ListIterMap.next();

                        ListIterator iterList = listCellAnimal.listIterator();
                        while (iterList.hasNext()) {

                            List<Object> listOne = (List<Object>) iterList.next();


                            if (!listOne.isEmpty() && listOne.get(0).getClass().equals(animalMove)) {

                                Integer countMaxAnimal = animalMove.getCurrentTact();
                                if (listOne.size() < countMaxAnimal) {
                                    System.out.print("!!!!!!!!!!!!!" + listOne.size());
                                    listOne.add(animalMove);
                                    System.out.println("!!!!!!!!!!!!!" + listOne.size() + "***" + animalMove);
                                } else {
                                    continue;
                                }


                            } else {
                                continue;
                            }

                        }
                    }
                }


            }
        }

    }
}
