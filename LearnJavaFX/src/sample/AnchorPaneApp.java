package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sun.plugin.javascript.navig4.Anchor;

import javax.swing.*;

public class AnchorPaneApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        AnchorPane  root = new AnchorPane();

        Button okBtn = new Button("OK");
        Button closeBtn = new Button("Close");
        HBox hBox = new HBox(5, okBtn, closeBtn);
        root.getChildren().addAll(hBox);

        AnchorPane.setRightAnchor(hBox, 10d);
        AnchorPane.setBottomAnchor(hBox, 10d);

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Anchor app");
        stage.setScene(scene);
        stage.show();

    }
}
