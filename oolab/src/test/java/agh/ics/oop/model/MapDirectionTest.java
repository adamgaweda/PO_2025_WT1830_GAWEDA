package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
        @Test
    void testToString(){
            //given
            MapDirection north = MapDirection.NORTH;
            MapDirection south = MapDirection.SOUTH;
            MapDirection east = MapDirection.EAST;
            MapDirection west = MapDirection.WEST;
            //when
            String northToString = north.toString();
            String southToString = south.toString();
            String eastToString = east.toString();
            String  westToString = west.toString();

            //then
            assertEquals("Północ", northToString);
            assertEquals("Południe", southToString);
            assertEquals("Wschód", eastToString);
            assertEquals("Zachód", westToString);
        }
    @Test
    void testPrevious(){
            //given
            MapDirection north = MapDirection.NORTH;
            MapDirection south = MapDirection.SOUTH;
            MapDirection east = MapDirection.EAST;
            MapDirection west = MapDirection.WEST;
            //when
            MapDirection prevNorth = north.previous();
            MapDirection prevSouth = south.previous();
            MapDirection prevEast = east.previous();
            MapDirection prevWest = west.previous();
            //then
            assertEquals(prevNorth, MapDirection.EAST);
            assertEquals(prevSouth, MapDirection.WEST);
            assertEquals(prevEast, MapDirection.SOUTH);
            assertEquals(prevWest, MapDirection.NORTH);
    }
    @Test
    void testNext() {
        //given
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;
        //when
        MapDirection nextNorth = north.next();
        MapDirection nextSouth = south.next();
        MapDirection nextEast = east.next();
        MapDirection nextWest = west.next();
        //then
        assertEquals(nextNorth, MapDirection.WEST);
        assertEquals(nextSouth, MapDirection.EAST);
        assertEquals(nextEast, MapDirection.NORTH);
        assertEquals(nextWest, MapDirection.SOUTH);
    }

    @Test
    void testToUnitVector() {
            //given
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;
        //when
        Vector2d vectorNorth = north.toUnitVector();
        Vector2d vectorSouth = south.toUnitVector();
        Vector2d vectorEast = east.toUnitVector();
        Vector2d vectorWest = west.toUnitVector();
        //then
        assertEquals(vectorNorth, new Vector2d(0,1));
        assertEquals(vectorSouth, new Vector2d(0,-1));
        assertEquals(vectorEast, new Vector2d(1,0));
        assertEquals(vectorWest, new Vector2d(-1,0));
    }
}