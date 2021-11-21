package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class RectangularMap extends AbstractWorldMap{
    private int w;
    private int h;

    public RectangularMap(int width, int height){
        w = width;
        h = height;
    }
    public LinkedList<Animal> getAnimals(){
        return map_a;
    }

    @Override
    public Vector2d giveCorner1() {
        return new Vector2d(0,0);
    }

    @Override
    public Vector2d giveCorner2() {
        return new Vector2d(w-1, h-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return 0 <= position.x && w > position.x && 0 <= position.y && h > position.y && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)) {
            map_a.add(animal);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : map_a){
            if (a.position.equals(position)){return true;}
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a : map_a){
            if (a.position.equals(position)){return a;}
        }
        return null;
    }

}
