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
            case PLANTS -> obj = new Plants(1.0);
            case BEAR -> obj = new Bear(250.0, 38.0);
            case KANGAROO -> obj = new Kangaroo(47.0, 7.0);
            case CATERPILLAR -> obj = new Caterpillar(0.01, 0.0025);
            case DEER -> obj = new Deer(170.0, 26.0);
            case DUCK -> obj = new Duck(1.0, 0.15);
            case EAGLE -> obj = new Eagle(6.0, 1.0 );
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



    }



