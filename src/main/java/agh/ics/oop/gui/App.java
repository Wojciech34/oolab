package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class App extends Application implements IPositionChangeObserver {
    private final int  SceneHigh = 400;
    private final int SceneWidth = 400;
    private int NumberColumns = 0;
    private int NumberRows = 0;
    private Vector2d LowerLeft;
    private Vector2d UpperRight;
    private GridPane grid = new GridPane();
    private GrassField map;
    private SimulationEngine engine;
    private Stage primaryStage;

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        Platform.runLater(() -> {
            this.grid.getChildren().clear();
            this.grid.setGridLinesVisible(false);
            this.grid.getRowConstraints().clear();
            this.grid.getColumnConstraints().clear();
            try{
                updateBorders(this.map.giveCorner1(),this.map.giveCorner2());
                createGrid();

            this.grid.setGridLinesVisible(true);} catch (FileNotFoundException e){}
            try {
                Scene scene = new Scene(grid, SceneWidth, SceneHigh);
                this.primaryStage.setScene(scene);
                this.primaryStage.show();
            } catch (IllegalArgumentException e) {}



        });

    }

    @Override
    public void init() {
        List<String> args2 = getParameters().getRaw();
        try {
            this.map = new GrassField(10);
            List<Vector2d> positions = new LinkedList<>();
            positions.add(new Vector2d(2, 2));
            positions.add(new Vector2d(3, 4));
            LinkedList<MoveDirection> directions = new OptionsParser().parse2(args2);
            this.engine = new SimulationEngine(directions, map, positions);
            setObservers();
    //        Thread thread1 = new Thread((Runnable) this.engine);
     //       thread1.start();
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }


    @Override
    public void start(Stage primaryStage) {

        try{
            updateBorders(this.map.giveCorner1(),this.map.giveCorner2());
            createGrid();
            this.grid.setGridLinesVisible(true);} catch (FileNotFoundException e){}


        TextField textfield = new TextField();
        Button button = new Button("Start");
        HBox hbox = new HBox(textfield);
        VBox firstVBox = new VBox();
        firstVBox.getChildren().addAll(hbox,button);
        GridPane firstGrid = new GridPane();
        firstGrid.getChildren().add(firstVBox);
        Scene firstScene = new Scene(firstGrid, 200,200);
        Stage firstStage = new Stage();
        firstStage.setScene(firstScene);
        firstStage.show();
        this.primaryStage = primaryStage;
        Scene scene = new Scene(grid,SceneWidth,SceneHigh);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        button.setOnAction(t -> {
                    String[] s = textfield.getText().split(" ");
                    LinkedList<MoveDirection> directions = new OptionsParser().parse(s);
                    this.engine.updateSteps(directions);
                    Thread thread = new Thread((Runnable) this.engine);
                    thread.start();

                }
                );
        textfield.setOnAction(t -> {
            String[] s = textfield.getText().split(" ");
            LinkedList<MoveDirection> directions = new OptionsParser().parse(s);
            this.engine.updateSteps(directions);
            Thread thread = new Thread((Runnable) this.engine);
            thread.start();
            textfield.clear();
        });
     //   this.init();

    }
    private void setObservers(){
        this.map.map_a.forEach((k,a) -> {
            a.addObserver(this);
        });

    }
    private void createGrid() throws FileNotFoundException {
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
        for (Vector2d vector : this.map.map_g.keySet()){
            if (!this.map.map_a.containsKey(vector)){
            GuiElementBox box = new GuiElementBox(vector);
            grid.add(box.getRoot(),vector.x+1-LowerLeft.x,NumberRows-(vector.y+1-LowerLeft.y));
            grid.setHalignment(box.getRoot(), HPos.CENTER);}
        }

        this.map.map_a.forEach((key, value) -> {
                    try {
                        GuiElementBox box = new GuiElementBox(value.getDirect(), key);
                        grid.add(box.getRoot(),key.x+1-LowerLeft.x,NumberRows-(key.y+1-LowerLeft.y));
                        grid.setHalignment(box.getRoot(), HPos.CENTER);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        );

        Label label = new Label("y/x");
        grid.add(label,0,0);
        grid.setHalignment(label, HPos.CENTER);

    }
    public void updateBorders(Vector2d LowerLeft, Vector2d UpperRight){
        this.NumberColumns = UpperRight.x - LowerLeft.x + 2; // dodatkowe wiersze i kolumny na etykiety
        this.NumberRows = UpperRight.y - LowerLeft.y + 2;
        this.LowerLeft = LowerLeft;
        this.UpperRight = UpperRight;
    }

}
