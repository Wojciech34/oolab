package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
public class RectangularMap implements IWorldMap{
    private int w;
    private int h;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        w = width;
        h = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return 0 <= position.x && w > position.x && 0 <= position.y && h > position.y && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)) {
            animals.add(animal);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals){
            if (animal.position.equals(position)){return true;}
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals){
            if (animal.position.equals(position)){return animal;}
        }
        return null;
    }

    public String toString(){
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(w-1, h-1));
    }
}
