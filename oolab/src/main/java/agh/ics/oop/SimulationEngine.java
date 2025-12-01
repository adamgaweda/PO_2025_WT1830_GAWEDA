package agh.ics.oop;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationEngine {
    private List<Simulation> simulations;


    public SimulationEngine(List<Simulation> simulation){
        this.simulations = simulation;
    }

    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsync(){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(Simulation simulation : simulations){
            executor.submit(simulation);
        }

    }

    public void awaitSimulationsEnd(){

    }

}
