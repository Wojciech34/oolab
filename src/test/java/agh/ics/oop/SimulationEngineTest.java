package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    // testy to RectangularMap
    @Test
    public void test1(){ // podstawowe kroki
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(0,0));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.EAST, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(1,1), engine.getAnimals().get(0).position);
    }
    @Test
    public void test2(){ // wychodzenie poza mape
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(3,8));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.NORTH, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(3,9), engine.getAnimals().get(0).position);
    }
    @Test
    public void test3(){ // podstawowe kroki kilu zwierzat
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(2,2));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.EAST, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(1,0), engine.getAnimals().get(0).position);
        assertEquals(MapDirection.EAST, engine.getAnimals().get(1).getDirect());
        assertEquals(new Vector2d(3,2), engine.getAnimals().get(1).position);
    }
    @Test
    public void test4(){ // interakcje pomiedzy zwierzetami
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new RectangularMap(10,10);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(5,5));
        positions.add(new Vector2d(6,5));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.EAST, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(5,5), engine.getAnimals().get(0).position);
        assertEquals(MapDirection.WEST, engine.getAnimals().get(1).getDirect());
        assertEquals(new Vector2d(6,5), engine.getAnimals().get(1).position);
    }
    // testy do GrassField
    @Test
    public void test1g(){ // podstawowe kroki
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new GrassField(5);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(0,0));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.EAST, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(1,1), engine.getAnimals().get(0).position);
    }
    @Test
    public void test2g(){ // poszerzanie mapy
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new GrassField(2);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(20,20));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.NORTH, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(20,23), engine.getAnimals().get(0).position);
    }
    @Test
    public void test3g(){ // podstawowe kroki kilu zwierzat
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new GrassField(5);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(2,2));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.EAST, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(1,0), engine.getAnimals().get(0).position);
        assertEquals(MapDirection.EAST, engine.getAnimals().get(1).getDirect());
        assertEquals(new Vector2d(3,2), engine.getAnimals().get(1).position);
    }
    @Test
    public void test4g(){ // interakcje pomiedzy zwierzetami
        List<MoveDirection> directions = new LinkedList<>();
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IWorldMap map = new GrassField(5);
        List<Vector2d> positions = new LinkedList<>();
        positions.add(new Vector2d(5,5));
        positions.add(new Vector2d(6,5));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(MapDirection.EAST, engine.getAnimals().get(0).getDirect());
        assertEquals(new Vector2d(5,5), engine.getAnimals().get(0).position);
        assertEquals(MapDirection.WEST, engine.getAnimals().get(1).getDirect());
        assertEquals(new Vector2d(6,5), engine.getAnimals().get(1).position);
    }
}
