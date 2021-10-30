package agh.ics.oop;

public class Animal {
    private World.Vector2d position = new World.Vector2d(2,2);
    private World.MapDirection direct = World.MapDirection.NORTH;
    public String toString(){
        return direct + "," + position;
    }
    public void move(World.MoveDirection direction) throws Exception {
        switch (direction){
            case LEFT -> this.direct = this.direct.previous();
            case RIGHT -> this.direct = this.direct.next();
            case FORWARD -> {
                this.position.add(this.direct.toUnitVector());
                if (this.position.x > 4){this.position.x = 4;}
                if (this.position.x < 0){this.position.x = 0;}
                if (this.position.y > 4){this.position.y = 4;}
                if (this.position.y < 0){this.position.y = 0;}
            }
            case BACKWARD -> {
                this.position.subtract(this.direct.toUnitVector());
                if (this.position.x > 4){this.position.x = 4;}
                if (this.position.x < 0){this.position.x = 0;}
                if (this.position.y > 4){this.position.y = 4;}
                if (this.position.y < 0){this.position.y = 0;}
            }
        }
    }

}
