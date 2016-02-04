/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Teste extends DocumentosIntModelo {
    
//    String acao, descricao, datahoje, data1, data2, data3, 
//            data1_backup, data2_backup, data3_backup, obs_backup, codigo_backup;
//    
//    String campoDocumentos = "teste"; //campo da tabela documentos
//    String tabela = "teste"; //tabela do formulario
//    String tela = "teste"; //nome da tela
//    
//    String nome="", processo="48", usuario="teste";
//    
    
    Teste(){
        super.inicializacao("teste", "tabela", "tela");
        JOptionPane.showMessageDialog(null ,tabela+"\n"+tela+"\n"+campoDocumentos);
        preencher_tabela();
        pegar_ultimo_registro();
    }
    
    public static void main(String[] args){
        DocumentosIntModelo teste = new Teste();
        teste.setVisible(true);
        
    }   

    
    
}
