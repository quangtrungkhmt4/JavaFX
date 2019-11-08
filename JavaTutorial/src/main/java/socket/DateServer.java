package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        try(ServerSocket listener = new ServerSocket(59090)) {
            System.out.println("Date server is running...");
            while (true){
                try (Socket socket = listener.accept()){
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
