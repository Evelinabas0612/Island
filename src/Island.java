
import java.util.concurrent.*;


public class Island {


    public static void main(String[] args) {

        IslandLife islandLife = new IslandLife();
        Cell[][] newMap = islandLife.createIslandMap(5, 5);


        for (int i = 0; i < 30; i++) {
            Runnable runnableOne = () -> {

                islandLife.oneDay(newMap);
            };

            Runnable runnableTwo = () -> {

                islandLife.printIsland(newMap);
            };

            ExecutorService executorService = Executors.newCachedThreadPool();
            try {

                executorService.submit(runnableOne);
                Thread.sleep(10);
                executorService.submit(runnableTwo);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            executorService.shutdown();


            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(islandLife, 0, 5, TimeUnit.SECONDS);
            scheduledExecutorService.shutdown();

        }


    }


}







