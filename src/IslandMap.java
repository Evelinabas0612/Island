import Animal.*;
import Plants.*;

import java.util.*;

public class IslandMap {


    public static Cell [][] createIslandMap(int height, int width) {
        Cell[][] islandMap = new Cell[height][width];

                    for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        islandMap[i][j] = new Cell();
                        islandMap[i][j].setMap(IslandMap.getMapOfPopulation());


            }
            System.out.println();
        }
        return islandMap;
    }

    public static Object getPopulationIsland(PopulationIlandsTypes type) {
       Object obj = null;
        switch (type) {
            case PLANTS -> obj = new Plants(false, false);
            case BEAR -> obj = new Bear(38.0, false, false, false);
            case KANGAROO -> obj = new Kangaroo(7.0, false, false, false);
            case CATERPILLAR -> obj = new Caterpillar(1.0, false, false, false);
            case DEER -> obj = new Deer(26.0, false, false, false);
            case DUCK -> obj = new Duck(1.0, false, false, false);
            case EAGLE -> obj = new Eagle(1.0, false,false,false );
            case FOX -> obj = new Fox(1.0, false, false, false);
            case GOAT -> obj = new Goat(10.0, false, false, false);
            case HAMSTER -> obj = new Hamster(1.0, false, false, false);
            case HORSE -> obj = new Horse(45.0, false, false, false);
            case RABBIT -> obj = new Rabbit(1.0, false,false, false);
            case SHEEP -> obj = new Sheep(7.0, false, false, false);
            case SNAKE -> obj = new Snake(1.0, false, false, false);
            case WOLF -> obj = new Wolf(8.0,false,false,false);
            case COW -> obj = new Cow(53.0, false, false, false);
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

       // System.out.print("{***");
        for (int i = 0; i < types.length; i++) {
         //   arrayList.clear();
            ArrayList<Object> arrayList = new ArrayList<>();
            int numberOfRandom = getRandomNumber();
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


        }
        //System.out.println("***}");

        return map;
    }



    }



