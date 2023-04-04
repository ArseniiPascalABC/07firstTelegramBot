import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        String botName = "Ceh9Bot";
        String botToken = "5830283080:AAE9awKU8SaL76vQfa-QoxWct-vqNocfVF4";
        TelegramBotsApi telegramBotsApi = null;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoCeh9Bot(botName,botToken));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}