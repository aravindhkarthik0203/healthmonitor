package com.ak.healthmonitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HealthMonitorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HealthMonitorApplication.class.getResource("HealthMonitor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 550);

        stage.setMinWidth(340);
        stage.setMinHeight(580);

        stage.setTitle("Health Monitor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}