package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void placeTest(){
        GrassField test1 = new GrassField(4);
        Animal animal = new Animal(test1, new Vector2d(1,1));
        test1.place(animal);
        assertEquals(animal, test1.getAnimals().get(new Vector2d(1,1)));
    }
    @Test
    public void placeTest_samePositionCase(){
        GrassField test2 = new GrassField(4);
        Animal animal = new Animal(test2, new Vector2d(1,1));
        Animal animal2 = new Animal(test2, new Vector2d(1,1));
        test2.place(animal);
        test2.place(animal2);
        assertEquals(1, test2.getAnimals().size());
    }
    @Test
    public void canMoveToTest(){
        GrassField test3 = new GrassField(4);
        Animal animal = new Animal(test3, new Vector2d(2,2));
        test3.place(animal);
        assertTrue(test3.canMoveTo(new Vector2d(2,3)));
    }
    @Test
    public void canMoveToTest2(){
        GrassField test3t = new GrassField(4);
        Animal animal = new Animal(test3t, new Vector2d(2,2));
        test3t.place(animal);
        assertFalse(test3t.canMoveTo(new Vector2d(2, 2)));
    }
    @Test
    public void isOccupiedTest(){
        GrassField test4 = new GrassField(4);
        Animal animal = new Animal(test4, new Vector2d(9,10));
        test4.place(animal);
        assertTrue(test4.isOccupied(new Vector2d(9,10)));
    }
    @Test
    public void isOccupiedTest2(){
        GrassField test4t = new GrassField(4);
        Animal animal = new Animal(test4t, new Vector2d(9,10));
        test4t.place(animal);
        assertFalse(test4t.isOccupied(new Vector2d(-100,100)));
    }
    @Test
    public void objectAtTest(){
        GrassField test5 = new GrassField(5);
        Animal animal = new Animal(test5, new Vector2d(30,4));
        test5.place(animal);
        assertEquals(animal, test5.objectAt(new Vector2d(30,4)));
        assertNull(test5.objectAt(new Vector2d(10, 20)));
    }
    @Test
    public void objectAtTest2(){
        GrassField test5t = new GrassField(5);
        Animal animal = new Animal(test5t, new Vector2d(30,4));
        test5t.place(animal);
        assertNull(test5t.objectAt(new Vector2d(10, 20)));
    }

}
