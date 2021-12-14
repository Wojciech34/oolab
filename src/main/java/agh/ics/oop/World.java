package agh.ics.oop;


import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            Application.launch(App.class, args);
            }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
