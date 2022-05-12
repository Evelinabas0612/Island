import java.io.ObjectInputFilter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IslandMap {



    public static Object [][] createIslandMap(int height, int width) {
        Object[][] islandMaps = new HashMap[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                islandMaps[i][j] = IslandMap.getMapOfPopulation();


            }
            System.out.println();
        }
        return islandMaps;
    }

    public static PopulationIslands getPopulationIsland(PopulationIlandsTypes type) {
        PopulationIslands populationIslands = null;
        switch (type) {
            case PLANTS -> populationIslands = new Plants();
            case BEAR -> populationIslands = new Bear();
            case KANGAROO -> populationIslands = new Kangaroo();
            case CATERPILLAR -> populationIslands = new Caterpillar();
            case DEER -> populationIslands = new Deer();
            case DUCK -> populationIslands = new Duck();
            case EAGLE -> populationIslands = new Eagle();
            case FOX -> populationIslands = new Fox();
            case GOAT -> populationIslands = new Goat();
            case HAMSTER -> populationIslands = new Hamster();
            case HORSE -> populationIslands = new Horse();
            case RABBIT -> populationIslands = new Rabbit();
            case SHEEP -> populationIslands = new Sheep();
            case SNAKE -> populationIslands = new Snake();
            case WOLF -> populationIslands = new Wolf();
            case COW -> populationIslands = new Cow();
        }

        return populationIslands;
    }

    public static int getRandomNumber() {
        int a = (int) (Math.random() * 1000);
        return a;
    }

    public static Map<String, List<PopulationIslands>> getMapOfPopulation() {
        Map<String, List<PopulationIslands>> map = new HashMap<>();
        PopulationIlandsTypes[] types = PopulationIlandsTypes.values();
        ArrayList<PopulationIslands> arrayList = new ArrayList<>();
       // System.out.print("{***");
        for (int i = 0; i < types.length; i++) {
            int numberOfRandom = getRandomNumber();
            if (numberOfRandom > types[i].maximumPopulationType) {
                numberOfRandom = types[i].maximumPopulationType;
            }
            int count = 1;
            PopulationIslands type = getPopulationIsland(types[i]);
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


