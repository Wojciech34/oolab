package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    public void test1(){
        ArrayList<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.BACKWARD);
        directions.add(MoveDirection.RIGHT);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(1,6));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0,3)) && map.isOccupied(new Vector2d(1,6)));
    }
    @Test
    public void test2(){
        ArrayList<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.BACKWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.LEFT);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(1,1));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0,1)) && map.isOccupied(new Vector2d(1,0)));
    }
    @Test
    public void test3(){
        ArrayList<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.BACKWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.BACKWARD);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0,5));
        positions.add(new Vector2d(0,6));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0,5)) && map.isOccupied(new Vector2d(0,6)));
    }
}
