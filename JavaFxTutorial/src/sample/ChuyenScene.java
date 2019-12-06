package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChuyenScene extends Application {

    private Stage window;
    private Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Label label = new Label("Hello guys");

        Button button = new Button("Scene 2");
        button.setOnAction(event -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, button);
        scene1 = new Scene(layout1, 300, 300);

        Button button1 = new Button("Go to scene 1");
        button1.setOnAction(event -> {
            window.setScene(scene1);
        });
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button1);
        scene2 = new Scene(layout2, 300, 350);

        window.setScene(scene1);
        window.show();
    }
}
