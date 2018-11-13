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
public class DocumentosIntPerfil extends DocumentosIntModelo{
    
    String campo1="ConfigurarPerfilFiscalNoSitePrefeituraDocumento", 
            tabela1="configurarperfilfiscalnositeprefeituradocumento", 
            tela1 = "Perfil Fiscal";
    
    public DocumentosIntPerfil(){
        setTitle("Senhas/Autorizações - Conf.Perfil Fiscal PMSP");
        
        super.inicializacao("ConfigurarPerfilFiscalNoSitePrefeituraDocumento", 
                "configurarperfilfiscalnositeprefeituradocumento", "Perfil Fiscal");
        
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
        DocumentosIntModelo doc = new DocumentosIntPerfil();
        doc.setVisible(true);
    }
        
    @Override
    public void enviar_label1(){
        Documentos.lbPrefeitura1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbPrefeitura2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbPrefeitura3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.prefeitura();
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
