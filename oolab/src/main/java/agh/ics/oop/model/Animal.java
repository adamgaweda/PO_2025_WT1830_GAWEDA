package agh.ics.oop.model;

public class Animal {

    private MapDirection orientation;
    private Vector2d placement;

    public String placementShow() {
        return placement.toString();
    }


    public Animal(Vector2d placement) {
        this.orientation = MapDirection.NORTH;
        this.placement = placement;
    }

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.placement = new Vector2d(2, 2);
    }

    public String toString() {
        return String.format("%s,%d,%d", orientation.toString(), placement.getX(), placement.getY());
    }

    public Vector2d getPlacement() {
        return placement;
    }

    public boolean isAt(Vector2d position) {
        return placement.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {

        switch (direction) {
            case MoveDirection.RIGHT:
                orientation.next();
                break;
            case MoveDirection.LEFT:
                orientation.previous();
                break;
            case MoveDirection.FORWARD: {
                Vector2d position_new = placement.add(orientation.toUnitVector());
                if (moveValidator.canMoveTo(position_new)) {
                    placement = position_new;
                }
                break;
            }
            case MoveDirection.BACKWARD: {
                Vector2d position_new = placement.substract(orientation.toUnitVector());
                if (moveValidator.canMoveTo(position_new)) {
                    placement = position_new;
                }

                break;
            }

        }
    }
}