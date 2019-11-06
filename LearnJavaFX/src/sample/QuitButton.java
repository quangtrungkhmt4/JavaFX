package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

public class QuitButton extends Application {


    @Override
    public void start(Stage primaryStage)  {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        Button button = new Button();

        //info button
        Tooltip tooltip = new Tooltip("button nà");
        Tooltip.install(button, tooltip);

        button.setText("Quit");
        button.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });


        //horizontal layout

        HBox root = new HBox();
        root.setPadding(new Insets(25));
        root.getChildren().add(button);

        Scene scene = new Scene(root, 280, 200);
        stage.setTitle("check button");
        stage.setScene(scene);
        stage.show();
    }
}
