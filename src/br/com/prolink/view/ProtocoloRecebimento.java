/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import jfoenix.CustomJFXDecorator;

/**
 *
 * @author Tiago
 */
public class ProtocoloRecebimento extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Icons estilo = Icons.getInstance();
            URL url = getClass().getResource("ProtocoloRecebimento.fxml");
            Parent root = FXMLLoader.load(url);
            CustomJFXDecorator decorator = new CustomJFXDecorator(stage, root, false, true, true);
            Scene scene = new Scene(decorator);
            stage.setScene(scene);
            stage.setTitle("Protocolo de Recebimento");
            stage.getIcons().add(new Image(estilo.getIcon().toString()));
            StageList.getInstance().addScene(ProtocoloRecebimento.class, stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
