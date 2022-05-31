import Animal.Animal;

import java.util.*;
import java.util.concurrent.*;


public class Island {


    public static void main(String[] args) {

        IslandLife islandLife = new IslandLife();
        Cell[][] newMap = islandLife.createIslandMap(5, 5);


        for (int i = 0; i < 30; i++) {
            Runnable runnable = () -> {

                islandLife.oneDay(newMap);
            };
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.submit(runnable);

            executorService.shutdown();

            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(islandLife, 0, 5, TimeUnit.SECONDS);
            scheduledExecutorService.shutdown();

    }



    }








    }







