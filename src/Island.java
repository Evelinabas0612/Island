
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Island {


    public static void main(String[] args) {
        AtomicInteger day = new AtomicInteger();
        IslandLife islandLife = new IslandLife();
        Cell[][] newMap = islandLife.createIslandMap(5, 5);

        Runnable runnableZero = () -> {

            day.set(day.get() + +1);
            System.out.println("День - "+day);
        };
        Runnable runnableOne = () -> {

            islandLife.oneDay(newMap);
        };

        Runnable runnableTwo = () -> {

            islandLife.printIsland(newMap);
        };



        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 30; i++) {

            scheduledExecutorService.scheduleAtFixedRate(runnableZero, 2, 5, TimeUnit.SECONDS);

            executorService.submit(runnableOne);
            executorService.submit(runnableTwo);


        }
        executorService.shutdown();
        scheduledExecutorService.shutdown();

    }


}







