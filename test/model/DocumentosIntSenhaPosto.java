/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.documentos.Documentos;

/**
 *
 * @author Tiago
 */
public class DocumentosIntSenhaPosto extends DocumentosIntModelo{
    
    public DocumentosIntSenhaPosto(){
        setTitle("Contratos - Senha do Posto Fiscal");
        
        super.inicializacao("SenhaPostoFiscal","autorizacaonotafiscaleletronica", "Senha do Posto Fiscal");
        
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntSenhaPosto();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbPosto1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbPosto2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbPosto3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.posto();
    }
}
