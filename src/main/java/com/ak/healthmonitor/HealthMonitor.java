package com.ak.healthmonitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HealthMonitor extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HealthMonitor.class.getResource("health-monitor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 330, 550);
        stage.setTitle("Health Monitor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}