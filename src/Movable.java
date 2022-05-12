import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface Movable {
    default void move(int direction, int speed, int maxSpeed, Object [][] mas){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                Arrays.stream(mas[j]).forEach(s -> System.out.print(s+"***" + direction + speed + maxSpeed));
            }
        }

         //   if(direction == 1){

           // }

        }
    }

