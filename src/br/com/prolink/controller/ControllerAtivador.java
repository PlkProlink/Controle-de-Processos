/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.controller;

import br.com.prolink.factory.ConfigTables;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoDao;
import br.com.prolink.model.ProcessoLogado;
import br.com.prolink.model.StageList;
import br.com.prolink.view.Ativador;
import com.jfoenix.controls.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tiago
 */
public class ControllerAtivador implements Initializable, ConfigTables {

    ProcessoDao dao = new ProcessoDao();
    @FXML
    private JFXCheckBox ckConcluida;
    @FXML
    private JFXCheckBox ckEmAberto;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox cbFiltro;
    @FXML
    private TableView<Processo> tbProcesso;
    @FXML
    private JFXButton btAtivar;
    @FXML
    private JFXTextField txCodigo;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txApelido;
    @FXML
    private Color x2;
    @FXML
    private Font x1;

    @FXML
    void ativar(ActionEvent event) {
        if (!txCodigo.getText().equals("") && tbProcesso.getSelectionModel().getSelectedIndex() != -1) {
            Processo p = tbProcesso.getSelectionModel().getSelectedItem();
            txCodigo.setText(p.getId() + "");
            txApelido.setText(p.getApelido());
            txNome.setText(p.getCliente());
            ProcessoLogado logado = ProcessoLogado.getInstance();
            logado.setProcesso(p);
            logado.setAtributos(new String[]{p.getId() + "", p.getApelido(), p.getCliente(), p.getClassificacao(),
                String.valueOf(p.getSituacao())});
            StageList sta = StageList.getInstance();
            Stage stage = sta.findScene(Ativador.class);
            if(stage!=null){
                stage.close();
                sta.removeScene(Ativador.class);
            }
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Escolha um valor na tabela e tente novamente.");
            alert.setHeaderText(null);
            alert.setTitle("Alerta...");
            alert.showAndWait();
        }
    }

    static enum Modelo {
        Codigo, Apelido, Nome
    }

    @FXML
    void invocarPesquisa(ActionEvent event) {
        String sql = "SELECT * FROM " + CADASTRODEPROCESSO;
        if (ckConcluida.isSelected() && !ckEmAberto.isSelected()) {
            sql += " where " + CADASTRODEPROCESSO_Situacao + "=0";
        } else if (!ckConcluida.isSelected() && ckEmAberto.isSelected()) {
            sql += " where " + CADASTRODEPROCESSO_Situacao + "=1";
        }
        List<Processo> processos = (List<Processo>) dao.filtrar(sql);
        ObservableList listProcessos = FXCollections.observableArrayList(processos);
        tbProcesso.setItems(listProcessos);
    }

    @FXML
    void invocarPesquisaTexto(KeyEvent event) {
        if (!"".equals(txPesquisa.getText())) {
            String sql = "";
            if (cbFiltro.getValue().equals(Modelo.Codigo)) {
                sql += "SELECT * FROM " + CADASTRODEPROCESSO + " where "
                        + CADASTRODEPROCESSO_codNumerodoprocesso + " like '" + txPesquisa.getText() + "%'";
            } else if (cbFiltro.getValue().equals(Modelo.Apelido)) {
                sql += "SELECT * FROM " + CADASTRODEPROCESSO + " where "
                        + CADASTRODEPROCESSO_Apelido + " like '" + txPesquisa.getText() + "%'";
            } else {
                sql += "SELECT * FROM " + CADASTRODEPROCESSO + " where " + CADASTRODEPROCESSO_Cliente + " like '" + txPesquisa.getText() + "%'";
            }
            if (ckConcluida.isSelected() && !ckEmAberto.isSelected()) {
                sql += " and " + CADASTRODEPROCESSO_Situacao + "=0";
            } else if (!ckConcluida.isSelected() && ckEmAberto.isSelected()) {
                sql += " and " + CADASTRODEPROCESSO_Situacao + "=1";
            }
            List<Processo> processos = (List<Processo>) dao.filtrar(sql);
            ObservableList listProcessos = FXCollections.observableArrayList(processos);
            tbProcesso.setItems(listProcessos);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList list1 = FXCollections.observableArrayList();
        list1.add(Modelo.Codigo);
        list1.add(Modelo.Apelido);
        list1.add(Modelo.Nome);
        cbFiltro.setItems(list1);
        cbFiltro.getSelectionModel().selectFirst();
        List<Processo> processos = (List<Processo>) dao.listar();
        ObservableList listProcessos = FXCollections.observableArrayList(processos);
        tbProcesso.setItems(listProcessos);
        ckEmAberto.setSelected(true);
        tratarTabela();

    }

    @FXML
    void cliqueTabela(MouseEvent event) {
        if (tbProcesso.getSelectionModel().getSelectedIndex() != -1) {
            Processo p = tbProcesso.getSelectionModel().getSelectedItem();
            txCodigo.setText(p.getId() + "");
            txApelido.setText(p.getApelido());
            txNome.setText(p.getCliente());
        }
    }

    public void tratarTabela() {
        TableColumn<Processo, Number> colunaId = new TableColumn<>("Cog");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbProcesso.getColumns().add(colunaId);
        TableColumn<Processo, String> colunaData = new TableColumn<>("Apelido");
        colunaData.setCellValueFactory(new PropertyValueFactory<>("apelido"));
        tbProcesso.getColumns().add(colunaData);
        TableColumn<Processo, String> colunaApelido = new TableColumn<>("Nome");
        colunaApelido.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaApelido.setPrefWidth(370);
        tbProcesso.getColumns().add(colunaApelido);
        TableColumn<Processo, Number> colunaEmpresa = new TableColumn<>("Situação");
        colunaEmpresa.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        colunaEmpresa.setCellFactory((TableColumn<Processo, Number> column) -> new TableCell<Processo, Number>() {
            @Override
            protected void updateItem(Number item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                if (item == null) {
                    setText(null);
                    setStyle("");
                } else if (item.intValue() == 1) {
                    setText("Em Aberto");
                    setStyle("-fx-background-color:red;-fx-text-fill: white;");
                } else if (item.intValue() == 0) {
                    setText("Concluido");
                    setStyle("-fx-background-color:green;-fx-text-fill: white;");
                }
            }
            
        });
        tbProcesso.getColumns().add(colunaEmpresa);
    }

}
