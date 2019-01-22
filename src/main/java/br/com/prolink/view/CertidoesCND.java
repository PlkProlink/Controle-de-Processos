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

/**
 *
 * @author Tiago
 */
public class CertidoesCND extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Icons estilo = Icons.getInstance();
            URL url = getClass().getResource("CertidoesCND.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menu de CND");
            stage.getIcons().add(new Image(estilo.getIcon().toString()));
            stage.show();
            StageList.getInstance().addScene(CertidoesCND.class, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
