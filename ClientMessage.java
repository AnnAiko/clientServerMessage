package clientmessage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientMessage {

    public static void main(String[] args) {
        Socket socket = null;
        PrintStream ps = null;
        try {
            //���������� � �������� �� ip � �����
            socket = new Socket("localhost", 8030);
            ps = new PrintStream(socket.getOutputStream());
            //���������� ��������� �������
            ps.println("������ ������, ������!!!");
            socket.close();
            System.out.println("��������� ������� ����������");
        } catch (IOException e) {
            System.err.println("������: " + e);

        } finally {
            if (socket != null) {
                try {
                    socket.close(); // ������ ����������
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
