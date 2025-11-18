package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.List;
import java.util.Vector;

public class Simulation {

    private List<MoveDirection> directions;
    private List<Animal>  animals;

    public  Simulation(List<Vector2d> vectors, List<MoveDirection> directions) {
        this.directions = directions;
        for (Vector2d vector : vectors) {
            animals.add(new Animal(vector));
        }
    }
    public void run(){
        int n = animals.size();
        int m = directions.size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j=j+n){
                animals.get(i).move(directions.get(j));
                System.out.println("Zwierzę i : ");
                System.out.println(animals.get(i).placementShow());
            }
        }
    }

}
