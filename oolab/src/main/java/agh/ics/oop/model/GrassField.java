package agh.ics.oop.model;

import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements WorldMap {

    private final int numberOfPatches;
    Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int numberOfPatches){
        super();
        int grassLimit = (int) Math.sqrt(10*numberOfPatches);
        this.numberOfPatches = numberOfPatches;

        RandomPositionGenerator randomPos = new RandomPositionGenerator(grassLimit,numberOfPatches);
        for(Vector2d position: randomPos){
            grasses.put(position,new Grass(position));
        }
    }


    public String toString(){
        Vector2d bottom = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d top = new Vector2d(0, 0);
        for(Vector2d v : grasses.keySet()){
            bottom = bottom.lowerLeft(v);
            top = top.upperRight(v);
        }
        for(Vector2d v : animals.keySet()){
            bottom = bottom.lowerLeft(v);
            top = top.upperRight(v);
        }

        return mapVisualizer.draw(bottom,top);
    }

    @Override
    public List<WorldElement> getElements(){
        ArrayList<WorldElement> result = new ArrayList<>(List.copyOf(animals.values()));
        result.addAll(List.copyOf(grasses.values()));
        return result;
    }

    @Override
    public WorldElement objectAt(Vector2d position){
        if(animals.containsKey(position)){return  animals.get(position);}
        return  grasses.get(position);
    }

}
