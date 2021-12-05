package agh.ics.oop;
import java.util.ArrayList;
import java.util.LinkedList;

public class OptionsParser {
    public LinkedList<MoveDirection> parse(String[] string) throws IllegalArgumentException{
        LinkedList<MoveDirection> result = new LinkedList<>();
        for (String s : string) {
            switch (s) {
                case "f", "forward" -> result.add(MoveDirection.FORWARD);
                case "b", "backward" -> result.add(MoveDirection.BACKWARD);
                case "l", "left" -> result.add(MoveDirection.LEFT);
                case "r", "right" -> result.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(s + " is not legal move specifications");
            }
        }
        return result;
    }
}
