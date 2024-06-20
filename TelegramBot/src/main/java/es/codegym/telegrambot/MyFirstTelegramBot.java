package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymMarathonBotDiglasbot";
    public static final String TOKEN = "7425573963:AAF5c8X_kZw-Ruy-MXLDl0iMNZRwWP1ay1E";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí


        if(getMessageText().equals("/start")){
            setUserGlory(0);
            
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, Map.of(
                    "¡Tomar una salchicha! + 20 de fama", "step_2_btn",
                    "¡Tomar un pescado! +20 de fama", "step_2_btn",
                    "¡Tirar una lata de pepinillos!", "step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of(
                    "Hackear al robot aspirados", "step_3_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "Enviar al robot aspirador a por comida + 30 de fama", "step_4_btn",
                    "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
                    "¡Huir del robot aspirador! +30 de fama", "step_4_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of(
                    "Agarrar la GoPro", "step_5_btn",
                    "Ignorar la GoPro", "step_4_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "Pasear en la sala de la casa", "step_6_btn",
                    "Pasear por el parque", "step_6_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(60);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of(
                    "Pasar la informacion mediante usb", "step_7_btn",
                    "Tantear la contraseña", "step_7_btn",
                    "Transferir mediante una cuenta en la nube", "step_7_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(70);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of(
                    "Actualizar los drivers equipo", "step_8_btn",
                    "Formatear el equipo", "step_8_btn",
                    "Guardar informacion desde cualquier maquina virtual", "step_8_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            addUserGlory(80);
            sendTextMessageAsync(FINAL_TEXT, Map.of(
                    "Hackerman se dedica a descansar", "step_9_btn"

            ));
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}