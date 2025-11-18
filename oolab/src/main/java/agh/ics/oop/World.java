package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import java.util.List;


public class World {
    public static void main(String args[]) {
        System.out.println("System has started");
        run(OptionsParser.OptionsParser(args));
        System.out.println("System has ended operation");
        List<MoveDirection> directions = OptionsParser.OptionsParser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, new RectangularMap(5,5));
        simulation.run();
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
