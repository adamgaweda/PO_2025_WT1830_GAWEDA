package agh.ics.oop.model.application;

import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimulationApp extends Application {


    public void start(Stage primaryStage) throws Exception {
        //Będzie to metoda uruchamiająca interfejs graficzny Twojej aplikacji.

        FXMLLoader loader = new FXMLLoader(); // zainicjowanie wczytywania FXML

        // wczytanie zasobu z katalogu resources (uniwersalny sposób)
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));

        // Wczytanie FXML, konwersja FXML -> obiekty w Javie
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        WorldMap worldMap = new GrassField(100);
        presenter.setWorldMap(worldMap);
        configureStage(primaryStage,viewRoot);
        primaryStage.show();


    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        // stworzenie sceny (panelu do wyświetlania wraz zawartością z FXML)
        var scene = new Scene(viewRoot);

        // ustawienie sceny w oknie
        primaryStage.setScene(scene);

        // konfiguracja okna
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

}
