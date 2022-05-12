package Animal;

import Plants.Plants;

import java.util.ArrayList;

public abstract class Animal {
    protected  int currentTact; //счетчик отчета до падения потенциала
    protected int maxTactAnimal; //сколько тактов осталось до смерти от голода
    public boolean isEaten = false; // пометка съедено ли животное
    public boolean isExtra = false; //не лишнее ли животное на клетке
    public boolean isWeek = false; // пометка, что животное полностью истощено

    abstract Animal reproduction();



    public void fallingSaturation(int maxTactAnimal, int currentTact,ArrayList<Object> arrayList) {
        if(currentTact >0){
            currentTact--;
        }
        if (currentTact == 0) {
            maxTactAnimal--;

        }

    //    if(maxTactAnimal == 0){
     //       dieAndDelete(arrayList);
      //  }
    }


    public boolean eat(Animal animal, Herbivore herbivore, Plants plants, Predator predator){
      //  animal.eaten(isEaten);
        return isEaten;
    }


}
