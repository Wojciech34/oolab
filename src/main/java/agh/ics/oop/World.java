package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.lang.Exception;

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

    public static class Vector2d {
        public int x;
        public int y;

        public Vector2d(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }

        public boolean precedes(Vector2d other) {
            if (this.x <= other.x && this.y <= other.y)
                return true;
            return false;
        }

        public boolean follows(Vector2d other) {
            if (this.x >= other.x && this.y >= other.y)
                return true;
            return false;
        }

        public Vector2d upperRight(Vector2d other) {
            Vector2d vector = new Vector2d(this.x, this.y);
            if (vector.x < other.x)
                vector.x = other.x;
            if (vector.y < other.y)
                vector.y = other.y;
            return vector;
        }

        public Vector2d lowerLeft(Vector2d other) {
            Vector2d vector = new Vector2d(this.x, this.y);
            if (vector.x > other.x)
                vector.x = other.x;
            if (vector.y > other.y)
                vector.y = other.y;
            return vector;
        }

        public Vector2d add(Vector2d other) {
            Vector2d vector = new Vector2d(this.x+ other.x, this.y+ other.y);
            this.x += other.x;
            this.y += other.y;
            //vector.x += other.x;
            //vector.y += other.y;
            return vector;
        }

        public Vector2d subtract(Vector2d other) {
            Vector2d vector = new Vector2d(this.x- other.x, this.y- other.y);
            this.x -= other.x;
            this.y -= other.y;
            return vector;
        }

        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof Vector2d))
                return false;
            Vector2d that = (Vector2d) other;
            if (that.x == this.x && that.y == this.y)
                return true;
            return false;
        }

        public Vector2d opposite() {
            Vector2d vector = new Vector2d(this.x, this.y);
            vector.x *= -1;
            vector.y *= -1;
            return vector;
        }
    }

    public enum MoveDirection {
        FORWARD, BACKWARD, RIGHT, LEFT;
    }

    public enum MapDirection {
        NORTH, SOUTH, WEST, EAST;
        public String toString() {
            switch (this){
                case NORTH -> {return "Północ";}
                case SOUTH -> {return "Południe";}
                case WEST -> {return "Zachód";}
                case EAST -> {return "Wschód";}
            }
            return "Error";
        }
        public MapDirection next() throws Exception {
            switch (this){
                case NORTH -> {return EAST;}
                case SOUTH -> {return WEST;}
                case WEST -> {return NORTH;}
                case EAST -> {return SOUTH;}
            }
            throw new Exception("Error");
        }
        public MapDirection previous() throws Exception {
            switch(this){
                case NORTH -> {return WEST;}
                case SOUTH -> {return EAST;}
                case WEST -> {return SOUTH;}
                case EAST -> {return NORTH;}
            }
            throw new Exception("Error");
        }
        public Vector2d toUnitVector() throws Exception {
            switch (this){
                case NORTH -> {return new Vector2d(0,1);}
                case SOUTH -> {return new Vector2d(0,-1);}
                case WEST -> {return new Vector2d(-1,0);}
                case EAST -> {return new Vector2d(1,0);}
            }
            throw new Exception("Error");
        }
    }

    public static void main(String[] args) throws Exception {
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
        System.out.println("start");
        run(_directions);
        System.out.println("stop");
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection tiger = MapDirection.EAST;
        System.out.println(tiger.toUnitVector());
        Animal animal = new Animal();
        //animal.move(MoveDirection.RIGHT);
        //animal.move(MoveDirection.FORWARD);
        //animal.move(MoveDirection.FORWARD);
        //animal.move(MoveDirection.FORWARD);
        System.out.println(animal);
        ArrayList<MoveDirection> test = OptionsParser.parse(args);
        for (MoveDirection direction : test) {
            animal.move(direction);
        }
        System.out.println(animal);
    }
}