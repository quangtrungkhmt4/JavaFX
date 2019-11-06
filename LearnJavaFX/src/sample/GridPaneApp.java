package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        GridPane root = new GridPane();
        root.setHgap(8);
        root.setVgap(8);
        root.setPadding(new Insets(5));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER);
        root.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);

        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);

        root.getRowConstraints().addAll(row1, row2);

        Label lb = new Label("Name: ");
        TextField field = new TextField();
        ListView view = new ListView();
        Button okBtn = new Button("OK");
        Button closeBtn = new Button("Close");
        GridPane.setHalignment(okBtn, HPos.RIGHT);

        root.add(lb, 0, 0);
        root.add(field, 1,0,3,1);
        root.add(view, 0,1,4,2);
        root.add(okBtn,2,3);
        root.add(closeBtn,3,3);

        Scene scene = new Scene(root, 280, 300);

        stage.setTitle("GridPane");
        stage.setScene(scene);
        stage.show();
    }
}
