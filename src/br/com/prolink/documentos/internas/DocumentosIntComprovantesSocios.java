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
public class DocumentosIntComprovantesSocios extends DocumentosIntModelo{
    
    String campo1="ComprovanteResidencia", tabela1="comprovanteresidencia", tela1 = "Comprovantes dos Socios";
    
    public DocumentosIntComprovantesSocios(){
        setTitle("Contratos - Comprovantes dos Socios(Comp.Residência");
        
        super.inicializacao("ComprovanteResidencia","comprovanteresidencia", "Comprovantes dos Socios");

		conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntComprovantesSocios();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbComp1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbComp2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbComp3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.comSocios();
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
