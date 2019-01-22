package br.com.prolink.view;

import br.com.prolink.model.StageList;
import br.com.prolink.view.interfaces.Icons;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import br.com.prolink.util.CustomJFXDecorator;

/**
 *
 * @author Tiago
 */
public class Ativador extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Icons estilo = Icons.getInstance();
            URL url = getClass().getResource("Ativador.fxml");
            Parent root = FXMLLoader.load(url);
            CustomJFXDecorator decorator = new CustomJFXDecorator(stage, root, false, true, true);
            Scene scene = new Scene(decorator);
            stage.setScene(scene);
            stage.setTitle("Menu de Ativação");
            stage.getIcons().add(new Image(estilo.getIcon().toString()));
            stage.show();
            StageList.getInstance().addScene(Ativador.class, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
