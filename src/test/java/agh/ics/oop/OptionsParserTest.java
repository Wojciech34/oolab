package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class OptionsParserTest {
    @Test
    public void forwardTest(){
        try {
        String[] args = {"f"};
        LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
        assertEquals(MoveDirection.FORWARD, directions.getFirst());}
        catch (IllegalArgumentException e){
            fail(e.toString());
        }
    }
    @Test
    public void backwardTest(){
        try {
            String[] args = {"b"};
            LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
            assertEquals(MoveDirection.BACKWARD, directions.getFirst());}
        catch (IllegalArgumentException e){
            fail(e.toString());
        }
    }
    @Test
    public void leftTest(){
        try {
            String[] args = {"l"};
            LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
            assertEquals(MoveDirection.LEFT, directions.getFirst());}
        catch (IllegalArgumentException e){
            fail(e.toString());
        }
    }
    @Test
    public void rightTest(){
        try {
            String[] args = {"r"};
            LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
            assertEquals(MoveDirection.RIGHT, directions.getFirst());}
        catch (IllegalArgumentException e){
            fail(e.toString());
        }
    }
    @Test
    public void extraTest1(){
        try {
            String[] args = {"forward", "backward", "left", "right"};
            LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
            LinkedList<MoveDirection> result = new LinkedList<>();
            result.add(MoveDirection.FORWARD);
            result.add(MoveDirection.BACKWARD);
            result.add(MoveDirection.LEFT);
            result.add(MoveDirection.RIGHT);
            assertEquals(result, directions);}
        catch (IllegalArgumentException e){
            fail(e.toString());
        }
    }

}
