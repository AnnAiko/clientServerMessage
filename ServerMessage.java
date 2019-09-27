package servermessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMessage {

    public static void main(String[] args) {
        Socket s = null;

        try {
            //создание объекта и назначение номера порта
            ServerSocket server = new ServerSocket(8030);
            s = server.accept();//ожидание соединения PrintStream ps =
            BufferedReader br
                    = new BufferedReader(
                            new InputStreamReader(s.getInputStream()));
            //Получить сообщение от клиента
            String message = br.readLine();
            System.out.println("Исходное сообщение: " + message);
            message += " - Я на связи";

            System.out.println("Измененное сообщение: " + message);
            br.close();
        } catch (IOException e) {
            System.err.println("Ошибка: " + e);
        } finally {
            if (s != null) {
                try { // разрыв соединения                    
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
