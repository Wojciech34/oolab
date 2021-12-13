package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class App extends Application {
    private final int  SceneHigh = 400;
    private final int SceneWidth = 400;
    private int NumberColumns = 0;
    private int NumberRows = 0;
    private Vector2d LowerLeft;
    private Vector2d UpperRight;
    private GridPane grid = new GridPane();
    private GrassField map;

    @Override
    public void init() throws Exception {
        List<String> args2 = getParameters().getRaw();
        try {
        //    Application.launch(App.class, args);
            this.map = new GrassField(10);
        //    System.out.println(map.toString());
            List<Vector2d> positions = new LinkedList<>();
            positions.add(new Vector2d(2, 2));
            positions.add(new Vector2d(3, 4));
            LinkedList<MoveDirection> directions = new OptionsParser().parse2(args2);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
     //       System.out.println(map.toString());
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }


    @Override
    public void start(Stage primaryStage){
        primaryStage.show();
   //     Label label = new Label("Zwierzak");
   //     Label label2 = new Label("*");
     //   Scene scene = new Scene(label, 400, 400);

        updateBorders(this.map.giveCorner1(),this.map.giveCorner2());
        createGrid();
        for (Vector2d vector : this.map.map_g.keySet()){
            Label label = new Label("*");
            grid.add(label,vector.x+1-LowerLeft.x,NumberRows-(vector.y+1-LowerLeft.y));
            grid.setHalignment(label, HPos.CENTER);
        }

        this.map.map_a.forEach((key, value) -> {
                    Label label = new Label(value.toString());
                    grid.add(label,key.x+1-LowerLeft.x,NumberRows-(key.y+1-LowerLeft.y));
                    grid.setHalignment(label, HPos.CENTER);
                }
                );
     /*   for (Vector2d vector : this.map.map_a.keySet()){
            Label label = new Label("T");
            grid.add(label,vector.x+1-LowerLeft.x,vector.y+1-LowerLeft.y);
            grid.setHalignment(label, HPos.CENTER);
        }
        */
   //     grid.add(label,0,0);
        Label label = new Label("y/x");
        grid.add(label,0,0);
        grid.setHalignment(label, HPos.CENTER);
        Scene scene = new Scene(grid,SceneWidth,SceneHigh);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void createGrid(){
        float ColumnWidth =  SceneWidth / NumberColumns;
        float RowHigh =  SceneHigh / NumberRows;

        for (int x=0; x<NumberColumns;x++){
            grid.getColumnConstraints().add(new ColumnConstraints(ColumnWidth));
            String t = String.valueOf(LowerLeft.x+x-1);
            Label label = new Label(t);
            if (x>0){ grid.add(label,x,0);
            grid.setHalignment(label, HPos.CENTER);}
        }
        for (int x=0; x<NumberRows; x++){
            grid.getRowConstraints().add(new RowConstraints(RowHigh));
            String t = String.valueOf(LowerLeft.y+x);
            Label label = new Label(t);
            if (x>0){ grid.add(new Label(String.valueOf(LowerLeft.y+x-1)), 0,NumberRows-x);
            grid.setHalignment(label, HPos.CENTER);}
        }
        grid.setGridLinesVisible(true);
    }
    public void updateBorders(Vector2d LowerLeft, Vector2d UpperRight){
        this.NumberColumns = UpperRight.x - LowerLeft.x + 2; // dodatkowe wiersze i kolumny na etykiety
        this.NumberRows = UpperRight.y - LowerLeft.y + 2;
        this.LowerLeft = LowerLeft;
        this.UpperRight = UpperRight;
    }

}
