package homeTask8;

import java.io.*;
import java.net.Socket;

/**
 * Пишет сообщения введенные с консоли
 */
public class ClientWriterThread extends Thread {
    private Socket socket;

    ClientWriterThread(Socket socket) {
        this.socket = socket;

        start();
    }

    /**
     * Пишет сообщения введенные с консоли в socket.getOutputStream.
     * По комманде quit завершает работу.
     */
    public void run() {
        String message;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (!((message = reader.readLine()).equals("quit"))) {
                out.write(message + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Соединение прервано ");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
