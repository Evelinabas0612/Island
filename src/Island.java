import Animal.Animal;
import Animal.Predator;
import Animal.Herbivore;
import Plants.Plants;

import java.util.*;


public class Island {


    public static void main(String[] args) {
        Cell[][] newMap = IslandMap.createIslandMap(1, 1);
        for (Cell[] cells : newMap) {
            for (Cell cell : cells) {

                Set<Map.Entry<String, List<Object>>> set = cell.getMap().entrySet();
                List<List<Object>> listCellAnimal = new ArrayList<>(cell.getMap().values());
                System.out.println("&&&&&&&&&&"+ listCellAnimal);
                IslindLife islindLife = new IslindLife();
                listCellAnimal = islindLife.allEat(listCellAnimal);
                islindLife.allDelete(listCellAnimal);
                //System.out.println("***********"+ listCellAnimal);
            }

                }



            }

        }







