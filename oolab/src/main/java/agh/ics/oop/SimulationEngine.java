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

    }

    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsyncInThreadPool(){

        for(Simulation simulation : simulations){
            executor.submit(simulation);
        }

    }
    public void runAsync(){

        for(Simulation simulation : simulations){
            this.threads.add( new Thread(simulation));
        }
        for(Thread thread : threads){
            thread.start();
        }

    }

    public void awaitSimulationsEnd() throws InterruptedException{

        for(Thread thread : threads ){
            thread.join();
        }
        threads.clear();
        if(!executor.isShutdown()) {
            executor.shutdown();
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
    }

}
