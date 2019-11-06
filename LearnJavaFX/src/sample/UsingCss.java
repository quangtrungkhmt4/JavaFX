package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UsingCss extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        HBox root = new HBox();
        root.setPadding(new Insets(20));

        Text text = new Text("Trung hello");
        text.setFont(Font.font("Serif", FontWeight.BOLD, 76));

        text.setId("text");
        root.setId("root");

        root.getChildren().addAll(text);


        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("css/text.css").toExternalForm());
        stage.setTitle("demo css");
        stage.setScene(scene);
        stage.show();


    }
}
