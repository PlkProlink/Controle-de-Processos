/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.model.LogUsuarioBean;
import br.com.prolink.model.LogUsuarioDao;
import br.com.prolink.enviodocumentos.DocumentosEnviados;
import br.com.prolink.enviodocumentos.DocumentosEnviadosDao;
import br.com.prolink.model.ProcessoLogado;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class EnviadosIntGps extends EnviadosIntModelo{
    String campo1="GPSacompanhamento", tabela1="gpsacompanhamento", tela1 = "GPS";
    public EnviadosIntGps(){
        setTitle("Acompanhamento de Envios - GPS");
        
        super.inicializacao(campo1, tabela1, tela1);
        
        preencher_tabela();
        pegar_ultimo_registro();
        
        doc = new DocumentosEnviadosDao();
        log = new LogUsuarioDao();
        logb = new LogUsuarioBean();
        
        logb.setCliente(nome);
        logb.setApelido(ProcessoLogado.getInstance().getProcesso().getApelido());
        logb.setProcesso(processo);
        logb.setTela(tela);
    }
    public static void main(String[] args){
        EnviadosIntModelo telaBoletos = new EnviadosIntGps();
        telaBoletos.setVisible(true);
    }
    
    @Override
    public void enviar_label1(){
        DocumentosEnviados.lbGps1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        DocumentosEnviados.lbGps2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        DocumentosEnviados.lbGps3.setText(data3);
    }
    @Override
    public void atualizaExclusao(Connection con){
        doc.gps(con);
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
    