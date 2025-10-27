package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String args[]) {
        System.out.println("System has started");
        run(OptionsParser.options(args));
        System.out.println("System has ended operation");
    }
    public static void run(MoveDirection[] directions) {

        for(int i=0;i<directions.length;i++){
            switch (directions[i]) {
                case FORWARD ->  System.out.println("Pet's moving forward");
                case BACKWARD ->  System.out.println("Pet's moving backward");
                case RIGHT -> System.out.println("Pet's turning right");
                case LEFT -> System.out.println("Pet's turning left");
            }
        }

    }
}
