package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;


public class World {
    public static void main(String args[]) {
        System.out.println("System has started");
        run(OptionsParser.OptionsParser(args));
        System.out.println("System has ended operation");
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
