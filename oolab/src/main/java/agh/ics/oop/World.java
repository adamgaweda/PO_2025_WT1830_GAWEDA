package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;


public class World {
    public static void main(String args[]) {
        try {
            AbstractWorldMap mapa = new GrassField(20);
            List<MoveDirection> directions = OptionsParser.OptionsParser(args);
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
            mapa.registObserver(new ConsoleMapDisplay());
            Simulation simulation = new Simulation(positions, directions, mapa);
            simulation.run();
        }
        catch (IllegalArgumentException e) {
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
