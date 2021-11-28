package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private int number;
    private Random generator = new Random();
    //private LinkedList<Grass> map_g = new LinkedList<>();
    private Map<Vector2d, Grass> map_g = new HashMap<>();

    public GrassField(int x){
        this.number = x;
        int m = (int) Math.sqrt(10 * x);
        for (int i=0; i<x; i++){
            while (true) { // uwzględniam czy 2 kępki trawy nie występują na tym samym polu
                Grass temp = new Grass(new Vector2d(generator.nextInt(m), generator.nextInt(m)));
                boolean flag = true;
                if (map_g.get(temp.getPosition()) == null){
                    map_g.put(temp.getPosition(), temp);} else{
                    flag = false;
                }
                if (flag){
                    min_left = temp.getPosition().lowerLeft(min_left);
                    max_right = temp.getPosition().upperRight(max_right);
                    break;}
                }
            }
        }
    public Map<Vector2d, Animal> getAnimals(){
        return map_a;
    }

    @Override
    public Vector2d giveCorner1() {
        return min_left;
    }

    @Override
    public Vector2d giveCorner2() {
        return max_right;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return map_a.get(position) == null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (map_a.get(position) != null) {return true;}
        return map_g.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) { // jesli pewne pola zajmuje animal i grass to zwracany jest animal
        Animal t = map_a.get(position);
        if (t != null){return t;}
        Grass z = map_g.get(position);
        if (z != null) {return z;}
        return null;
    }
}

