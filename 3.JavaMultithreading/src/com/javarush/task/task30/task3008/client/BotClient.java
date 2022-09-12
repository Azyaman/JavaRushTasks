package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName() {
        return "date_bot_" + (int) (100*Math.random());
    }

    public class BotSocketThread extends SocketThread {
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndText = message.split(":");
            if (nameAndText.length != 2)
                return;
            String userName = nameAndText[0].trim();
            String text = nameAndText[1].trim();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            Calendar time = new GregorianCalendar();
            switch (text) {
                case "дата":
                    simpleDateFormat.applyPattern("d.MM.yyyy"); break;
                case "день":
                    simpleDateFormat.applyPattern("d"); break;
                case "месяц":
                    simpleDateFormat.applyPattern("MMMM"); break;
                case "год":
                    simpleDateFormat.applyPattern("yyyy"); break;
                case "время":
                    simpleDateFormat.applyPattern("H:mm:ss"); break;
                case "час":
                    simpleDateFormat.applyPattern("H"); break;
                case "минуты":
                    simpleDateFormat.applyPattern("m"); break;
                case "секунды":
                    simpleDateFormat.applyPattern("s"); break;
                default: return;
            }
            simpleDateFormat.setCalendar(time);
            BotClient.this.sendTextMessage(String.format(
                    "Информация для %s: %s", userName, simpleDateFormat.format(time.getTime())));
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
