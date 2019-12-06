package chatsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private static Set<String> names = new HashSet<>();
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception{
        System.out.println("Chat server is running...");
        ExecutorService pool = Executors.newFixedThreadPool(500);
        try(ServerSocket socket = new ServerSocket(1997)){
            while (true){
                pool.execute(new Handler(socket.accept()));
            }
        }
    }

    private static class Handler implements Runnable{
        private String name;
        private Socket socket;
        private Scanner in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            try {
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true){
                    out.println("SUBMITNAME");
                    name = in.nextLine();
                    if (name == null){
                        return;
                    }

                    synchronized (names){
                        if (!name.isEmpty() && !names.contains(name)){
                            names.add(name);
                            break;
                        }
                    }

                    out.println("NAMEACCEPTED " + name);
                    for (PrintWriter writer : writers){
                        writer.println("MESSAGE " + name + " has joined");
                    }
                    writers.add(out);

                    while (true){
                        String input = in.nextLine();
                        if (input.toLowerCase().startsWith("/quit")){
                            return;
                        }
                        for (PrintWriter writer : writers){
                            writer.println("MESSAGE " + name + ": " + input);
                        }
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                if (out != null){
                    writers.remove(out);
                }
                if (name != null){
                    System.out.println(name + " is leaving");
                    names.remove(name);
                    for (PrintWriter writer : writers){
                        writer.println("MESSAGE " + name + " has left");
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
