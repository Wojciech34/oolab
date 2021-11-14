package agh.ics.oop;
import java.util.ArrayList;

public class OptionsParser {
    public ArrayList<MoveDirection> parse(String[] string){
        ArrayList<MoveDirection> result = new ArrayList<>();
        for (String s : string) {
            switch (s) {
                case "f" -> result.add(MoveDirection.FORWARD);
                case "b" -> result.add(MoveDirection.BACKWARD);
                case "l" -> result.add(MoveDirection.LEFT);
                case "r" -> result.add(MoveDirection.RIGHT);
            }
        }
        return result;
    }
}
