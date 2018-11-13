/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.model.LogUsuarioBean;
import br.com.prolink.model.LogUsuarioDao;
import br.com.prolink.documentos.Documentos;
import br.com.prolink.documentos.DocumentosDao;
import br.com.prolink.factory.Conexao;
import br.com.prolink.model.ProcessoLogado;


/**
 *
 * @author Tiago
 */
public class DocumentosIntSenhaSimples extends DocumentosIntModelo{
    
    String campo1="SenhaSimplesNacional", tabela1="senhasimplesnacional", tela1 = "Senha do Simples Nacional";
    
    public DocumentosIntSenhaSimples(){
        setTitle("Contratos - Senha de Acesso ao Simples Nacional");
        
        super.inicializacao("SenhaSimplesNacional","senhasimplesnacional", "Senha do Simples Nacional");
        
        preencher_tabela();
        pegar_ultimo_registro();
        doc = new DocumentosDao();
        log = new LogUsuarioDao();
        logb = new LogUsuarioBean();
        
        logb.setCliente(nome);
        logb.setApelido(ProcessoLogado.getInstance().getProcesso().getApelido());
        logb.setProcesso(processo);
        logb.setTela(tela);
        
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntSenhaSimples();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbSimples1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbSimples2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbSimples3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.simples();
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
