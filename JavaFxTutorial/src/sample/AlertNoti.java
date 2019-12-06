package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class AlertNoti extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AlertNoti");

        Button button = new Button("Close");
        button.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText("Alert information");
            alert.setContentText("Choose your option");

            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(yes, no, cancel);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get().getButtonData() == ButtonBar.ButtonData.YES){
                System.out.println("yes");
            }else if(result.get().getButtonData() == ButtonBar.ButtonData.NO){
                System.out.println("No");
            }else {
                System.out.println("Cancel");
            }

            String message = result.get().getText();

            Alert notiMessage = new Alert(Alert.AlertType.INFORMATION);
            notiMessage.setTitle("Information");
            notiMessage.setContentText(message);
            notiMessage.show();
        });




        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
