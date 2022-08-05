package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Authentification.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 540);
        stage.setTitle("Contrat de bail");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        testConnection.connect();
        launch();
    }
}