package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        MapDirection m1 = MapDirection.EAST;
        MapDirection m2 = MapDirection.SOUTH;
        MapDirection m3 = MapDirection.WEST;
        MapDirection m4 = MapDirection.NORTH;
        MapDirection n1 = m1.next();
        MapDirection n2 = m2.next();
        MapDirection n3 = m3.next();
        MapDirection n4 = m4.next();
        if (!n1.equals(m2) || !n2.equals(m3) || !n3.equals(m4) || !n4.equals(m1)) {
            fail("?");
        }
    }
    @Test
    public void previousTest(){
        MapDirection m1 = MapDirection.EAST;
        MapDirection m2 = MapDirection.SOUTH;
        MapDirection m3 = MapDirection.WEST;
        MapDirection m4 = MapDirection.NORTH;
        MapDirection n1 = m1.previous();
        MapDirection n2 = m2.previous();
        MapDirection n3 = m3.previous();
        MapDirection n4 = m4.previous();
        if (!n1.equals(m4) || !n2.equals(m1) || !n3.equals(m2) || !n4.equals(m3)) {
            fail("?");
        }
    }
}

