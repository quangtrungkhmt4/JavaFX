package chatsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2 extends Application {

    private String serverAddress;
    private Scanner in;
    private PrintWriter out;
    private TextField input;
    private TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Chat system");

        VBox layout = new VBox();
        textArea = new TextArea();
        textArea.setPadding(new Insets(10));
        textArea.setText("dfdfd");
        textArea.appendText("sssss");

        HBox bottom = new HBox();
        input = new TextField();
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


        try {
            Socket socket = new Socket("localhost", 1997);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMITNAME")) {
                    out.println("Quang");
                } else if (line.startsWith("NAMEACCEPTED")) {
                    input.setEditable(true);
                } else if (line.startsWith("MESSAGE")) {
                    textArea.appendText(line.substring(8) + "\n");
                }
            }
        } finally {

        }

    }
}
