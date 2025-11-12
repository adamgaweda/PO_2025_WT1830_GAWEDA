package agh.ics.oop;

import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testEquals(){
        //given
        Vector2d pierwszy = new Vector2d(5,2);
        Vector2d drugi = new Vector2d(5,2);
        Vector2d pierwszy2 = new Vector2d(5,2);
        Vector2d  drugi2 = new Vector2d(2,5);
        //when
        //then
        assertTrue(pierwszy.equals(drugi));
        assertFalse(pierwszy2.equals(drugi2));
    }
    @Test
    void testToString(){
        //given
        Vector2d vector = new Vector2d(5,2);
        //when
        String napis = vector.toString();
        //then
        assertEquals(napis, "(5,2)");
    }
    @Test
    void testPrecedes(){
        //given
        Vector2d vector1 = new Vector2d(5,2);
        Vector2d vector2 = new Vector2d(4,1);
        //then
        assertTrue(vector1.precedes(vector2));
    }
    @Test
    void testFollows(){
        //given
        Vector2d vector1 = new Vector2d(3,1);
        Vector2d vector2 = new Vector2d(4,3);
        //then
        assertTrue(vector1.follows(vector2));
    }
    @Test
    void testUpperRight(){
        Vector2d vector1 = new Vector2d(5,2);
        Vector2d vector2 = new Vector2d(4,3);

        Vector2d vector3 = vector1.upperRight(vector2);

        assertTrue(vector3.equals(new Vector2d(5,3)));
    }
    @Test
    void testLowerLeft(){
        Vector2d vector1 = new Vector2d(5,2);
        Vector2d vector2 = new Vector2d(4,3);

        Vector2d vector3 = vector1.lowerLeft(vector2);

        assertTrue(vector3.equals(new Vector2d(4,2)));
    }
    @Test
    void testAdd(){
        Vector2d vector1 = new Vector2d(5,2);
        Vector2d vector2 = new Vector2d(4,3);

        vector1.add(vector2);

        assertTrue(vector1.equals(new Vector2d(9,5)));
    }
    @Test
    void testSubtract(){
        Vector2d vector1 = new Vector2d(5,2);
        Vector2d vector2 = new Vector2d(4,3);

        vector1.substract(vector2);

        assertTrue(vector1.equals(new Vector2d(1,-1)));
    }
    @Test
    void testOpposite(){
        Vector2d vector1 = new Vector2d(5,2);

        Vector2d vector2 = vector1.opposite();

        assertTrue(vector2.equals(new Vector2d(-5,-2)));
    }


}