import Animal.Animal;

import java.util.*;


public class Island {


    public static void main(String[] args) {
        Cell[][] newMap = IslandMap.createIslandMap(5, 5);
        for (Cell[] cells : newMap) {
            for (Cell cell : cells) {

                Set<Map.Entry<String, List<Object>>> set = cell.getMap().entrySet();
                List<List<Object>> listCellAnimal = new ArrayList<>(cell.getMap().values());
                System.out.println("&&&&&&&&&&"+ listCellAnimal);
                IslandLife islandLife = new IslandLife();
                Map<String,Integer> mapOfStatEaten = islandLife.allEat(listCellAnimal);
                List <Object> listOfDelete = islandLife.allDelete(listCellAnimal);
                List <Object> listNewborns = islandLife.allReproduction(listCellAnimal);
                //System.out.println("***********"+ listNewObject);
                //System.out.println("%%%%%%%%%%%%%%"+ listCellAnimal);
                Map <Cell, Animal> mapOfMove= islandLife.allMove(newMap, listCellAnimal);
                Integer countPlantsGrow = islandLife.allPlantsGrow(listCellAnimal);
                System.out.println("))))))))))))))))))"+ countPlantsGrow);
            }

                }



            }

        }







