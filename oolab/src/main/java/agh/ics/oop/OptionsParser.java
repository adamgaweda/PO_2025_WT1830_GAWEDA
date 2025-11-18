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
                case "b" -> directions.add(MoveDirection.BACKWARD);
                case "r" -> directions.add(MoveDirection.RIGHT);
                case "l" -> directions.add(MoveDirection.LEFT);
            }
        }
        return directions;
    }
}
