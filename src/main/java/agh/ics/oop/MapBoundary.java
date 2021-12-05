package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private SortedSet<Vector2d> AxeX = new TreeSet<Vector2d>(new XComparator());
    private SortedSet<Vector2d> AxeY = new TreeSet<Vector2d>(new YComparator());

    class XComparator implements Comparator<Vector2d>{
        @Override
        public int compare(Vector2d v, Vector2d u){
            if (v.x < u.x || ((v.x == u.x)&&(v.y < u.y))){
                return -1;
            }
            else {return 1;}
        }
    }
    class YComparator implements Comparator<Vector2d>{
        @Override
        public int compare(Vector2d v, Vector2d u){
            if (v.y < u.y || ((v.y == u.y)&&(v.x < u.x))){
                return -1;
            }
            else {return 1;}
        }
    }
    public Vector2d getLowLeft(){
        return new Vector2d(AxeX.first().x, AxeY.first().y);
    }
    public Vector2d getUpRight(){
        return new Vector2d(AxeX.last().x,AxeY.last().y);
    }
    public void addElement(Vector2d v){
        AxeX.add(v);
        AxeY.add(v);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AxeX.remove(oldPosition);
        AxeX.add(newPosition);
        AxeY.remove(oldPosition);
        AxeY.add(newPosition);
    }


}
