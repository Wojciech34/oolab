package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        Vector2d temp = new Vector2d(2,3);
        Vector2d temp2 = new Vector2d(2,3);
        assertTrue(temp.equals(temp2));
    }
    @Test
    public void toStringTest(){
        Vector2d temp = new Vector2d(1,2);
        assertEquals(temp.toString(), "(1,2)");
    }
    @Test
    public void precedesTest(){
        Vector2d temp = new Vector2d(3,5);
        assertTrue(temp.precedes(new Vector2d(4,9)));
    }
    @Test
    public void followsTest(){
        Vector2d temp = new Vector2d(3,5);
        assertTrue(temp.follows(new Vector2d(0,0)));
    }
    @Test
    public void upperRightTest(){
        Vector2d temp = new Vector2d(2,3);
        assertEquals(temp.upperRight(new Vector2d(-2, 10)), new Vector2d(2,10));
    }
    @Test
    public void lowerLeft(){
        Vector2d temp = new Vector2d(2,-9);
        assertEquals(temp.lowerLeft(new Vector2d(2,-11)), new Vector2d(2, -11));
    }
    @Test
    public void addTest(){
        Vector2d temp = new Vector2d(1,6);
        Vector2d temp2 = new Vector2d(-100,100);
        assertEquals(temp.add(temp2), new Vector2d(-99, 106));
    }
    @Test
    public void subtractTest(){
        Vector2d temp = new Vector2d(12,17);
        Vector2d temp2 = new Vector2d(20,0);
        assertEquals(temp.subtract(temp2), new Vector2d(-8,17));
    }
    @Test
    public void oppositeTest(){
        Vector2d temp = new Vector2d(3,-4);
        assertEquals(temp.opposite(), new Vector2d(-3,4));
    }
}
