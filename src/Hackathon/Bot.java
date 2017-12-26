package Hackathon;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by user on 02.12.2017.
 */
public class Bot extends TelegramLongPollingBot {
    String day = "";
    String str;
    Info info = new Info();

        @Override
    public void onUpdateReceived(Update update) {


            if (update.hasMessage() && update.getMessage().hasText()) {
                String message_text = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

                if (message_text.equals("/start")) {
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Добрый день! " +
                                    "Вас приветствует официальный телеграм-бот Государственного музея изобразительных искусств имени А.С. Пушкина. " +
                                    "Это музейный комплекс, обладающий одним из крупнейших в России художественных собраний зарубежного искусства. " +
                                    "Сегодня в его коллекции находится около 700 тысяч произведений разных эпох, начиная с Древнего Египта и античной Греции и заканчивая началом XXI века. ");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Бот поможет вам узнать, какие события проводятся в музее в интересующую вас дату." +
                            " Для этого введите дату в формате «дд.мм.гггг» (например, 02.12.2017).");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Если вы хотите узнать режим работы музея, перейти в раздел покупки билета и узнать новости, воспользуйтесь командой /links");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("У нас также есть свой стикерпак – он доступен для установки.\n"
                            + "https://telegram.me/addstickers/artsmuseum");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Хорошего дня, ждем вас в музее!");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if (message_text.equals("/links")) {

                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Полезные ссылки: ");
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    rowInline.add(new InlineKeyboardButton().setText("Режим работы").setCallbackData("time"));
                    rowInline.add(new InlineKeyboardButton().setText("Купить билет").setCallbackData("ticket"));
                    rowInline.add(new InlineKeyboardButton().setText("Новости").setCallbackData("news"));
                    rowsInline.add(rowInline);
                    inlineKeyboardMarkup.setKeyboard(rowsInline);
                    message.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(message_text.equals("/help")){
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Чтобы узнать, какие события проводятся в музее в интересующую вас дату, введите дату в формате «дд.мм.гггг» (например, 02.12.2017).");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Если вы хотите узнать режим работы музея, перейти в раздел покупки билета и узнать новости, воспользуйтесь командой /links");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Стикерпак:\n"
                            + "https://telegram.me/addstickers/artsmuseum");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Музей на карте:\n"
                            + "http://qoo.by/36TT");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.setText("Интересные факты:\n"
                            + "/interesting");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(message_text.equals("Cобытия на неделю")){
                    String str = info.infToday();
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText(str);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(message_text.equals("/interesting")){
                    Interes interes = new Interes();
                    String inter = interes.rand();
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText(inter);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    SendPhoto sendPhoto = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto("281580.png");
                    try {
                        sendPhoto(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(message_text.equals("json")){
                    String name = info.js();
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText(name);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    day = message_text.toString();
                    try{
                        Date date = format.parse(day);
                        SendMessage message = new SendMessage()
                                .setChatId(chat_id)
                                .setText("Что вас интересует?");
                        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline = new ArrayList<>();
                        rowInline.add(new InlineKeyboardButton().setText("Выставки").setCallbackData("exibition"));
                        rowInline.add(new InlineKeyboardButton().setText("Лекции").setCallbackData("lectures"));
                        rowInline.add(new InlineKeyboardButton().setText("Концерты").setCallbackData("concerts"));
                        rowsInline.add(rowInline);
                        rowInline.add(new InlineKeyboardButton().setText("Все события").setCallbackData("all"));
                        inlineKeyboardMarkup.setKeyboard(rowsInline);
                        message.setReplyMarkup(inlineKeyboardMarkup);
                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                        SendMessage message = new SendMessage()
                                .setChatId(chat_id)
                                .setText("Проверьте корректность введенной информации или нажмите /help.");
                        try {
                            execute(message);
                        } catch (TelegramApiException ee) {
                            ee.printStackTrace();
                        }
                    }
                }
            }
            else if (update.hasCallbackQuery()){
                String call_data = update.getCallbackQuery().getData();
                int message_id = update.getCallbackQuery().getMessage().getMessageId();
                long chat_id = update.getCallbackQuery().getMessage().getChatId();

                if(call_data.equals("time")) {
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText("Режим работы музея:\n" +
                                    "http://www.arts-museum.ru/visitors/index.php");
                    try{
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Полезные ссылки: ");
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    rowInline.add(new InlineKeyboardButton().setText("Режим работы").setCallbackData("time"));
                    rowInline.add(new InlineKeyboardButton().setText("Купить билет").setCallbackData("ticket"));
                    rowInline.add(new InlineKeyboardButton().setText("Новости").setCallbackData("news"));
                    rowsInline.add(rowInline);
                    inlineKeyboardMarkup.setKeyboard(rowsInline);
                    message.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(call_data.equals("ticket")) {
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText("Купить билеты:\n" +
                                    "https://tickets.arts-museum.ru/ru/");
                    try{
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Полезные ссылки: ");
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    rowInline.add(new InlineKeyboardButton().setText("Режим работы").setCallbackData("time"));
                    rowInline.add(new InlineKeyboardButton().setText("Купить билет").setCallbackData("ticket"));
                    rowInline.add(new InlineKeyboardButton().setText("Новости").setCallbackData("news"));
                    rowsInline.add(rowInline);
                    inlineKeyboardMarkup.setKeyboard(rowsInline);
                    message.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(call_data.equals("news")) {
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText("Новости:\n" +
                                    "http://www.arts-museum.ru/museum/news/index.php");
                    try{
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Полезные ссылки: ");
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    rowInline.add(new InlineKeyboardButton().setText("Режим работы").setCallbackData("time"));
                    rowInline.add(new InlineKeyboardButton().setText("Купить билет").setCallbackData("ticket"));
                    rowInline.add(new InlineKeyboardButton().setText("Новости").setCallbackData("news"));
                    rowsInline.add(rowInline);
                    inlineKeyboardMarkup.setKeyboard(rowsInline);
                    message.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(call_data.equals("exibition")) {
                    try {
                        str = info.checkData(day);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText(day + " в Музее проходят:\n\n" + str);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(call_data.equals("lectures")) {
                    str = info.checData3(day);
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText(day + " в Музее проходят:\n\n" + str);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(call_data.equals("concerts")) {
                    str = info.checData2(day);
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText(day + " в Музее проходят:\n\n" + str);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else if(call_data.equals("all")) {
                    str = info.checData2(day);
                    String str2 = null;
                    try {
                        str2 = info.checkData(day);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(message_id)
                            .setText(day + " в Музее проходят:\n\n" + str2 + "\n\n" + str);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    @Override
    public String getBotUsername() {
        return "The_Pushkin_Museum_bot";
    }

    @Override
    public String getBotToken() {
        return "338269581:AAEnp5JeaMBLcXOMSJizlnVleQdZ6pesfYQ";
    }
}
