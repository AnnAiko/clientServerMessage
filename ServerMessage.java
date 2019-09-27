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
            //�������� ������� � ���������� ������ �����
            ServerSocket server = new ServerSocket(8030);
            s = server.accept();//�������� ���������� PrintStream ps =
            BufferedReader br
                    = new BufferedReader(
                            new InputStreamReader(s.getInputStream()));
            //�������� ��������� �� �������
            String message = br.readLine();
            System.out.println("�������� ���������: " + message);
            message += " - � �� �����";

            System.out.println("���������� ���������: " + message);
            br.close();
        } catch (IOException e) {
            System.err.println("������: " + e);
        } finally {
            if (s != null) {
                try { // ������ ����������                    
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
