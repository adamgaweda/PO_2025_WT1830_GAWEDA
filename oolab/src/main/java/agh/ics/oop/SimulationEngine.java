package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private List<Simulation> simulations;
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private List<Thread> threads = new ArrayList<>();

    public SimulationEngine(List<Simulation> simulations){
        this.simulations = simulations;
        for(Simulation simulation : simulations){
            threads.add( new Thread(simulation));
        }
    }

    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsyncInThreadPool(){

        for(Thread thread : threads){
            executor.submit(thread);
        }

    }
    public void runAsync(){

        for(Thread thread : threads){
            thread.start();
        }

    }

    public void awaitSimulationsEnd() throws InterruptedException{
        for(Thread thread : threads ){
            thread.join();
        }

        executor.shutdown();
        if(!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

}
