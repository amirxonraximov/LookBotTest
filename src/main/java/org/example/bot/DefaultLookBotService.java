package org.example.bot;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static org.example.bot.util.Commands.*;

public class DefaultLookBotService implements LookBotService {
    @Override
    public SendMessage welcome(Update update) {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Hello, dear customer!");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(ORDER);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(CONTACT);
        row.add("⚙ Sozlamalar");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        return message;
    }

    @Override
    public SendMessage contactWithUs(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Taklif va shikoyatlaringizni bu yerda batafsil yozib qoldiring \uD83D\uDCDD");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(BACK);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage showMenu(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Nimadan boshlaymiz *%s* ?".formatted(update.getMessage().getChat().getFirstName()));

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(FULL_MENU);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("🍗 Tovuq");
        row.add("🍟 Gazaklar");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("🥤🍟 Kombo");
        row.add("🍕 Pitsa");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("🥗 Saladlar");
        row.add("🍔 Burgerlar");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("🌯 Lavash");
        row.add("🥤 Ichimliklar");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("🧸 Blolalar uchun");
        row.add("🍰 Shirinliklar");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("🍅 Sous");
        row.add("🍦🥛 Muzqaymoq va Kokteyl");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(DISCOUNT);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(BACK);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage fullMenu(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.HTML);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("<a href=\"https://telegra.ph/Test-Menu-for-Test-LOOOK-Bot-10-02\">Menu</a>");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton linkButton = new InlineKeyboardButton();
        linkButton.setText("Show full menu");
        linkButton.setUrl("https://telegra.ph/Test-Menu-for-Test-LOOOK-Bot-10-02");

        row.add(linkButton);
        keyboard.add(row);
        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);

        return message;
    }

    @Override
    public SendMessage showPizza(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Taomni tanlang");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("PIZZA SUPREME");
        row.add("PIZZA STEAK");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("PIZZA PEPPERONI");
        row.add("PIZZA BBQ CHICKEN");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("PIZZA SPICY");
        row.add("PIZZA VEGETARIAN");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("PIZZA WHITE CHEESE");
        row.add("PIZZA HAWAIIAN");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("PIZZA MARGARITA");
        row.add("PIZZA FRANKFURT");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(BACK);
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage showCombo(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Taomni tanlang");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("COMBO");
        row.add("WICKED COMBO (strips)");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("WICKED COMBO (wings)");
        row.add("FULLY COMBO (normal)");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("FULLY COMBO (spicy)");
        row.add(BACK);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage selectAmountOfProduct(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Taom miqdorini tanlang yoki yozib kiriting:");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("1");
        row.add("2");
        row.add("3");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("4");
        row.add("5");
        row.add("6");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("7");
        row.add("8");
        row.add("9");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("\uD83D\uDED2 Savat");
        row.add(BACK);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage showSalads(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Taomni tanlang");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("COLESLAW SALAD");
        row.add("LOOOK SALAD");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("VEGGIE FRESH SALAD");
        row.add("BREAD PIKELET");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(BACK);
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage showDiscounts(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Taomni tanlang");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("JUNIOR BURGER SET");
        row.add("MINI SPINNER SET");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("MINI BURGER SET");
        row.add(BACK);
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    @Override
    public SendMessage receiveFeedback(Update update) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Sizning xabaringiz qabul qilindi \uD83D\uDCE8 Agar kerak bo'lsa, bizning vakillarimiz qisqa muddatda siz bilan bog'lanishadi");
        return message;
    }

    @Override
    public SendPhoto sendPhoto(Update update, InputFile photo, String caption) {
        SendPhoto photoMessage = new SendPhoto();
        photoMessage.setParseMode(ParseMode.MARKDOWN);
        photoMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        photoMessage.setPhoto(photo);
        if (caption != null) {
            photoMessage.setCaption(caption);
        }
        return photoMessage;
    }
}
