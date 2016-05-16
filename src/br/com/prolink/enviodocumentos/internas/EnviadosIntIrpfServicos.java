/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.controle.LogUsuarioBean;
import br.com.prolink.controle.LogUsuarioDao;
import br.com.prolink.enviodocumentos.DocumentosEnviados;
import br.com.prolink.enviodocumentos.DocumentosEnviadosDao;
import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.TelaPrincipal;

/**
 *
 * @author User
 */
public class EnviadosIntIrpfServicos extends EnviadosIntModelo{
    String campo1="IRPFsobreServicoTomadoacompanhamento", tabela1="irpfsobreservicotomadoacompanhamento", tela1 = "Irpf Serviço Tomado";
    public EnviadosIntIrpfServicos(){
        setTitle("Acompanhamento de Envios - Irpf Serviço Tomado");
        
        super.inicializacao(campo1, tabela1, tela1);
        
	conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
        
        doc = new DocumentosEnviadosDao();
        log = new LogUsuarioDao();
        logb = new LogUsuarioBean();
        
        logb.setCliente(nome);
        logb.setApelido(TelaPrincipal.txt_id.getText());
        logb.setProcesso(processo);
        logb.setTela(tela);
    }
    public static void main(String[] args){
        EnviadosIntModelo telaBoletos = new EnviadosIntIrpfServicos();
        telaBoletos.setVisible(true);
    }
    
    @Override
    public void enviar_label1(){
        DocumentosEnviados.lbIrpfServ1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        DocumentosEnviados.lbIrpfServ2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        DocumentosEnviados.lbIrpfServ3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.irpf_servico();
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
    