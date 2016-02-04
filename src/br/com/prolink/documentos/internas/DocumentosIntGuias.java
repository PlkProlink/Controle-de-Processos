/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.documentos.Documentos;
import br.com.prolink.inicio.Conexao;

/**
 *
 * @author Tiago
 */
public class DocumentosIntGuias extends DocumentosIntModelo{
    
    String campo1="GuiasDarfGpsFgts", tabela1="guiasdarfgpsfgts", tela1 = "Outras Guias";
    
    public DocumentosIntGuias(){
        setTitle("Folha - Outras Guias(DARF, GPS e FGTS");
        
        super.inicializacao("GuiasDarfGpsFgts","guiasdarfgpsfgts", "Outras Guias");

		conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntGuias();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbDarf1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbDarf2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbDarf3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.darf();
    }
    @Override
    public void setTabela(){
        this.tabela=this.tabela1;
    }
    @Override
    public void setCampoDocumentos(){
        this.campoDocumentos = this.campo1;
    }
    @Override
    public void setTela(){
        this.tela = this.tela1;
    }
}
