package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
public class SimulationEngine implements IEngine{
    private IWorldMap main_map;
    private List<MoveDirection> main_steps;
    private List<Animal> animals = new ArrayList<>();

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

    @Override
    public void run() {
        int i=0;
        int n = animals.size();
        System.out.println(main_map.toString()); // printowac to?
        for (MoveDirection step : main_steps){
            animals.get(i).move(step);
            System.out.println(main_map.toString()); // printowac to?
            i += 1;
            i %= n;
        }
    }
}
