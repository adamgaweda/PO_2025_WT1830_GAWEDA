package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
public class Animal{

    private MapDirection orientation;
    private Vector2d placement;
    public String placementShow(){
        return placement.toString();
    }

    public Animal(Vector2d placement){
        this.orientation=MapDirection.NORTH;
        this.placement= placement;
    }

    public Animal(){
        this.orientation=MapDirection.NORTH;
        this.placement= new Vector2d(2,2);
    }
    public String toString(){
        return String.format("%s,%d,%d",orientation.toString(),placement.getX(),placement.getY());
    }

    public boolean isAt(Vector2d position){
        return placement.equals(position);
    }
    public void move(MoveDirection direction){
	switch(direction) {
        case MoveDirection.RIGHT : orientation.next();
        case MoveDirection.LEFT : orientation.previous();
        case MoveDirection.FORWARD : {
            placement.add(orientation.toUnitVector());
            int x = placement.getX();
            int y = placement.getY();
            if ( x>4 || x<0 || y>4 || y<0) {
                placement.substract(orientation.toUnitVector());
            }
        }
        case MoveDirection.BACKWARD : {
            placement.substract(orientation.toUnitVector());
            int x = placement.getX();
            int y = placement.getY();
            if ( x>4 || x<0 || y>4 || y<0) {
                placement.add(orientation.toUnitVector());
            }
            }
        }

    }
    }