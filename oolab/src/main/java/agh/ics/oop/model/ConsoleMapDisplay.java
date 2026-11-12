package agh.ics.oop.model;

import java.util.Map;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updates = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message){
        updates++;
        System.out.print(message);
        System.out.print("How many updates have happend so far: " + updates);
        System.out.print("Mapa o id" + worldMap.getId());
        System.out.print(worldMap.toString());
    }
}
