/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.controller;

import br.com.prolink.model.Cliente;
import br.com.prolink.model.ClienteDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxListCell;
/**
 *
 * @author Tiago
 */
public class ControllerCertidoesCND implements Initializable{
    @FXML
    private JFXComboBox<String> cbStatusPesquisa;
    @FXML
    private JFXComboBox<String> cbFiltroPesquisa;
    @FXML
    private JFXListView<String> lvStatusClientePesquisa;
    
    @FXML
    private JFXTextField txBuscarPesquisa;

    @FXML
    private TableView<?> tbRelacaoPesquisa;

    @FXML
    private JFXComboBox<?> cbTipoPesquisa;

    @FXML
    private JFXDatePicker dtInicioPesquisa;

    @FXML
    private JFXDatePicker dtFimPesquisa;

    @FXML
    private TableView<?> tbVencimentosPesquisa;

    @FXML
    private JFXButton btNovo;

    @FXML
    private JFXTextField txCodigo;

    @FXML
    private JFXComboBox<?> cbStatus;

    @FXML
    private JFXTextField txCriadoPor;

    @FXML
    private JFXTextField txCliente;

    @FXML
    private JFXDatePicker dataValidade;

    @FXML
    private JFXDatePicker dataPesquisa;

    @FXML
    private JFXTextField txClienteNome;
    
    private Map<Integer, Cliente> clientes = new HashMap<>();
    private List<Cliente> listClientes = new ArrayList<>();
    private Set<String> status= new TreeSet<>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClienteDao cDao = new ClienteDao();
        listClientes = cDao.listar();
        listClientes.forEach(c->{
            clientes.put(c.getId(), c);
            status.add(c.getStatus());
        });
    }
    private void combo(){
        cbFiltroPesquisa.getItems().addAll("ID","Nome","CNPJ");
        cbFiltroPesquisa.getSelectionModel().selectFirst();
        cbStatusPesquisa.getItems().addAll("Quaquer","Ok","Ok/Pendencia","Sac");
        cbStatusPesquisa.getSelectionModel().selectFirst();
        status.forEach(c->{
        });
        for (int i = 1; i <= 20 ; i++) {
            String item = "Item "+i ;
            lvStatusClientePesquisa.getItems().add(item);
        }
        lvStatusClientePesquisa.setCellFactory(CheckBoxListCell.forListView((String item) -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) -> 
                    System.out.println("Check box for "+item+" changed from "+wasSelected+" to "+isNowSelected)
            );
            return observable ;
        }));
    }
    
    @FXML
    public void novo(ActionEvent event){
        formulario(null);
    }
    
    private void formulario(Object cliente){
        
    }
}
