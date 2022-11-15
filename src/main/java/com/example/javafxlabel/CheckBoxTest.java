package com.example.javafxlabel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class CheckBoxTest extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l = new Label("What do you listen:     ");
        CheckBox c1 = new CheckBox("Radio one");
        CheckBox c2 = new CheckBox("Radio Mirchi");
        CheckBox c3 = new CheckBox("Red FM");
        CheckBox c4 = new CheckBox("FM GOLD");
        c4.setSelected(true);
        HBox root = new HBox();

        c2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Checkbox Radio two: " + c2.isSelected());
            }
        } );

        Button btn=new Button("OK");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Checkbox Radio one: " + c1.isSelected());
            }
        } );


        root.getChildren().addAll(l,c1,c2,c3,c4,btn);
        root.setSpacing(5);
        Scene scene=new Scene(root,800,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CheckBox Example");
        primaryStage.show();
    }
}