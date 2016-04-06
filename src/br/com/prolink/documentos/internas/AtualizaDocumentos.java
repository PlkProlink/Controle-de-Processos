/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.inicio.Ativador;
import br.com.prolink.inicio.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class AtualizaDocumentos {

    Conexao con;
    List<String> lista = new ArrayList<>();
    
    public void atualizar_documentos1(String tela, String campo){
        
        con = new Conexao();
        con.conecta();
        
        try{
            con.executeSQL("select * from documentos where Numerodoprocesso='"+Ativador.processo+"'");
            if(con.resultset.first()){
                String sql=("update documentos set "+campo+"='Enviado para o Cliente' where Numerodoprocesso='"+Ativador.processo+"'");
                con.statement.executeUpdate(sql);
            }
            atualizar_status();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>"+tela+"\n"+erro);
        }finally{con.desconecta();}
    }
    public void atualizar_documentos2(String tela, String campo){
        con = new Conexao();
        con.conecta();
        
        try{
        con.executeSQL("select * from documentos where Numerodoprocesso='"+Ativador.processo+"'");
        if(con.resultset.first()){
            con.statement.executeUpdate("update documentos set "
                                                +campo+"='Aguardando Validação' where Numerodoprocesso='"+Ativador.processo+"'");
        }
        atualizar_status();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +tela+"\n"+erro);
        }finally{con.desconecta();}
    }
    public void atualizar_documentos3(String tela, String campo){
        
        con = new Conexao();
        con.conecta();
        
        try{
            con.executeSQL("select * from documentos where Numerodoprocesso='"+Ativador.processo+"'");
            if(con.resultset.first()){
                con.statement.executeUpdate("update documentos set "
                                            +campo+"='Validação Efetuada' where Numerodoprocesso='"+Ativador.processo+"'");
            }
            atualizar_status();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +tela+"\n"+erro);
        }finally{con.desconecta();}
    }
    public void atualizar_status(){
        con = new Conexao();
        con.conecta();
        
        try{
            con.executeSQL("select * from documentos where Numerodoprocesso='"+Ativador.processo+"'");
            if(con.resultset.first()){
               lista.add(con.resultset.getString("Afastamento"));
               lista.add(con.resultset.getString("AtoConstitutivo"));
               lista.add(con.resultset.getString("AutorizacaoNotaFiscalEletronica"));
               lista.add(con.resultset.getString("BalanceteExercicio"));
               lista.add(con.resultset.getString("BalancoDRE"));
               lista.add(con.resultset.getString("CAGED"));
               lista.add(con.resultset.getString("ComposicaoDeContasPatrimoniais"));
               lista.add(con.resultset.getString("ComprovanteResidencia"));
               lista.add(con.resultset.getString("ConfigurarPerfilFiscalNoSitePrefeituraDocumento"));
               lista.add(con.resultset.getString("Ferias"));
               lista.add(con.resultset.getString("FolhadePagamentoDocumento"));
               lista.add(con.resultset.getString("GuiaSindical"));
               lista.add(con.resultset.getString("GuiasDarfGpsFgts"));
               lista.add(con.resultset.getString("LivroOuFichadeRegistroFuncionario"));
               lista.add(con.resultset.getString("NumeroPIS"));
               lista.add(con.resultset.getString("OutorgaSenhaEletronicaReceita"));
               lista.add(con.resultset.getString("PlanoDeContas"));
               lista.add(con.resultset.getString("RGeCPFSocio"));
               lista.add(con.resultset.getString("Recisao"));
               lista.add(con.resultset.getString("SEFIP"));
               lista.add(con.resultset.getString("SenhaINSS"));
               lista.add(con.resultset.getString("SenhaPostoFiscal"));
               lista.add(con.resultset.getString("SenhaSimplesNacional"));
               lista.add(con.resultset.getString("TermodeResponsabilidadeDocumento"));
               
            }
            String situacao="Em Aberto";
            for(int i =0 ; i<lista.size(); i++){
                if(!lista.get(i).contains("Validação Efetuada")){
                    situacao="Em Aberto";
                }
                else
                    situacao="Concluido";
            }
            atualiza_cadastro(Integer.parseInt(Ativador.processo),situacao);
        }catch(SQLException erro){
            System.out.println(""+erro);
        }finally{con.desconecta();}
        
    }
    public void atualiza_cadastro(int processo, String situacao){
        con = new Conexao();
        con.conecta();
        
        try{
            con.executeSQL("select * from cadastrodeprocesso where codNumerodoprocesso="+processo);
            if(con.resultset.first()){
                con.statement.executeUpdate("update cadastrodeprocesso set AndamentoDocumentos='"+situacao+"' where codNumerodoprocesso="+processo);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{con.desconecta();}
    }
}
