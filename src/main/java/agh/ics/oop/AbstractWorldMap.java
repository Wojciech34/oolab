package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    //protected LinkedList<Animal> map_a = new LinkedList<>();
    protected Map<Vector2d, Animal> map_a = new HashMap<>();
  //  protected Vector2d min_left = new Vector2d(0,0);
 //   protected Vector2d max_right = new Vector2d(0,0);
    public String toString(){
        Vector2d vector1 = giveCorner1();
        Vector2d vector2 = giveCorner2();
        return new MapVisualizer(this).draw(vector1, vector2);
    }
    public abstract Vector2d giveCorner1(); // lewy dolny róg mapy
    public abstract Vector2d giveCorner2(); // prawy górny róg mapy

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        map_a.put(newPosition, map_a.get(oldPosition));
        map_a.remove(oldPosition);
 //       min_left = newPosition.lowerLeft(min_left);
  //      max_right = newPosition.upperRight(max_right);
    }
    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (canMoveTo(animal.position)){
            map_a.put(animal.position, animal);
 //           min_left = animal.position.lowerLeft(min_left);
  //          max_right = animal.position.upperRight(max_right);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException(animal.position.toString() + " is not available");
    }
}
