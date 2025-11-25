package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> OptionsParser(String[] args) {

        List<MoveDirection> directions = new ArrayList<>();


        for  (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f" -> directions.add(MoveDirection.FORWARD);
                case "forward" -> directions.add(MoveDirection.FORWARD);
                case "b" -> directions.add(MoveDirection.BACKWARD);
                case "r" -> directions.add(MoveDirection.RIGHT);
                case "l" -> directions.add(MoveDirection.LEFT);
                case "backward" -> directions.add(MoveDirection.BACKWARD);
                case "right" -> directions.add(MoveDirection.RIGHT);
                case "left" -> directions.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(args[i] + " is not a legal move direction");
            }
        }
        return directions;
    }
}
