package homeTask8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Обрабатывает подключения клиентов, отправляет серверные сообщения
 */
public class Server {
    private static final int PORT = 3232;
    static ArrayList<ServerListener> serverListener = new ArrayList<>();

    /**
     * Создается сокет сервера, слушается порт на наличие новых подключений
     * В случае соединения, создается новый экземпляр класса ServerListener
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)){
            Socket socket;
            System.out.println("Сервер запущен");
            while (true) {
                socket = server.accept();
                System.out.println("Подключился клиент " + socket);
                serverListener.add(new ServerListener(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                System.out.println("Сервер закрыт");
        }
    }
}