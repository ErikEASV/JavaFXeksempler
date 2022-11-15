package com.example.javafxlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LabelTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label my_label = new Label("This is an example of Label");

        // Nedenstående lndrer tekst og font
        my_label.setText("Ny tekst");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16);
        my_label.setFont(font);


        StackPane root = new StackPane();
        Scene scene=new Scene(root,300,300);
        root.getChildren().add(my_label);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Label Class Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}