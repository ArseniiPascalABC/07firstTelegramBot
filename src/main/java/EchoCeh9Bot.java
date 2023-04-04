import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class EchoCeh9Bot extends TelegramLongPollingBot {
    int countMessage = 0;
    int var = 0;
    final String botName;
    final String botToken;

    public EchoCeh9Bot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {

        double phi;
        double n;
        double a;
        double a0;
        double a1;
        double a2;
        double b;
        double c;
        double d;
        double x;
        double y;
        String[] mass;
        String priemMessage;
        SendMessage otpravkaMessage;
        SendPhoto otpravkaPhoto;

        if (update.hasMessage() && update.getMessage().hasText()) {
            countMessage++;
            priemMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            otpravkaMessage = new SendMessage();
            otpravkaMessage.setChatId(chatId);
            try{
                switch (countMessage){
                    case 1:{
                        switch (priemMessage){
                            case "/start" -> {
                                URL url = new URL("https://sun9-73.userapi.com/impg/Pw9mFwowx56irgfL9haO0N7UR9bADvohLazw0A/_UhhpVJ5LYo.jpg?size=240x252&quality=96&sign=2f307ee4e62e8c3629afad7bf3b2bc4e&type=album");
                                InputFile photo = new InputFile(String.valueOf(url));
                                otpravkaPhoto = new SendPhoto();
                                otpravkaPhoto.setChatId(chatId);
                                otpravkaPhoto.setPhoto(photo);
                                otpravkaMessage.setText("Добро пожаловать сэр, прошу вас ввести номер варианта: (1-7)");
                                execute(otpravkaMessage);
                                execute(otpravkaPhoto);
                            }
                            case "1", "2", "3", "4", "5", "6", "7" -> {
                                otpravkaMessage.setText("Добро пожаловать сэр, вы взяли " + priemMessage + " вариант");
                                execute(otpravkaMessage);
                                countMessage++;
                            }
                        }
                    }
                    case 2:{
                        switch (priemMessage){
                            case "1" -> {
                                otpravkaMessage.setText("Введите а,b,c,n,x через пробел!");
                                execute(otpravkaMessage);
                                var = 1;
                            }
                            case "2" -> {
                                otpravkaMessage.setText("Введите а,x,y,phi через пробел!");
                                execute(otpravkaMessage);
                                var = 2;
                            }
                            case "3" -> {
                                otpravkaMessage.setText("Введите а0,a1,a2,x через пробел!");
                                execute(otpravkaMessage);
                                var = 3;
                            }
                            case "4" -> {
                                otpravkaMessage.setText("Введите а,x через пробел!");
                                execute(otpravkaMessage);
                                var = 4;
                            }
                            case "5" -> {
                                otpravkaMessage.setText("Введите а,b,c,d,x через пробел!");
                                execute(otpravkaMessage);
                                var = 5;
                            }
                            case "6" -> {
                                otpravkaMessage.setText("Введите x!");
                                execute(otpravkaMessage);
                                var = 6;
                            }
                            case "7" -> {
                                otpravkaMessage.setText("Введите x!");
                                execute(otpravkaMessage);
                                var = 7;
                            }
                        }
                        break;
                    }
                    case 3:{
                        mass = priemMessage.split(" ");
                        switch (var){
                            case 1 -> {
                                a = Double.parseDouble(mass[0]);
                                b = Double.parseDouble(mass[1]);
                                c = Double.parseDouble(mass[2]);
                                n = Double.parseDouble(mass[3]);
                                x = Double.parseDouble(mass[4]);
                                double one = ((5 * Math.pow(a, n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.cos(Math.pow(x,3)))));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + one);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                            case 2 -> {
                                a = Double.parseDouble(mass[0]);
                                x = Double.parseDouble(mass[1]);
                                y = Double.parseDouble(mass[2]);
                                phi = Double.parseDouble(mass[3]);
                                double two = ((Math.abs(x - y) / Math.pow((1 + 2 * x), a)) - Math.pow(Math.E, Math.sqrt(1 + phi)));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + two);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                            case 3 -> {
                                a0 = Double.parseDouble(mass[0]);
                                a1 = Double.parseDouble(mass[1]);
                                a2 = Double.parseDouble(mass[2]);
                                x = Double.parseDouble(mass[3]);
                                double three = (Math.sqrt(a0 + a1 * x + a2 * Math.pow((Math.abs(Math.sin(x))), 0.33)));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + three);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                            case 4 -> {
                                a = Double.parseDouble(mass[0]);
                                x = Double.parseDouble(mass[1]);
                                double four = Math.log(Math.pow(a,7)) + (1 / Math.tan(x*x)) + Math.PI / Math.sqrt(Math.abs(a + x));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + four);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                            case 5 -> {
                                a = Double.parseDouble(mass[0]);
                                b = Double.parseDouble(mass[1]);
                                c = Double.parseDouble(mass[2]);
                                d = Double.parseDouble(mass[3]);
                                x = Double.parseDouble(mass[4]);
                                double five = Math.pow(( Math.pow((a+b),2)/(c+d)) + (Math.pow(Math.E,Math.sqrt(x+1))),(0.2));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + five);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                            case 6 -> {
                                x = Double.parseDouble(mass[0]);
                                double six = Math.pow(Math.E, ((2*Math.sin(4*x + Math.cos(x*x) * Math.cos(x*x)))/(3*x)));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + six);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                            case 7 -> {
                                x = Double.parseDouble(mass[0]);
                                double seven = ((0.25) * (((1+Math.pow(x,2))/(1-x)) + ((0.5)*(Math.sin(x)/Math.cos(x)))));
                                otpravkaMessage.setText("Вариант: " + var + "\nПеременные: " + Arrays.toString(mass) + "\nОтвет: " + seven);
                                execute(otpravkaMessage);
                                countMessage = 1;
                            }
                        }
                        break;
                    }
                }
           } catch(TelegramApiException | MalformedURLException e){
               e.printStackTrace();
               throw new RuntimeException(e);
           }
        }
    }
}