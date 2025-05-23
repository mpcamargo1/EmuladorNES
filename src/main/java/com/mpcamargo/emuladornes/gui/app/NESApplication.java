package com.mpcamargo.emuladornes.gui.app;

import com.mpcamargo.emuladornes.constants.NESConstants;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NESApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                NESApplication.class.getResource("/com/mpcamargo/emuladornes/nes-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),
                NESConstants.SCREEN_WIDTH + 30,
                NESConstants.SCREEN_HEIGHT + 35);

        stage.setTitle("Emulador NES");
        stage.setScene(scene);
        stage.show();

        iniciarRenderizacao(fxmlLoader.getController());
    }

    private void iniciarRenderizacao(NESController controller) {

        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
               controller.render();
            }
        };

        animationTimer.start();
    }

    public static void main(String[] args) {
        launch();
    }
}