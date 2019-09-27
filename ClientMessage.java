package clientmessage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientMessage {

    public static void main(String[] args) {
        Socket socket = null;
        PrintStream ps = null;
        try {
            //Соединение с сервером по ip и порту
            socket = new Socket("localhost", 8030);
            ps = new PrintStream(socket.getOutputStream());
            //Отправаить сообщение серверу
            ps.println("Сервер привет, ответь!!!");
            socket.close();
            System.out.println("Сообщение успешно доставлено");
        } catch (IOException e) {
            System.err.println("ошибка: " + e);

        } finally {
            if (socket != null) {
                try {
                    socket.close(); // разрыв соединения
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
