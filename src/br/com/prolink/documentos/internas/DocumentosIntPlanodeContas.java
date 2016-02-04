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
public class DocumentosIntPlanodeContas extends DocumentosIntModelo{
    
    String campo1="PlanoDeContas", tabela1="planodecontas", tela1 = "Plano de Contas";
    
    public DocumentosIntPlanodeContas(){
        setTitle("Contabilidade - Plano de Contas");
        
        super.inicializacao("PlanoDeContas","planodecontas", "Plano de Contas");
        
		conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntPlanodeContas();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbPlano1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbPlano2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbPlano3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.plano();
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
