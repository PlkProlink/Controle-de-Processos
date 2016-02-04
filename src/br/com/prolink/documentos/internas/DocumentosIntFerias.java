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
public class DocumentosIntFerias extends DocumentosIntModelo{
    
    String campo1="Ferias", tabela1="ferias", tela1 = "Ferias";
    
    public DocumentosIntFerias(){
        setTitle("Folha - Férias");
        
        super.inicializacao("Ferias","ferias","Ferias");
		
		conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntFerias();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbFerias1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbFerias2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbFerias3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.ferias();
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
