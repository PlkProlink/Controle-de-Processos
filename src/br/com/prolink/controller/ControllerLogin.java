/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.controller;

import br.com.prolink.model.JavaVersion;
import br.com.prolink.model.StageList;
import br.com.prolink.model.Usuario;
import br.com.prolink.model.UsuarioDao;
import br.com.prolink.model.UsuarioLogado;
import br.com.prolink.model.VersaoSistema;
import br.com.prolink.view.Login;
import br.com.prolink.view.Menu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Tiago
 */
public class ControllerLogin implements Initializable {

    @FXML
    private Label lbVersao;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXPasswordField txSenha;
    @FXML
    private JFXButton btEntrar;
    @FXML
    private JFXButton btSair;
    @FXML
    private ImageView imageView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbVersao.setText("Versão: " + new VersaoSistema().getVersao());
        String[] userSugestion = System.getProperty("user.name").replace(".", " ").split(" ");
        txNome.setText(userSugestion[0].equals("Robison")?userSugestion[0]:System.getProperty("user.name").replace(".", " "));
        ObservableList<FadeTransition> arrayTransitions = FXCollections.observableArrayList();
        arrayTransitions.add(addFadeTransition(lbVersao));
        arrayTransitions.add(addFadeTransition(txNome));
        arrayTransitions.add(addFadeTransition(txSenha));
        arrayTransitions.add(addFadeTransition(btEntrar));
        arrayTransitions.add(addFadeTransition(btSair));
        arrayTransitions.add(addFadeTransition(imageView));
        initTransition(arrayTransitions);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txSenha.requestFocus();
            }
        });
        verificarJava();
    }
    
    @FXML
    private void entrar(ActionEvent event) {
        logon();
    }

    @FXML
    void enterAcionado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            logon();
        }
    }

    private void logon() {
        String mensagem;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Erro de Acesso");
        if (txNome.getText().trim().length() == 0
                || txSenha.getText().trim().length() == 0) {
            mensagem = "Usuario ou senha em branco!";
            alert.setContentText(mensagem);
            alert.showAndWait();
        } else {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = dao.autentica(txNome.getText(), txSenha.getText());
            if (usuario != null) {
                UsuarioLogado.getInstance().setUsuario(usuario);
                Menu menu = new Menu();
                menu.start(new Stage());
                StageList stages = StageList.getInstance();
                Stage stage = stages.findScene(Login.class);
                if(stage!=null){
                    stage.close();
                    stages.removeScene(Login.class);
                }
            } else {
                mensagem = "Usuario ou senha inválidos!";
                alert.setContentText(mensagem);
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }
    private FadeTransition addFadeTransition(Node node){
        FadeTransition iTransition = new FadeTransition(Duration.millis(3000), node);
        iTransition.setFromValue(0);
        iTransition.setToValue(1);
        return iTransition;
    }
    private void initTransition(ObservableList<FadeTransition> transition){
        ParallelTransition pTransition = new ParallelTransition();
        pTransition.getChildren().addAll(transition);
        pTransition.play();
    }
    private void verificarJava(){
        JavaVersion jvm = new JavaVersion();
        if(jvm.iniciar()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmação");
            alert.setHeaderText("É preciso atualizar o Java");
            alert.setContentText(
                    "Sua versão do Java esta desatualizada!"
                    + "\nO programa pode não funcionar corretamente com versões inferiores ao Java 8.81"
                    + "\nRecomendamos que atualize para a versao minima 8u100 e ainda poderá manter as duas versões,"
                    + "\nPara evitar falhas no programa, clique em Atualizar");
            ButtonType btnAtualizar = new ButtonType("Atualizar");
            ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(btnAtualizar, btnCancelar);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == btnAtualizar) {
                jvm.chamaAtualizador();
            }
        }
    }
}
