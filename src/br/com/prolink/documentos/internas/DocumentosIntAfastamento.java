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
public class DocumentosIntAfastamento extends DocumentosIntModelo{
    
    String campo1="Afastamento", tabela1="afastamento", tela1 = "Afastamento";
    
    public DocumentosIntAfastamento(){
        
        setTitle("Departamento Pessoal - Afastamentos");
        
        super.inicializacao(campo1, tabela1, tela1);
        
	conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntAfastamento();
        doc.setVisible(true);
    }
    
    @Override
    public void enviar_label1(){
        Documentos.lbAfastamentos1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbAfastamentos2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbAfastamentos3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.afastamentos();
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
