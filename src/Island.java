import Animal.Animal;

import java.util.*;


public class Island {


    public static void main(String[] args) {
        Cell[][] newMap = IslandMap.createIslandMap(5, 5);
        IslandLife islandLife = new IslandLife();

        for (Cell[] cells : newMap) {
            for (Cell cell : cells) {

                List<List<Object>> listCellAnimal = new ArrayList<>(cell.getMap().values());


                List <Object> listOfDeleteWeek = islandLife.allDelete(listCellAnimal);
                Map<String,Integer> mapOfStatEaten = islandLife.allEat(listCellAnimal);

                List <Object> listOfDeleteEaten = islandLife.allDelete(listCellAnimal);

                List <Object> listNewborns = islandLife.allReproduction(listCellAnimal);

                islandLife.addNewborns(listNewborns, listCellAnimal);

                Integer countPlantsGrow = islandLife.allPlantsGrow(listCellAnimal);



            }

                }
        islandLife.allMove(newMap);
        islandLife.addMigrants(newMap);





            }

        }







