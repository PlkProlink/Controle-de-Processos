package br.com.prolink.relatorios;

import br.com.prolink.inicio.Ativador;
import br.com.prolink.factory.Conexao;
import br.com.prolink.model.ProcessoLogado;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioRecepcao {

    
  Conexao con = new Conexao();
  String processo = ProcessoLogado.getInstance().getProcesso().getId()+"";
  private String comando;
  
  public static void main (String args[]) 
  {
    //new RelatCadastro();
  }

    public RelatorioRecepcao(){
//        relatorioResumidoGeral();
    }
    
    public void listagem(){
        try 
      {
          con.conecta();
          con.executeSQL(this.getComando());
          JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
          JasperPrint jasperPrint = JasperFillManager.fillReport(
          "relatorios/docListagem.jasper", new HashMap(), jrRS);
          JasperViewer.viewReport(jasperPrint, false);
      } catch (Exception erro){
                 JOptionPane.showMessageDialog(null,"Erro ao gerar o relatorio \n erro ="+erro);
      } finally{
          con.desconecta();
      }
    }
    /**
     * @return the comando
     */
    public String getComando() {
        return comando;
    }

    /**
     * @param comando the comando to set
     */
    public void setComando(String comando) {
        this.comando = comando;
    }

    
}




