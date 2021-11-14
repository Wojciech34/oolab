package agh.ics.oop;

public class Animal {
    public Vector2d position;
    private MapDirection direct = MapDirection.NORTH;
    private IWorldMap map;
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }


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
            case LEFT -> direct = direct.previous();
            case RIGHT -> direct = direct.next();
            case FORWARD -> {
                if (map.canMoveTo(position.add(direct.toUnitVector()))){
                    position = position.add(direct.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(direct.toUnitVector()))){
                    position = position.subtract(direct.toUnitVector());
                }
            }
        }
    }
}
