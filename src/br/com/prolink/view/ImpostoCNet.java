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

/**
 *
 * @author Prolink
 */
public class ImpostoCNet extends Application{
    @Override
    public void start(Stage stage) {
        try {
            Icons estilo = Icons.getInstance();
            URL url = getClass().getResource("ImpostoCNet.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Impostos ContabilNet");
            stage.getIcons().add(new Image(estilo.getIcon().toString()));
            stage.show();
            StageList.getInstance().addScene(ImpostoCNet.class, stage);
        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(0);
        }
    }
}
