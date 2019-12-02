package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Demo extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){

        VBox root = new VBox();
        root.setPadding(new Insets(10));

        HBox rowOne = new HBox();
        Button btnOk = new Button("OK");
        rowOne.getChildren().add(btnOk);

        btnOk.setOnAction((ActionEvent event) -> {
            HBox row = new HBox();
            Button ok = new Button("OK");
            row.getChildren().add(ok);
            root.getChildren().add(row);
        });

        root.getChildren().add(rowOne);

        Scene scene = new Scene(root, 300, 300);

        stage.setTitle("demo");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
