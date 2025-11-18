package agh.ics.oop.model;

public class Grass implements WorldElement {

    private final Vector2d placement;


    public Grass(Vector2d placement) {
        this.placement = placement;
    }

    public Vector2d getPlacement() {
        return placement;
    }

    public String toString(){
        return "*";
    }

}
