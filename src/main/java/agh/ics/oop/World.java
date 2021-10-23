package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class World {
    static void run(Directions[] t) {
        for (int i = 0; i < t.length; i++) {
            switch (t[i]) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case BACK:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
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
            Vector2d vector = new Vector2d(this.x, this.y);
            vector.x += other.x;
            vector.y += other.y;
            return vector;
        }

        public Vector2d subtract(Vector2d other) {
            Vector2d vector = new Vector2d(this.x, this.y);
            vector.x -= other.x;
            vector.y -= other.y;
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
            Vector2d vector = new Vector2d(this.x, -this.y);
            vector.x *= -1;
            vector.y *= -1;
            return vector;
        }
    }

    public static void main(String[] args) {
        int m = 0, j = 0;
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], "l") || Objects.equals(args[i], "r") || Objects.equals(args[i], "f")
                    || Objects.equals(args[i], "b")) m += 1;
        }
        Directions[] _directions = new Directions[m];
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    _directions[j] = Directions.FORWARD;
                    j += 1;
                    break;
                case "l":
                    _directions[j] = Directions.LEFT;
                    j += 1;
                    break;
                case "r":
                    _directions[j] = Directions.RIGHT;
                    j += 1;
                    break;
                case "b":
                    _directions[j] = Directions.BACK;
                    j += 1;
                    break;
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
    }
}