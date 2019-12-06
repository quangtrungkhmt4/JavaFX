package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewSample extends Application {

    private ListView<Student> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Demo ListView");
        listView = new ListView<>();

        Student student1 = new Student("Trung", 11);
        Student student2 = new Student("Quang", 20);
        listView.getItems().addAll(student1, student2);

        listView.setCellFactory(param -> new ListCell<Student>() {

            private ImageView imageView = new ImageView("https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg");
            private BorderPane bp;

            @Override
            protected void updateItem(Student item, boolean empty) {
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);
                bp = new BorderPane(imageView);
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getName());
                    setGraphic(bp);
                }
            }
        });
        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(listView);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
