package homeTask8;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Читает сообщения от сервера
 */
public class ClientReaderThread extends Thread {
    private Socket socket;

    ClientReaderThread (Socket socket) {
        this.socket = socket;

        start();
    }

    /**
     * Ждет сообщения от сервера и вслучае получения выводи в консоль.
     */
    @Override
    public void run() {
        String message;
        try (Scanner scanner = new Scanner(socket.getInputStream())) {
            while (!isInterrupted()) {
                if (!scanner.hasNextLine()) {
                    break;
                }
                message = scanner.nextLine();
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
