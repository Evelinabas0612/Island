import Animal.*;
import Animal.Predator;
import Animal.Herbivore;
import Plants.Plants;

import java.util.*;

import java.util.stream.Stream;

public class IslandLife implements Runnable {
    private int day = 0;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
//public ExecutorService executorService;


    public Cell[][] createIslandMap(int height, int width) {
        Cell[][] newMap = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newMap[i][j] = new Cell();
                newMap[i][j].setMap(getMapOfPopulation());


            }
        }

        printIsland(newMap);
        return newMap;
    }

    public void oneDay(Cell[][] newMap) {
        int allNewbornForTact = 0;
        int allDeleteForTact = 0;
        int allEatenForTact = 0;
        int allPlantsGrow = 0;
        int allMigrant = 0;
        //  executorService = Executors.newCachedThreadPool();

        for (Cell[] cells : newMap) {
            for (Cell cell : cells) {
                List<List<Object>> listCellAnimal = new ArrayList<>(cell.getMap().values());
                List<Object> listOfDeleteWeek = allDelete(listCellAnimal);
                Map<String, Integer> mapOfStatEaten = allEat(listCellAnimal);

                List<Object> listOfDeleteEaten = allDelete(listCellAnimal);

                List<Object> listNewborns = allReproduction(listCellAnimal);

                addNewborns(listNewborns, listCellAnimal);

                Integer countPlantsGrow = allPlantsGrow(listCellAnimal);

                allNewbornForTact += listNewborns.size();

                allDeleteForTact += listOfDeleteWeek.size() + listOfDeleteEaten.size();
                allEatenForTact += listOfDeleteEaten.size();
                allPlantsGrow += countPlantsGrow;
                System.out.println();
                System.out.println("Статистика по ячейке:");
                System.out.println("Родилось всего животных в ячейке:" + listNewborns.size());
                System.out.println("Съедено в ячейке:" + listOfDeleteEaten.size());

            }

        }
        System.out.println();
        System.out.println("Статистика:");
        System.out.println("Родилось всего животных:" + allNewbornForTact);
        System.out.println("Новые растения:" + allPlantsGrow);
        System.out.println("Вымерло всего: " + allDeleteForTact + " : из них съедено:" + allEatenForTact);

        allMigrant += allMove(newMap);
        addMigrants(newMap);

        System.out.println("Всего переселилось:" + allMigrant);
        //printIsland(newMap);


    }


    public static Object getPopulationIsland(PopulationIlandsTypes type) {
        Object obj = null;
        switch (type) {
            case PLANTS -> obj = new Plants(1.0);
            case BEAR -> obj = new Bear(250.0, 38.0);
            case KANGAROO -> obj = new Kangaroo(47.0, 7.0);
            case CATERPILLAR -> obj = new Caterpillar(0.01, 0.0025);
            case DEER -> obj = new Deer(170.0, 26.0);
            case DUCK -> obj = new Duck(1.0, 0.15);
            case EAGLE -> obj = new Eagle(6.0, 1.0);
            case FOX -> obj = new Fox(4.0, 1.0);
            case GOAT -> obj = new Goat(65.0, 10.0);
            case HAMSTER -> obj = new Hamster(0.03, 0.075);
            case HORSE -> obj = new Horse(300.0, 45.0);
            case RABBIT -> obj = new Rabbit(3.0, 0.45);
            case SHEEP -> obj = new Sheep(45.0, 7.0);
            case SNAKE -> obj = new Snake(2.0, 0.03);
            case WOLF -> obj = new Wolf(50.0, 8.0);
            case COW -> obj = new Cow(350.0, 53.0);
        }

        return obj;
    }

    public static int getRandomNumber() {
        int a = (int) (Math.random() * 1000);
        return a;
    }

    public static Map<String, List<Object>> getMapOfPopulation() {
        Map<String, List<Object>> map = new HashMap<>();
        PopulationIlandsTypes[] types = PopulationIlandsTypes.values();


        for (int i = 0; i < types.length; i++) {

            ArrayList<Object> arrayList = new ArrayList<>();
            int numberOfRandom = getRandomNumber();
            if (numberOfRandom > types[i].maximumPopulationType) {
                numberOfRandom = types[i].maximumPopulationType;
            }
            int count = 1;

            while (count <= numberOfRandom) {
                Object type = getPopulationIsland(types[i]);
                arrayList.add(type);
                count++;
            }

            //      System.out.print(" [" + types[i].avatar + "(" + types[i] + ")" + " = " + arrayList.size() + "] ");
            map.put(types[i].avatar, arrayList);


        }


        return map;
    }


    public Map<String, Integer> allEat(List<List<Object>> listCellAnimal) {
        Integer staticOfEatenAnimal = 0;
        Integer staticOfEatenPlants = 0;
        Map<String, Integer> mapOfStat = new HashMap<>();
        for (List list : listCellAnimal) {
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) list.get(i);
                    Integer foodPlants = herbivore.eatHerbivore((Animal) herbivore, listCellAnimal);
                    staticOfEatenPlants = staticOfEatenPlants + foodPlants;

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

    public Integer allMove(Cell[][] newMap) {
        Integer countMigrant = 0;
        for (int i = 0; i < newMap.length - 1; i++) {
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
                                    List<Animal> listMove = newMap[i - speedAnimalNow][j].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i - speedAnimalNow][j].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                    countMigrant++;
                                }
                            }
                            if (numberMove == 2) {
                                int height = i + speedAnimalNow;

                                if (height < newMap.length) {

                                    List<Animal> listMove = newMap[i + speedAnimalNow][j].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i + speedAnimalNow][j].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                    countMigrant++;
                                }
                            }
                            if (numberMove == 3) {

                                int width = j - speedAnimalNow;
                                if (width >= 0) {

                                    List<Animal> listMove = newMap[i][j - speedAnimalNow].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i][j - speedAnimalNow].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                    countMigrant++;
                                }

                            }
                            if (numberMove == 4) {

                                int width = j + speedAnimalNow;
                                if (width < newMap.length) {

                                    List<Animal> listMove = newMap[i][j + speedAnimalNow].getMapOfMove();
                                    listMove.add(animal);
                                    newMap[i][j + speedAnimalNow].setMapOfMove(listMove);
                                    animal.setExtra(true);
                                    countMigrant++;
                                }
                            }
                        }
                    }
                }
            }
        }
        // }
        for (int i = 0; i < newMap.length; i++) {
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
        return countMigrant;
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


                            if (!listOne.isEmpty() && listOne.get(0).getClass().equals(animalMove.getClass())) {

                                Integer countMaxAnimal = animalMove.getCurrentTact();
                                if (listOne.size() < countMaxAnimal) {

                                    listOne.add(animalMove);

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


    public void printIsland(Cell[][] newMap) {

        for (Cell[] cells : newMap) {
            for (Cell cell : cells) {
                List<List<Object>> listCellAnimal = new ArrayList<>(cell.getMap().values());
                ListIterator litr = listCellAnimal.listIterator();
                while (litr.hasNext()) {
                    List<Object> list = (List<Object>) litr.next();
                    if (!list.isEmpty() && list.get(0).getClass().equals(Plants.class)) {
                        Plants plants = (Plants) list.get(0);
                        String avatar = plants.getAvatarPlants();
                        System.out.print(avatar);
                    }
                    if (!list.isEmpty() && !list.get(0).getClass().equals(Plants.class)) {
                        Animal animal = (Animal) list.get(0);
                        String avatar = animal.getAvatarAnimal();
                        System.out.print(avatar);
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
        int newDay = getDay();
        while (newDay < 1000) {
            System.out.println("День" + newDay);

            newDay++;
        }
    }
}
