package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap implements WorldMap {


    public RectangularMap(int width, int height) {
        super(new Vector2d(width-1, height-1));
    }

    @Override
    public String toString(){
        return mapVisualizer.draw(bottomCorner, topCorner);
    }

}
