package agh.ics.oop.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import agh.ics.oop.Directions;
import agh.ics.oop.MapDirection;
import agh.ics.oop.Vector2d;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class GuiElementBox {
    private Image image;
    private ImageView imageview;
    private Label label;
    private VBox vBox = new VBox(3);
    private Group group = new Group();
    public GuiElementBox(MapDirection direct, Vector2d position) throws FileNotFoundException {
        switch (direct){
            case EAST -> this.image = new Image(new FileInputStream("src/main/resources/right.png"));
            case WEST -> this.image = new Image(new FileInputStream("src/main/resources/left.png"));
            case SOUTH -> this.image = new Image(new FileInputStream("src/main/resources/down.png"));
            case NORTH -> this.image = new Image(new FileInputStream("src/main/resources/up.png"));
        }
        this.imageview = new ImageView(this.image);
        this.imageview.setFitHeight(20);
        this.imageview.setFitWidth(20);
        this.label = new Label(position.toString());
        this.vBox.getChildren().add(imageview);
        this.vBox.getChildren().add(label);
        //this.label.setGraphic(imageview);
        group.getChildren().add(vBox);
    }
    public GuiElementBox(Vector2d position) throws FileNotFoundException {
        this.image = new Image(new FileInputStream("src/main/resources/grass.png"));
        this.imageview = new ImageView(this.image);
        this.imageview.setFitHeight(20);
        this.imageview.setFitWidth(20);
        this.label = new Label(position.toString());
        this.vBox.getChildren().add(imageview);
        this.vBox.getChildren().add(label);
        group.getChildren().add(vBox);
    }
    public Group getRoot(){
        return this.group;
    }






}
