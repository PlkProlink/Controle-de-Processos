package br.com.prolink.view;

import br.com.prolink.model.StageList;
import br.com.prolink.view.interfaces.Icons;
import java.net.URL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jfoenix.CustomJFXDecorator;

/**
 *
 * @author Tiago
 */
public class Menu extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Icons estilo = Icons.getInstance();
            URL url = getClass().getResource("Menu.fxml");
            Parent root = FXMLLoader.load(url);
            CustomJFXDecorator decorator = new CustomJFXDecorator(stage, root, false, true, true);
            Scene scene = new Scene(decorator);
            stage.setScene(scene);
            stage.setTitle("Controle de Processos");
            stage.getIcons().add(new Image(estilo.getIcon().toString()));
            stage.show();
            StageList.getInstance().addScene(Menu.class, stage);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       System.exit(0);

                    }
                });
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(0);
        }
    }
}
