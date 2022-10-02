package org.example.bot;

import org.example.bot.util.BotState;
import org.example.bot.util.Commands;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.io.File;

import static org.example.bot.Constants.IMAGES_PATH;
import static org.example.bot.util.Commands.*;

public class Router {
    DefaultLookBotService service;

    public Router(DefaultLookBotService service) {
        this.service = service;
    }

    void handle(BotState state, Update update, OnStateChange onStateChange) {
        var text = update.getMessage().getText();
        switch (state) {
            case INITIAL -> {
                if (text.equals("/start")) {
                    onStateChange.onChange(service.welcome(update), BotState.WELCOME);
                }
            }
            case WELCOME -> {
                switch (text) {
                    case ORDER -> {
                        onStateChange.onChange(service.showMenu(update), BotState.MAIN_MENU);
                    }
                    case CONTACT -> {
                        onStateChange.onChange(service.contactWithUs(update), BotState.CONTACT_US);
                    }
                }
            }
            case MAIN_MENU -> {
                switch (text) {
                    case BACK -> {
                        onStateChange.onChange(service.welcome(update), BotState.WELCOME);
                    }
                    case COMBO -> {
                        onStateChange.onChange(service.showCombo(update), BotState.COMBO_MENU);
                    }
                    case PIZZA -> {
                        onStateChange.onChange(service.showPizza(update), BotState.PIZZA_MENU);
                    }
                    case SALAD -> {
                        onStateChange.onChange(service.showSalads(update), BotState.SALAD_MENU);
                    }
                    case DISCOUNT -> {
                        onStateChange.onChange(service.showDiscounts(update), BotState.DISCOUNT_MENU);
                    }
                    case FULL_MENU -> {
                        onStateChange.onChange(service.fullMenu(update), BotState.MAIN_MENU);
                    }
                }
            }
            case CONTACT_US -> {
                if (BACK.equals(text)) {
                    onStateChange.onChange(service.welcome(update), BotState.WELCOME);
                } else {
                    onStateChange.onChange(service.receiveFeedback(update), BotState.CONTACT_US);
                    onStateChange.onChange(service.welcome(update), BotState.WELCOME);
                }
            }
            case COMBO_MENU -> {
                if (BACK.equals(text)) {
                    onStateChange.onChange(service.showMenu(update), BotState.MAIN_MENU);
                    }
            }
            case PIZZA_MENU -> {
                if (BACK.equals(text)) {
                    onStateChange.onChange(service.showMenu(update), BotState.MAIN_MENU);
                }
                if (text.equals("PIZZA SUPREME")) {
                    InputFile photo = new InputFile();
                    photo.setMedia(new File(IMAGES_PATH + "pizza_supreme.jpg"));
                    onStateChange.onChange(service.sendPhoto(update, photo, "*PIZZA SUPREME*"), BotState.PIZZA_MENU);
                    onStateChange.onChange(service.selectAmountOfProduct(update), BotState.SELECT_AMOUNT);
                }
            }
            case SALAD_MENU -> {
                if (BACK.equals(text)) {
                    onStateChange.onChange(service.showMenu(update), BotState.MAIN_MENU);
                }
            }
            case DISCOUNT_MENU -> {
                if (BACK.equals(text)) {
                    onStateChange.onChange(service.showMenu(update), BotState.MAIN_MENU);
                }
            }
            case SELECT_AMOUNT -> {
                if (BACK.equals(text)) {
                    onStateChange.onChange(service.showPizza(update), BotState.PIZZA_MENU);
                }
            }
        }
    }

    public interface OnStateChange {
        <T> void onChange(T message, BotState state);
    }
}
