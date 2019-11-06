package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.BASELINE_RIGHT);

        Button prevBtn = new Button("Previous");
        Button nextBtn = new Button("Next");
        Button cancBtn = new Button("Cancel");
        Button helpBtn = new Button("Help");


        hBox.getChildren().addAll(prevBtn, nextBtn, cancBtn, helpBtn);

        Scene scene = new Scene(hBox);
        stage.setTitle("Hbox");
        stage.setScene(scene);
        stage.show();
    }
}
