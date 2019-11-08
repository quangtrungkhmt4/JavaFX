package socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DateClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 1){
            System.err.println("Pass the server IP");
            return;
        }

        Socket socket = new Socket(args[0], 59090);
        Scanner scanner = new Scanner(socket.getInputStream());
        System.out.println("Server responses: " + scanner.nextLine());
    }
}
