package agh.ics.oop;
import java.util.ArrayList;

public class OptionsParser {
    public static ArrayList<World.MoveDirection> parse(String[] string){
        ArrayList<World.MoveDirection> result = new ArrayList<>();
        for (String s : string) {
            switch (s) {
                case "f" -> result.add(World.MoveDirection.FORWARD);
                case "b" -> result.add(World.MoveDirection.BACKWARD);
                case "l" -> result.add(World.MoveDirection.LEFT);
                case "r" -> result.add(World.MoveDirection.RIGHT);
            }
        }
        return result;
    }
}
