/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.enviodocumentos.internas.*;
import br.com.prolink.enviodocumentos.DocumentosEnviados;
import br.com.prolink.inicio.Conexao;

/**
 *
 * @author User
 */
public class EnviadosIntCsll extends EnviadosIntModelo{
    String campo1="CSLLacompanhamento", tabela1="csllacompanhamento", tela1 = "Csll";
    public EnviadosIntCsll(){
        setTitle("Acompanhamento de Envios - Csll");
        
        super.inicializacao(campo1, tabela1, tela1);
        
	conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        EnviadosIntModelo telaBoletos = new EnviadosIntCsll();
        telaBoletos.setVisible(true);
    }
    
    @Override
    public void enviar_label1(){
        DocumentosEnviados.lbCsll1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        DocumentosEnviados.lbCsll2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        DocumentosEnviados.lbCsll3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.csll();
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
    