package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MapDirectionTest {
    @Test
    public void nextTest() throws Exception {
        World.MapDirection m1 = World.MapDirection.EAST;
        World.MapDirection m2 = World.MapDirection.SOUTH;
        World.MapDirection m3 = World.MapDirection.WEST;
        World.MapDirection m4 = World.MapDirection.NORTH;
        World.MapDirection n1 = m1.next();
        World.MapDirection n2 = m2.next();
        World.MapDirection n3 = m3.next();
        World.MapDirection n4 = m4.next();
        if (!n1.equals(m2) || !n2.equals(m3) || !n3.equals(m4) || !n4.equals(m1)) {
            fail("?");
        }
    }
    @Test
    public void previousTest() throws Exception {
        World.MapDirection m1 = World.MapDirection.EAST;
        World.MapDirection m2 = World.MapDirection.SOUTH;
        World.MapDirection m3 = World.MapDirection.WEST;
        World.MapDirection m4 = World.MapDirection.NORTH;
        World.MapDirection n1 = m1.previous();
        World.MapDirection n2 = m2.previous();
        World.MapDirection n3 = m3.previous();
        World.MapDirection n4 = m4.previous();
        if (!n1.equals(m4) || !n2.equals(m1) || !n3.equals(m2) || !n4.equals(m3)) {
            fail("?");
        }
    }
}

