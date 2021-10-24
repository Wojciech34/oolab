package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        World.Vector2d temp = new World.Vector2d(2,3);
        World.Vector2d temp2 = new World.Vector2d(2,3);
        assertTrue(temp.equals(temp2));
    }
    @Test
    public void toStringTest(){
        World.Vector2d temp = new World.Vector2d(1,2);
        assertEquals(temp.toString(), "(1,2)");
    }
    @Test
    public void precedesTest(){
        World.Vector2d temp = new World.Vector2d(3,5);
        assertTrue(temp.precedes(new World.Vector2d(4,9)));
    }
    @Test
    public void followsTest(){
        World.Vector2d temp = new World.Vector2d(3,5);
        assertTrue(temp.follows(new World.Vector2d(0,0)));
    }
    @Test
    public void upperRightTest(){
        World.Vector2d temp = new World.Vector2d(2,3);
        assertEquals(temp.upperRight(new World.Vector2d(-2, 10)), new World.Vector2d(2,10));
    }
    @Test
    public void lowerLeft(){
        World.Vector2d temp = new World.Vector2d(2,-9);
        assertEquals(temp.lowerLeft(new World.Vector2d(2,-11)), new World.Vector2d(2, -11));
    }
    @Test
    public void addTest(){
        World.Vector2d temp = new World.Vector2d(1,6);
        World.Vector2d temp2 = new World.Vector2d(-100,100);
        assertEquals(temp.add(temp2), new World.Vector2d(-99, 106));
    }
    @Test
    public void subtractTest(){
        World.Vector2d temp = new World.Vector2d(12,17);
        World.Vector2d temp2 = new World.Vector2d(20,0);
        assertEquals(temp.subtract(temp2), new World.Vector2d(-8,17));
    }
    @Test
    public void oppositeTest(){
        World.Vector2d temp = new World.Vector2d(3,-4);
        assertEquals(temp.opposite(), new World.Vector2d(-3,4));
    }
}
