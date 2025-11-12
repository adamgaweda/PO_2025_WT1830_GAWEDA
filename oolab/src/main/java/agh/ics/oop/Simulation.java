package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class Simulation {

    private List<MoveDirection> directions;
    private List<Animal>  animals;
    private final RectangularMap worldMap;

    public  Simulation(List<Vector2d> vectors, List<MoveDirection> directions, RectangularMap  worldMap) {
        this.directions = directions;
        this.worldMap = worldMap;
        for (Vector2d vector : vectors) {
            Animal zwierze = new Animal(vector);
            if(worldMap.place(zwierze)) {
                animals.add(zwierze);
            }
        }
    }
    public void run(){
        int n = animals.size();
        /*int m = directions.size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j=j+n){
                animals.get(i).move(directions.get(j));
                System.out.println("Zwierzę i : ");
                System.out.println(animals.get(i).placementShow());
            }
        }*/
        for(int i = 0; i < n; i++){
            worldMap.move(animals.get(i%n),directions.get(i));
            //System.out.println("Zwierzę i : ");
            //System.out.println(animals.get(i%n).placementShow());
        }

    }

}
