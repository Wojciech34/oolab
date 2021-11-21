package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private int number;
    private Random generator = new Random();
    private LinkedList<Grass> map_g = new LinkedList<>();
    private Vector2d min_left = new Vector2d(0,0);
    private Vector2d max_right = new Vector2d(0,0);
    public GrassField(int x){
        this.number = x;
        int m = (int) Math.sqrt(10 * x);
        for (int i=0; i<x; i++){
            while (true) { // uwzględniam czy 2 kępki trawy nie występują na tym samym polu
                Grass temp = new Grass(new Vector2d(generator.nextInt(m), generator.nextInt(m)));
                boolean flag = true;
                for (Grass g : map_g){
                    if (g.getPosition().equals(temp.getPosition())) {
                        flag = false;
                        break;}
                    }
                if (flag){
                    map_g.add(temp);
                    min_left = temp.getPosition().lowerLeft(min_left);
                    max_right = temp.getPosition().upperRight(max_right);
                    break;}
                }
            }
        }
    public LinkedList<Animal> getAnimals(){
        return map_a;
    }

    @Override
    public Vector2d giveCorner1() {
        for (Animal a: map_a){
            min_left = a.position.lowerLeft(min_left);
        }
        return min_left;
    }

    @Override
    public Vector2d giveCorner2() {
        for (Animal a: map_a){
            max_right = a.position.upperRight(max_right);
        }
        return max_right;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)){
            map_a.add(animal);
            min_left = animal.position.lowerLeft(min_left);
            max_right = animal.position.upperRight(max_right);
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal a : map_a){
            if (a.position.equals(position)){
                return false;}
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a: map_a) {
            if (a.position.equals(position)) {
                return true;}
        }
        for (Grass g: map_g){
            if (g.getPosition().equals(position)){
                return true;}
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) { // jesli pewne pola zajmuje animal i grass to zwracany jest animal
        for (Animal a : map_a){
            if (a.position.equals(position)){return a;}
        }
        for (Grass g : map_g){
            if (g.getPosition().equals(position)){return g;}
        }
        return null;
    }
}

