package homeTask8;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerListener extends Thread {

    private Socket socket;
    private String name = "";

    ServerListener(Socket socket) {
        this.socket = socket;
        start();
    }

    /**
     * Отправляет приветственное сообщение новому клиенту.
     * Ожидает имя Socket клиента
     * Извлекает сообщение клиента и рассылает всем доступным клиентам.
     */
    @Override
    public void run() {
        String word;
        sendMessage("Напишите пожалуйста Ваше имя");
        try (Scanner in = new Scanner(socket.getInputStream())) {

            while (in.hasNextLine()) {
                word = in.nextLine();
                if (word.equals("quit")) {
                    break;
                }
                if (name.equals("")) {
                    name = word;
                    sendMessage("Добро пожаловать в чат " + name);
                    sendAll(name + " теперь с нами");
                } else {
                    sendAll(word);
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            Server.serverListener.remove(this);
            sendAll(" отключился");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Клиент " + name + " отключился");
        }
    }

    /**
     * Отправляет сообщение всем доступным клиентам
     *
     * @param word сообщение, которое нужно отправить
     */
    private void sendAll(String word) {
        for (ServerListener listener : Server.serverListener) {
            listener.sendMessage(name + " : " + word);
        }
    }

    /**
     * Отправялет сообщение клиенту
     *
     * @param word сообщение, которое нужно отправить
     */
    private void sendMessage(String word) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(word + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
