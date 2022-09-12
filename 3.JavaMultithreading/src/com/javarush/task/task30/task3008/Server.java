package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler (Socket socket) {
            this.socket = socket;
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                }
                else {
                ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String user : connectionMap.keySet()){
                if (user.equals(userName)) continue;
                connection.send(new Message(MessageType.USER_ADDED, user));
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message answer = connection.receive();
            while (true) {
                if (answer.getType() != MessageType.USER_NAME) {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    answer = connection.receive();
                    continue;
                }
                if (answer.getData().equals("")) {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    answer = connection.receive();
                    continue;
                }
                if (answer.getData() == null) {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    answer = connection.receive();
                    continue;
                }
                if (connectionMap.containsKey(answer.getData())) {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    answer = connection.receive();
                    continue;
                }
                connectionMap.put(answer.getData(), connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED, "User name accepted"));
                break;
            }
            return answer.getData();
        }

        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удалённым адресом "
                    + socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection,userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                connection.close();
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удалённым адресом "
                        + socket.getRemoteSocketAddress());
            }
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт");
        int serverPort = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Socket client = serverSocket.accept();
                Handler handler = new Handler(client);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}
