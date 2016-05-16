/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.controle.LogUsuarioBean;
import br.com.prolink.controle.LogUsuarioDao;
import br.com.prolink.documentos.Documentos;
import br.com.prolink.documentos.DocumentosDao;
import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.TelaPrincipal;

/**
 *
 * @author Tiago
 */
public class DocumentosIntSefip extends DocumentosIntModelo{
    
	String campo1="SEFIP", tabela1="sefip", tela1 = "Sefip";
	
    public DocumentosIntSefip(){
        setTitle("Folha - SEFIP");
        
        super.inicializacao("SEFIP","sefip","Sefip");
                
        conexao = new Conexao();        
	conexao.conecta();
        
        preencher_tabela();
        pegar_ultimo_registro();
        
        doc = new DocumentosDao();
        log = new LogUsuarioDao();
        logb = new LogUsuarioBean();
        
        logb.setCliente(nome);
        logb.setApelido(TelaPrincipal.txt_id.getText());
        logb.setProcesso(processo);
        logb.setTela(tela);
    
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntSefip();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbSefip1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbSefip2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbSefip3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.sefip();
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
