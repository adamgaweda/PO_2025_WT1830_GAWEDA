package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.List;

public class Simulation {

    private List<MoveDirection> directions;
    private List<Animal>  animals;
    private final AbstractWorldMap worldMap;

    public  Simulation(List<Vector2d> vectors, List<MoveDirection> directions, AbstractWorldMap  worldMap) {
        this.directions = directions;
        this.worldMap = worldMap;
        for (Vector2d vector : vectors) {
            Animal zwierze = new Animal(vector);
            try {
                worldMap.place(zwierze);
                animals.add(zwierze);
            }
            catch (IncorrectPositionException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void run(){
        int n = animals.size();

        for(int i = 0; i < n; i++){
            worldMap.move(animals.get(i%n),directions.get(i));
        }

    }

}
