package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class SimulationEngine implements IEngine{
    private final IWorldMap main_map;
    private List<MoveDirection> main_steps;
    private List<Animal> animals = new LinkedList<>();

    public SimulationEngine(List<MoveDirection> steps, IWorldMap map, List<Vector2d> vectors){
        main_map = map;
        main_steps = steps;
        for (Vector2d vector : vectors){
            Animal temporaryAnimal = new Animal(main_map, vector);
            if (main_map.place(temporaryAnimal)){
               animals.add(temporaryAnimal);
            }
        }
    }
    public List<Animal> getAnimals(){return this.animals;}

    @Override
    public void run() {
        int i=0;
        int n = animals.size();
       // System.out.println(main_map.toString()); // printowac to?
        for (MoveDirection step : main_steps){
            animals.get(i).move(step);
//            System.out.println(i);
//            System.out.println(step);
//            System.out.println(main_map.toString()); // printowac to?
            i += 1;
            i %= n;

        }
    }
}
