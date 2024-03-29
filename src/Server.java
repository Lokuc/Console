

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Server extends Thread{
		// порт, который будет прослушивать наш сервер
    static final int PORT = 8080;
		// список клиентов, которые будут подключаться к серверу
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    public static Main main;

    public Server() {
		start();
    }
		
		// отправляем сообщение всем клиентам
    public void sendMessageToAllClients(String msg) {
        System.out.println(msg);
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }

    }

		// удаляем клиента из коллекции при выходе из чата
    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public void run(){
        main.checkPosition();
        String a = "";
        try{
            final DatagramSocket socket = new DatagramSocket();
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            a = socket.getLocalAddress().getHostAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        main.done.setText("Сервер запущен.   Адрес: "+a+"  Порт: "+PORT);
        main.clientN.setText("Клиентов: 0");
        main.menu.setVisible(false);
        main.okno.add(main.menuGame);
        main.menuGame.setVisible(true);
        main.okno.repaint();
        // сокет клиента, это некий поток, который будет подключаться к серверу
        // по адресу и порту
        Socket clientSocket = null;
        // серверный сокет
        ServerSocket serverSocket = null;
        try {
            // создаём серверный сокет на определенном порту
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
            // запускаем бесконечный цикл
            main.start.setVisible(false);
            while (true) {
                // таким образом ждём подключений от сервера
                clientSocket = serverSocket.accept();
                // создаём обработчик клиента, который подключился к серверу
                // this - это наш сервер
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                // каждое подключение клиента обрабатываем в новом потоке
                new Thread(client).start();
                try {
                    sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                // закрываем подключение
                clientSocket.close();
                System.out.println("Сервер остановлен");
                serverSocket.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
