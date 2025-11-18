package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class AbstractWorldMap implements WorldMap{
    protected final Vector2d bottomCorner = new Vector2d(0, 0);
    protected final Vector2d topCorner;
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer  mapVisualizer = new MapVisualizer(this);

    public AbstractWorldMap( Vector2d topCorner){
        this.topCorner=topCorner;
    }
    public AbstractWorldMap(){
        this(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
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
    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }


    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(bottomCorner) && position.precedes(topCorner) && animals.get(position) == null;
    }

    public String toString(){
        return mapVisualizer.draw(bottomCorner, topCorner);
    }

}
