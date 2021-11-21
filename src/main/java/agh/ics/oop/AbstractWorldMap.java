package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;

abstract class AbstractWorldMap implements IWorldMap {
    protected LinkedList<Animal> map_a = new LinkedList<>();
    public String toString(){
        Vector2d vector1 = giveCorner1();
        Vector2d vector2 = giveCorner2();
        return new MapVisualizer(this).draw(vector1, vector2);
    }
    public abstract Vector2d giveCorner1(); // lewy dolny róg mapy
    public abstract Vector2d giveCorner2(); // prawy górny róg mapy
}
