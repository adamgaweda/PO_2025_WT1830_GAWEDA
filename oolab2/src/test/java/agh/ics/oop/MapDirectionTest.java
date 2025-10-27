package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class MapDirectionTest {


    @Test
    public void test_next(){

        assert ((MapDirection.next(MapDirection.EAST)), MapDirection.SOUTH);
        assert ((MapDirection.next(MapDirection.SOUTH)), MapDirection.WEST);
        assert ((MapDirection.next(MapDirection.WEST)), MapDirection.NORTH);
        assert ((MapDirection.next(MapDirection.NORTH)), MapDirection.EAST);

    }

    public
}
