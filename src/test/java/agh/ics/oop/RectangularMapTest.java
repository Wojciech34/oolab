package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void placeTest(){
        RectangularMap test1 = new RectangularMap(3,3);
        Animal animal = new Animal(test1, new Vector2d(1,1));
        test1.place(animal);
        assertEquals(animal, test1.getAnimals().get(0));
    }
    @Test
    public void placeTest_samePositionCase(){
        RectangularMap test2 = new RectangularMap(3,3);
        Animal animal = new Animal(test2, new Vector2d(1,1));
        Animal animal2 = new Animal(test2, new Vector2d(1,1));
        test2.place(animal);
        test2.place(animal2);
        assertEquals(1, test2.getAnimals().size());
    }
    @Test
    public void placeTest_outtaPositionCase(){
        RectangularMap test3 = new RectangularMap(3,2);
        Animal animal = new Animal(test3, new Vector2d(100, 100));
        test3.place(animal);
        assertEquals(0, test3.getAnimals().size());
    }
    @Test
    public void canMoveToTest(){
        RectangularMap test4 = new RectangularMap(3,3);
        Animal animal = new Animal(test4, new Vector2d(2,2));
        test4.place(animal);
        assertTrue(test4.canMoveTo(new Vector2d(2,1)));
    }
    @Test
    public void canMoveToTest_theSamePositionCase(){
        RectangularMap test5 = new RectangularMap(3,3);
        Animal animal = new Animal(test5, new Vector2d(2,2));
        test5.place(animal);
        assertFalse(test5.canMoveTo(new Vector2d(2, 2)));
    }
    @Test
    public void canMoveToTest_outtaPositionCase(){
        RectangularMap test6 = new RectangularMap(3,3);
        Animal animal = new Animal(test6, new Vector2d(1,2));
        test6.place(animal);
        assertFalse(test6.canMoveTo(new Vector2d(20, 2)));
    }
    @Test
    public void isOccupiedTest(){
        RectangularMap test7 = new RectangularMap(3,3);
        Animal animal = new Animal(test7, new Vector2d(2,2));
        test7.place(animal);
        assertTrue(test7.isOccupied(new Vector2d(2,2)));
    }
    @Test
    public void isOccupiedTest2(){
        RectangularMap test7t = new RectangularMap(3,3);
        Animal animal = new Animal(test7t, new Vector2d(2,2));
        test7t.place(animal);
        assertFalse(test7t.isOccupied(new Vector2d(9,10)));
    }
    @Test
    public void objectAtTest(){
        RectangularMap test8 = new RectangularMap(3,3);
        Animal animal = new Animal(test8, new Vector2d(1,1));
        test8.place(animal);
        assertEquals(animal, test8.objectAt(new Vector2d(1,1)));
        assertNull(test8.objectAt(new Vector2d(1, 2)));
    }
    @Test
    public void objectAtTest2(){
        RectangularMap test8t = new RectangularMap(3,3);
        Animal animal = new Animal(test8t, new Vector2d(1,1));
        test8t.place(animal);
        assertNull(test8t.objectAt(new Vector2d(1, 2)));
    }
}
