package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    final private int x;
    private final int y;
    public Vector2d(int x, int y) {
        this.x=x;
        this.y=y;

    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public String toString(int x, int y) {
        return String.format("(%d,%d)",x,y);
        //return "(" + x + "," + y + ")"
    }
    public boolean precedes(Vector2d other) {
        if(other.getX()>=getX() && other.getY()>=getY()) return true;
        return false;

    }
    public boolean follows(Vector2d other){
        if(other.getX()<=getX() && other.getY()<=getY()) return true;
        return false;
    }
    public Vector2d add(Vector2d other){
        Vector2d nowy=new Vector2d(x+other.getX(),y+other.getY());
        return nowy;

    }
    public Vector2d substract(Vector2d other){

        return new Vector2d(x-other.getX(),y-other.getY());
    }
    public Vector2d upperRight(Vector2d other){
        int x1=x;
        if(x<other.getX()){
            x1=other.getX();
        }
        int y1=y;
        if(y<other.getY()){
            y1=other.getY();
        }
        return  new Vector2d(x1,y1);
    }
    public Vector2d lowerLeft(Vector2d other){
        int x1=x;
        if(x>other.getX()){
            x1=other.getX();
        }
        int y1=y;
        if(y>other.getY()){
            y1=other.getY();
        }
        return  new Vector2d(x1,y1);
    }
    public Vector2d opposite(){
        return  new Vector2d(-x,-y);
    }
    @Override
    public boolean equals(Object other){
        if(this==other){return true;}
        if(!(other instanceof Vector2d)){return false;}
        Vector2d that=(Vector2d)other;
        return (that.x==this.x && that.y==this.y);
    }

    @Override
    public int hashCode() {
        return 167*this.x+193*this.y;
    }
}
