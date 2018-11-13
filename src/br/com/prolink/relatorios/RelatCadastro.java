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

public class RelatCadastro {

    Conexao con = new Conexao();
    String processo = ""+ProcessoLogado.getInstance().getProcesso().getId();

    private String comando;

    public static void main(String args[]) {
        //new RelatCadastro();
    }

    public RelatCadastro() {
//        relatorioResumidoGeral();
    }

    public void relatorioResumidoUm() {
        try {
            con.conecta();
            con.executeSQL("SELECT  Apelido, Cliente, Classificacao, Observacao, "
                    + "Datadecadastro, DatadeAtivacao,DataDeArquivamentodoProcesso "
                    + "from cadastrodeprocesso where codNumerodoprocesso=" + processo);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    "relatorios/cadClientes.jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatorio \n erro =" + erro);
        } finally {
            con.desconecta();
        }
    }

    public void relatorioResumidoGeral() {
        try {
            con.conecta();
            con.executeSQL("SELECT  Apelido, Cliente, Classificacao, Observacao, "
                    + "Datadecadastro, DatadeAtivacao,DataDeArquivamentodoProcesso "
                    + "from cadastrodeprocesso");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    "relatorios/cadClientes.jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatorio \n erro =" + erro);
        } finally {
            con.desconecta();
        }
    }

    public void acompanhamentosUm() {
        try {
            con.conecta();
            con.executeSQL("SELECT acompanhamentodeenvios.*, "
                    + "cadastrodeprocesso.codNumerodoprocesso, "
                    + "cadastrodeprocesso.Apelido, "
                    + "cadastrodeprocesso.Cliente "
                    + "FROM acompanhamentodeenvios INNER JOIN cadastrodeprocesso "
                    + "ON acompanhamentodeenvios.Numerodoprocesso = cadastrodeprocesso.codNumerodoprocesso "
                    + "where cadastrodeprocesso.codNumerodoprocesso=" + processo);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    "relatorios/sitDocumentosEnviados.jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatorio \n erro =" + erro);
        } finally {
            con.desconecta();
        }
    }

    public void acompanhamentosGeral() {
        try {
            con.conecta();
            con.executeSQL("SELECT acompanhamentodeenvios.*, "
                    + "cadastrodeprocesso.codNumerodoprocesso, "
                    + "cadastrodeprocesso.Apelido, "
                    + "cadastrodeprocesso.Cliente "
                    + "FROM acompanhamentodeenvios INNER JOIN cadastrodeprocesso "
                    + "ON acompanhamentodeenvios.Numerodoprocesso = cadastrodeprocesso.codNumerodoprocesso");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    "relatorios/sitDocumentosEnviados.jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatorio \n erro =" + erro);
        } finally {
            con.desconecta();
        }
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getComando() {
        return comando;
    }

}
