package org.example;

import org.example.bot.DefaultLookBotService;
import org.example.bot.LookBot;
import org.example.bot.Router;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {

        DefaultLookBotService service = new DefaultLookBotService();
        Router router = new Router(service);

        TelegramBotsApi botsApi;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        try {
            botsApi.registerBot(new LookBot(router));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}