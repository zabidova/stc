package homeTask8;

import java.io.IOException;
import java.net.Socket;

/**
 * Устанавливает соединение с сервером,
 * передает socket потоку на выполнение чтения данных с сервера
 * и потоку отправки данных на сервер
 */

public class Client {
    private static final String IPADDR = "127.0.0.1";
    private static final int PORT = 3232;

    /**
     * Запускает потоки чтения и отправки данных на сервер
     *
     * @param args арнументы командной строки
     */
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket(IPADDR, PORT);
            ClientReaderThread reader = new ClientReaderThread(clientSocket);
            ClientWriterThread writer = new ClientWriterThread(clientSocket);
            try {
                reader.join();
                writer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
