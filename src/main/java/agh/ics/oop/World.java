package agh.ics.oop;


import java.util.ArrayList;
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
        int m = 0, j = 0;
        for (String s : args) {
            if (Objects.equals(s, "l") || Objects.equals(s, "r") || Objects.equals(s, "f")
                    || Objects.equals(s, "b")) m += 1;
        }
        Directions[] _directions = new Directions[m];
        for (String arg : args) {
            switch (arg) {
                case "f" -> {
                    _directions[j] = Directions.FORWARD;
                    j += 1;
                }
                case "l" -> {
                    _directions[j] = Directions.LEFT;
                    j += 1;
                }
                case "r" -> {
                    _directions[j] = Directions.RIGHT;
                    j += 1;
                }
                case "b" -> {
                    _directions[j] = Directions.BACK;
                    j += 1;
                }
            }
        }
        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //System.out.println(map.toString());
    }
}