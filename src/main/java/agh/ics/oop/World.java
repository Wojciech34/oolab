package agh.ics.oop;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class World {
    static void run(Directions[] t) {
        for (Directions directions : t) {
            switch (directions) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case BACK -> System.out.println("Zwierzak idzie do tyłu");
            }
        }
    }

    public static void main(String[] args) {
/*
        LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //System.out.println(map.toString());
*/
        IWorldMap map = new GrassField(10);
        //System.out.println(map.toString());
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //System.out.println(map.toString());
    }
}