package org.example.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface LookBotService {

    SendMessage welcome(Update update);

    SendMessage contactWithUs(Update update);

    SendMessage showMenu(Update update);

    SendMessage fullMenu(Update update);

    SendMessage showPizza(Update update);

    SendMessage showCombo(Update update);

    SendMessage selectAmountOfProduct(Update update);

    SendMessage showSalads(Update update);

    SendMessage showDiscounts(Update update);

    SendMessage receiveFeedback(Update update);

    SendPhoto sendPhoto(Update update, InputFile photo, String caption);



}
