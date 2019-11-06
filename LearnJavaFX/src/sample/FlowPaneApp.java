package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL, 5,5);

        flowPane.setPadding(new Insets(5));

        for (int i=1; i<=20; i++){
            flowPane.getChildren().add(new Button(String.valueOf(i)));
        }

        Scene scene = new Scene(flowPane, 300, 250);
        stage.setTitle("Flow Pane");
        stage.setScene(scene);
        stage.show();
    }
}
