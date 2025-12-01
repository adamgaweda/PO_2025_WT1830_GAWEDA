package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;


public class World {
    public static void main(String args[]) {
        try {
            List<MoveDirection> directions = OptionsParser.OptionsParser(args);
            List<Simulation> simulations = new ArrayList<>();
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

            ConsoleMapDisplay display = new ConsoleMapDisplay();

            for(int i = 0; i < 100; i++){
                AbstractWorldMap mapGrass = new GrassField(20);
                AbstractWorldMap mapRect = new RectangularMap(20, 20);

                mapGrass.registObserver(display);
                mapRect.registObserver(display);

                Simulation simulation1 = new Simulation(positions, directions, mapGrass);
                Simulation simulation2 = new Simulation(positions, directions, mapRect);

                simulations.add(simulation1);
                simulations.add(simulation2);
            }
            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsync();
            engine.awaitSimulationsEnd();
        }
        catch (IllegalArgumentException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void run(List<MoveDirection> directions) {

        for (MoveDirection direction : directions) {
            switch (direction) {
                case MoveDirection.FORWARD -> System.out.println("Pet's moving forward");
                case MoveDirection.BACKWARD -> System.out.println("Pet's moving backward");
                case MoveDirection.RIGHT -> System.out.println("Pet's turning right");
                case MoveDirection.LEFT -> System.out.println("Pet's turning left");
            }
        }

    }
}
