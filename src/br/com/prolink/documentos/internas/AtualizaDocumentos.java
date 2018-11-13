/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;


import br.com.prolink.factory.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.prolink.model.ProcessoLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tiago
 */
public class AtualizaDocumentos {

    Conexao con;
    List<String> lista = new ArrayList<>();
    
    public void atualizar_documentos1(String tela, String campo,Connection con){
        try{
//            String sql = ("select * from documentos where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet resultset = ps.executeQuery();
//            if(resultset.next()){
//                sql=("update documentos set "+campo+"='Enviado para o Cliente' where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
//                ps.clearParameters();
//                ps.executeUpdate(sql);
//            }
            String sql=("update documentos set "+campo+"='Enviado para o Cliente' where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            atualizar_status(con);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>"+tela+"\n"+erro);
        }
    }
    public void atualizar_documentos2(String tela, String campo,Connection con){
        try{
//            String sql = ("select * from documentos where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
//            PreparedStatement ps = con.prepareStatement(sql);
//                ResultSet resultset = ps.executeQuery();
//            if(resultset.first()){
//                con.statement.executeUpdate("update documentos set "
//                                                    +campo+"='Aguardando Validação' where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
//            }
            String sql = ("update documentos set "
                    +campo+"='Aguardando Validação' where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            atualizar_status(con);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +tela+"\n"+erro);
        }
    }
    public void atualizar_documentos3(String tela, String campo,Connection con){
        try{
//            String sql = ("select * from documentos where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
//            if(resultset.first()){
//                con.statement.executeUpdate("update documentos set "
//                                            +campo+"='Validação Efetuada' where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
//            }
//            
            String sql = ("update documentos set "
                                            +campo+"='Validação Efetuada' where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            atualizar_status(con);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +tela+"\n"+erro);
        }
    }
    private void atualizar_status(Connection con){
        try{
            String sql = ("select * from documentos where Numerodoprocesso='"+ProcessoLogado.getInstance().getProcesso().getId()+"'");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultset = ps.executeQuery();
            
            if(resultset.next()){
               lista.add(resultset.getString("Afastamento"));
               lista.add(resultset.getString("AtoConstitutivo"));
               lista.add(resultset.getString("AutorizacaoNotaFiscalEletronica"));
               lista.add(resultset.getString("BalanceteExercicio"));
               lista.add(resultset.getString("BalancoDRE"));
               lista.add(resultset.getString("CAGED"));
               lista.add(resultset.getString("ComposicaoDeContasPatrimoniais"));
               lista.add(resultset.getString("ComprovanteResidencia"));
               lista.add(resultset.getString("ConfigurarPerfilFiscalNoSitePrefeituraDocumento"));
               lista.add(resultset.getString("Ferias"));
               lista.add(resultset.getString("FolhadePagamentoDocumento"));
               lista.add(resultset.getString("LivroOuFichadeRegistroFuncionario"));
               lista.add(resultset.getString("NumeroPIS"));
               lista.add(resultset.getString("OutorgaSenhaEletronicaReceita"));
               lista.add(resultset.getString("PlanoDeContas"));
               lista.add(resultset.getString("RGeCPFSocio"));
               lista.add(resultset.getString("Recisao"));
               lista.add(resultset.getString("SenhaINSS"));
               lista.add(resultset.getString("SenhaPostoFiscal"));
               lista.add(resultset.getString("SenhaSimplesNacional"));
               lista.add(resultset.getString("TermodeResponsabilidadeDocumento"));
            }
            String situacao="Em Aberto";
            for(int i =0 ; i<lista.size(); i++){
                if(!lista.get(i).contains("Validação Efetuada")){
                    situacao="Em Aberto";
                    break;
                }
                else
                    situacao="Concluido";
            }
            atualiza_cadastro(ProcessoLogado.getInstance().getProcesso().getId(),situacao,con);
        }catch(SQLException erro){
            System.out.println(""+erro);
        }
        
    }
    private void atualiza_cadastro(int processo, String situacao,Connection con){
       try{
           String sql = ("update cadastrodeprocesso set AndamentoDocumentos='"+situacao+"' where codNumerodoprocesso="+processo);
           PreparedStatement ps = con.prepareStatement(sql);
           ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
