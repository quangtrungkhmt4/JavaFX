package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Chat system");

        VBox layout = new VBox();
        TextArea textArea = new TextArea();
        textArea.setPadding(new Insets(10));
        textArea.setText("dfdfd");
        textArea.appendText("sssss");

        HBox bottom = new HBox();
        TextField input = new TextField();
        Button btnSend = new Button("Send");
        btnSend.setOnAction(event -> {
            String str = input.getText();
            textArea.appendText("\n" + str);
            input.clear();
        });
        bottom.getChildren().addAll(input, btnSend);

        layout.getChildren().addAll(textArea, bottom);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
