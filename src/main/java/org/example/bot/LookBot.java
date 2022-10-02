package org.example.bot;

import org.example.bot.util.BotState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;

public class LookBot extends TelegramLongPollingBot {

    Router router;

    HashMap<Long, BotState> userStates = new HashMap<>();

    public LookBot(Router router) {
        this.router = router;
    }

    @Override
    public String getBotToken() {
        return "5243486961:AAHPwRdgy_w2sGaKaH0CnnuWJ49lNg4tUzU";
    }

    @Override
    public String getBotUsername() {
        return "arm19980201_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Long chatId = update.getMessage().getChatId();
            userStates.putIfAbsent(chatId, BotState.INITIAL);
            router.handle(userStates.get(chatId), update, new Router.OnStateChange() {
                @Override
                public <T> void onChange(T message, BotState state) {
                    if (message != null) {
                        try {
                            if (message instanceof SendMessage) {
                                execute((SendMessage) message);
                            }
                            if (message instanceof SendPhoto) {
                                execute((SendPhoto) message);
                            }
                            userStates.put(chatId, state);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            System.out.println(userStates.toString());
        }
    }
}
