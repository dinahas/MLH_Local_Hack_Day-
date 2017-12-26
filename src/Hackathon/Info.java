package Hackathon;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * Created by user on 02.12.2017.
 */
public class Info {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    String info;

    String checkData(String data) throws ParseException {
        Date date = format.parse(data);
        Date curDate = new Date();
        info = "Выставка «Передвижники и импрессионисты. На пути в ХХ век»\n" +
                "http://www.arts-museum.ru/events/archive/2017/peredvizhniki_impressionists/index.php.\n\n" +
                "Выставка «Годы странствий Святослава Рихтера. Франция – Италия».\n " +
                "http://www.arts-museum.ru/events/archive/2017/pilgrimage/index.php\n\n" +
                "Выставка «Хаим Сутин. Ретроспектива».\n" +
                "http://www.arts-museum.ru/events/archive/2017/soutine/index.php\n\n" +
                "Выставка «Густав Климт. Эгон Шиле. Рисунки из музея Альбертина, Вена»\n" +
                "http://www.arts-museum.ru/events/archive/2017/albertina/index.php";

        return info;
    }
    String checData2(String data){
            info = "Фестиваль «Декабрьские вечера Святослава Рихтера. Образы и отражения»\n" +
                    "http://www.arts-museum.ru/events/archive/2017/december_nights/index.php";
        return info;
    }

    String checData3(String data){
        info = "Нет событий.";
        return info;
    }

    String checkData4(String data){
        info = "Концерт лауреатов Первого международного конкурса камерного пения имени Нины Дорлиак\n" +
                "http://www.arts-museum.ru/events/archive/2017/flat/16_12/index.php\n\n" +
                "Концерт «Klavierabend Елизаветы Леонской\n" +
                "http://www.arts-museum.ru/events/archive/2017/flat/6_12/index.php\n\n»" +
                "Фестиваль «Декабрьские вечера Святослава Рихтера. Образы и отражения»\n" +
                "http://www.arts-museum.ru/events/archive/2017/december_nights/index.php";
        return info;
    }
    String infToday(){
        info = "Выставка «Передвижники и импрессионисты. На пути в ХХ век»\n" +
                "http://www.arts-museum.ru/events/archive/2017/peredvizhniki_impressionists/index.php.\n\n" +
                "Выставка «Годы странствий Святослава Рихтера. Франция – Италия».\n " +
                "http://www.arts-museum.ru/events/archive/2017/pilgrimage/index.php\n\n" +
                "Выставка «Хаим Сутин. Ретроспектива».\n" +
                "http://www.arts-museum.ru/events/archive/2017/soutine/index.php\n\n" +
                "Выставка «Густав Климт. Эгон Шиле. Рисунки из музея Альбертина, Вена»\n" +
                "http://www.arts-museum.ru/events/archive/2017/albertina/index.php\n\n" +
                "Концерт лауреатов Первого международного конкурса камерного пения имени Нины Дорлиак\n" +
                "http://www.arts-museum.ru/events/archive/2017/flat/16_12/index.php\n\n" +
                "Концерт «Klavierabend Елизаветы Леонской\n" +
                "http://www.arts-museum.ru/events/archive/2017/flat/6_12/index.php\n\n»" +
                "Фестиваль «Декабрьские вечера Святослава Рихтера. Образы и отражения»\n" +
                "http://www.arts-museum.ru/events/archive/2017/december_nights/index.php";
        return info;
    }
    String js(){
        String name = null;
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\user\\Desktop\\bot\\src\\Hackathon\\events.json"));
            JSONObject jsonObject = (JSONObject) obj;

            name = (String) jsonObject.get("name");
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
