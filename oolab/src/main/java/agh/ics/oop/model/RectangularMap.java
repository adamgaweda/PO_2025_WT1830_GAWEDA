package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    Map<Vector2d, Animal> animals = new HashMap<>();
    final int width;
    final int height;
    final private MapVisualizer mapVisualizer = new MapVisualizer(this);
    final Vector2d bottomCorner = new Vector2d(0, 0);
    final  Vector2d topCorner;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.topCorner = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPlacement())) {
            animals.put(animal.getPlacement(), animal);
            return true;
        }
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction){
        animals.remove(animal.getPlacement());
        animal.move(direction,this);
        animals.put(animal.getPlacement(), animal);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position){
        return animals.get(position);
    }


    @Override
    public boolean canMoveTo(Vector2d position){
        return position.precedes(bottomCorner) || position.follows(topCorner) || animals.get(position) == null;
    }

    public String toString(){
        return mapVisualizer.draw(bottomCorner, topCorner);
    }
}
