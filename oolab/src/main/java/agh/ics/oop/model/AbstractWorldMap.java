package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class AbstractWorldMap implements WorldMap{
    protected final Vector2d bottomCorner = new Vector2d(0, 0);
    protected final Vector2d topCorner;
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer  mapVisualizer = new MapVisualizer(this);
    protected List<MapChangeListener> observersList = new ArrayList<>();

    public AbstractWorldMap( Vector2d topCorner){
        this.topCorner=topCorner;
    }
    public AbstractWorldMap(){
        this(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException {
        Vector2d position = animal.getPlacement();


        if (canMoveTo(position)) {
            animals.put(position, animal);
        }
        else {
            throw new IncorrectPositionException(position);
        }
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
    @Override
    public String toString(){
        Boundary boundary = getCurrentBounds();
        return mapVisualizer.draw(boundary.lowerLeftCorner(), boundary.upperRightCorner());
    }

    @Override
    public List<WorldElement> getElements(){
        return new ArrayList<>(List.copyOf(animals.values()));
    }


    public Boundary getCurrentBounds(){
        return new Boundary(bottomCorner,topCorner);
    }

    public void registObserver(MapChangeListener obs){
        observersList.add(obs);
    }

    public void unregistObserver(MapChangeListener obs){
        observersList.remove(obs);
    }

    private void mapChanged(String message){
        for(MapChangeListener obs : observersList){
            obs.mapChanged(this,message);
        }
    }


}
