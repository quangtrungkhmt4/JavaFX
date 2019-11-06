package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AbsoluteLayout extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        Pane root = new Pane();

        Rectangle rect = new Rectangle(25,25,50,50);
        rect.setFill(Color.AQUAMARINE);

        Line line = new Line(90,40,230,40);
        line.setStroke(Color.BLACK);

        Circle circle = new Circle(130,130,30);
        circle.setFill(Color.AQUA);

        root.getChildren().addAll(rect, circle, line);

        Scene scene = new Scene(root, 250,250,Color.WHITESMOKE);

        stage.setTitle("Absolute layout");
        stage.setScene(scene);
        stage.show();
    }
}
