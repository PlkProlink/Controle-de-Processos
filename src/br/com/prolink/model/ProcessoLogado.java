/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class ProcessoLogado {
    private static ProcessoLogado instance;
    private Processo processo;

    private TextField txProcesso;
    private TextField txApelido;
    private TextField txNome;
    private TextField txClassificacao;
    private TextField txStatus;

    public static ProcessoLogado getInstance() {
        if (instance == null) {
            instance = new ProcessoLogado();
        }
        return instance;
    }
    public void setAtributos(String[] atributos) {
        try {
            txProcesso.setText(atributos[0]);
            txApelido.setText(atributos[1]);
            txNome.setText(atributos[2]);
            txClassificacao.setText(atributos[3]);
            txStatus.setText(atributos[4].equals("0")?"Concluido":"Em Andamento");
            if (atributos[4].equals("0"))
                txStatus.setStyle("-fx-background-color: green;-fx-text-fill: white;");
            else 
                txStatus.setStyle("-fx-background-color: red;-fx-text-fill: white;");
            processo = new Processo();
            processo.setId(Integer.parseInt(atributos[0]));
            processo.setApelido(atributos[1]);
            processo.setCliente(atributos[2]);
            processo.setClassificacao(atributos[3]);
            processo.setSituacao(atributos[4].equals("Ativo")?1:0);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Falha de vinculação de dados [atributos:classe ProcessoLogado] - Relate para o seu administrador de sistema\nDetails:" + e
            ,"Erro", JOptionPane.ERROR_MESSAGE);
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setTitle("Erro");
//            alert.setHeaderText(null);
//            alert.setContentText("Falha de vinculação de dados [atributos:classe ProcessoLogado] - Relate para o seu administrador de sistema\nDetails:" + e);
//            alert.showAndWait();
        }
    }

    public void setTextFields(TextField[] textFields) {
        txProcesso = textFields[0];
        txApelido = textFields[1];
        txNome = textFields[2];
        txClassificacao = textFields[3];
        txStatus = textFields[4];
    }

    /**
     * @return the processo
     */
    public Processo getProcesso() {
        return processo;
    }

    /**
     * @param processo the processo to set
     */
    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

}
