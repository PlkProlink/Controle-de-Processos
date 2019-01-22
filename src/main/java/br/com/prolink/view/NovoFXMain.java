package br.com.prolink.view;


import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class NovoFXMain extends Application {
@Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        for (int i = 1; i <= 20 ; i++) {
            String item = "Item "+i ;
            listView.getItems().add(item);
        }
        listView.setPrefSize(100, 100);
        listView.setCellFactory(CheckBoxListCell.forListView((String item) -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) -> 
                    System.out.println("Check box for "+item+" changed from "+wasSelected+" to "+isNowSelected)
            );
            return observable ;
        }));
        FlowPane root = new FlowPane(listView);
        Scene scene = new Scene(root, 250, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}