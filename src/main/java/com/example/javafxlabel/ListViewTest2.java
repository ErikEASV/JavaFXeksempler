package com.example.javafxlabel;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListViewTest2 extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView Experiment 1");

        // Def. af listview
        ListView listView = new ListView();

        //Her fylder vi nogle elementer i listen
        listView.getItems().add("Pære");
        listView.getItems().add("Banan");
        listView.getItems().add("Æble");

        // Eksperiment...
        //Frugt f = new Frugt("papaya");
        //listView.getItems().add(f);

        // Vi sætter en knap på, som kan fortælle, hvad der er valgt i listen
        Button button = new Button("Vis valgte frugt(er)");
        button.setOnAction(event -> {
            ObservableList valgteIndeks = listView.getSelectionModel().getSelectedIndices();
            if (valgteIndeks.size() == 0)
                System.out.println("Der er ikke valgte noget");
            else
                for (Object indeks : valgteIndeks){
                    System.out.println("Valgt index = " + indeks + " : " + listView.getItems().get((int) indeks));
                }
        });

        // Vi sætter en knap mere på, som tilføjer tilfældige frugter
        Button button2 = new Button("Tilføj flere frugter");
        button2.setOnAction(event -> {
            String flereFrugter[] = {"Appelsin", "Kokosnød", "Blomme", "Mandarin", "Ananas", "Daddel", "Nød"};
            listView.getItems().add(flereFrugter[(int)(Math.random()*flereFrugter.length)]);
            // Scroll til sidste frugt på listen, så man kan se den er tilføjet
            listView.scrollTo(listView.getItems().size()-1);
        });

        // Vi sætter en knap på, som fjerner den valgte frugt
        Button button3 = new Button("Fjern frugt");
        button3.setOnAction(event -> {
            ObservableList valgteIndeks = listView.getSelectionModel().getSelectedIndices();
            if (valgteIndeks.size() == 0)
                System.out.println("Der er ikke valgte noget");
            else
                for (Object indeks : valgteIndeks) {
                    listView.scrollTo(indeks); // Prøver at scrolle til det rigtige sted...
                    System.out.println("Valgt index = " + indeks + " : " + listView.getItems().get((int) indeks));
                    listView.getItems().remove((int) indeks);
                }
        });

        // Sortering af frugter
        Button button4 = new Button("Sortér frugter");
        button4.setOnAction(event -> {
            List<String> sorteretListe = new ArrayList<>();
            sorteretListe = listView.getItems();
            Collections.sort(sorteretListe);
        });

        // Vi sætter vinduet op med listeviewet og knapperne
        VBox vBox = new VBox(listView, button, button2, button3, button4);
        Scene scene = new Scene(vBox, 300, 220);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}