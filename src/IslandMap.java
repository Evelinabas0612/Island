

import Animal.*;
import Plants.Plants;

import java.util.*;

public class IslandMap {



    public static Cell [][] createIslandMap(int height, int width) {
        Cell[][] islandMap = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                islandMap[i][j].map = IslandMap.getMapOfPopulation();


            }
            System.out.println();
        }
        return islandMap;
    }

    public static Object getPopulationIsland(PopulationIlandsTypes type) {
       Object obj = null;
        switch (type) {
            case PLANTS -> obj = new Plants();
            case BEAR -> obj = new Bear();
            case KANGAROO -> obj = new Kangaroo();
            case CATERPILLAR -> obj = new Caterpillar();
            case DEER -> obj = new Deer();
            case DUCK -> obj = new Duck();
            case EAGLE -> obj = new Eagle();
            case FOX -> obj = new Fox();
            case GOAT -> obj = new Goat();
            case HAMSTER -> obj = new Hamster();
            case HORSE -> obj = new Horse();
            case RABBIT -> obj = new Rabbit();
            case SHEEP -> obj = new Sheep();
            case SNAKE -> obj = new Snake();
            case WOLF -> obj = new Wolf();
            case COW -> obj = new Cow();
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
        ArrayList<Object> arrayList = new ArrayList<>();
       // System.out.print("{***");
        for (int i = 0; i < types.length; i++) {
            int numberOfRandom = getRandomNumber();
            int numberOfRandomForPlants = getRandomNumber();
            if (numberOfRandom > types[i].maximumPopulationType) {
                numberOfRandom = types[i].maximumPopulationType;
            }
            int count = 1;
            Object type = getPopulationIsland(types[i]);
            while (count <= numberOfRandom) {
                arrayList.add(type);
                count++;
            }

            System.out.print(" [" + types[i].avatar + "(" + types[i] + ")" + " = " + arrayList.size() + "] ");
            map.put(types[i].avatar, arrayList);

            arrayList.clear();
        }
        //System.out.println("***}");
        return map;
    }

   public static Map move(int direction, int speed, int maxSpeed, Object[][] mas) {
       Map<Object,Object> newMap = new HashMap<>();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
               Cell cell = new Cell(i,j);
               newMap.put(cell, mas[j]);
                for (Object o : newMap.keySet()) {


                System.out.print(newMap);
            }
   /*                    .forEach(s ->
                               {
                                   if (s !=null) newMap.put(toKey.apply(s[0]), toValue.apply(s[1]));
                               } );

                 //System.out.print(s));
               //Arrays.stream(mas[j]).collect(Collectors.toMap(p -> p.k, p -> p.v));
              //  map.entrySet().stream().map(Map.Entry::copyOf).toList()
*/
            }
            System.out.println();
        }
        return newMap;
    }
}


