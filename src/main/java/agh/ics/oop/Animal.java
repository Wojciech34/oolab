package agh.ics.oop;

import java.util.LinkedList;

public class Animal {
    public Vector2d position = new Vector2d(2,2);
    private MapDirection direct = MapDirection.NORTH;
    private IWorldMap map;
    protected LinkedList<IPositionChangeObserver> observers = new LinkedList<>();
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public MapDirection getDirect(){return this.direct;}
    public String toString(){
        switch (direct) {
            case NORTH -> {return "^";}
            case EAST -> {return ">";}
            case SOUTH -> {return "v";}
            case WEST -> {return "<";}
        }
        return "^"; //powinno nigdy nie mieć miejsca
    }
    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> {
                direct = direct.previous();
                this.positionChanged(position,position);
            }

            case RIGHT ->{
                direct = direct.next();
                this.positionChanged(position,position);
            }
            case FORWARD -> {
                if (map.canMoveTo(position.add(direct.toUnitVector()))){
                    this.positionChanged(position, position.add(direct.toUnitVector()));
                    position = position.add(direct.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(direct.toUnitVector()))){
                    this.positionChanged(position, position.subtract(direct.toUnitVector()));
                    position = position.subtract(direct.toUnitVector());
                }
            }
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
