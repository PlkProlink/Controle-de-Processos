/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.TelaPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AtualizacaoEnviados {
 
    Conexao conexao;
    
    List<String> lista = new ArrayList<>();
    
    boolean atualizar_acompanhamento1(String campo, String tela){
        try{
            conexao = new Conexao();
            conexao.conecta();
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            if(conexao.resultset.first()){
            
            conexao.statement.executeUpdate("update acompanhamentodeenvios set "
                                            +campo+"='1º Envio Realizado' where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            }
            atualizar_status();
            return true;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar acompanhamento: tela>" +tela);
            return false;
        }finally{
            conexao.desconecta();
        }
        
    }
    boolean atualizar_acompanhamento2(String campo, String tela){
        try{
            conexao = new Conexao();
            conexao.conecta();
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            if(conexao.resultset.first()){
            conexao.statement.executeUpdate("update acompanhamentodeenvios set "
                                                + campo+"='2º Envio Realizado' where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            }
            atualizar_status();
            return true;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar acompanhamento: tela>" +tela);
            return false;
        }finally{
            conexao.desconecta();
        }
    }
    boolean atualizar_acompanhamento3(String campo, String tela){
        try{
            conexao = new Conexao();
            conexao.conecta();
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            if(conexao.resultset.first()){
            conexao.statement.executeUpdate("update acompanhamentodeenvios set "
                                            + campo+"='Finalizado' where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            }
            atualizar_status();
            return true;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar acompanhamento: tela>" +tela);
            return false;
        }finally{
            conexao.desconecta();
        }
    }
    public void atualizar_status(){
        conexao = new Conexao();
        conexao.conecta();
        
        try{
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+TelaPrincipal.txt_codigo.getText()+"'");
            if(conexao.resultset.first()){
               lista.add(conexao.resultset.getString("PISacompanhamento"));
               lista.add(conexao.resultset.getString("COFIISacompanhamento"));
               lista.add(conexao.resultset.getString("IRPJacompanhamento"));
               lista.add(conexao.resultset.getString("CSLLacompanhamento"));
               lista.add(conexao.resultset.getString("ISSacompanhamento"));
               lista.add(conexao.resultset.getString("GPSacompanhamento"));
               lista.add(conexao.resultset.getString("BoletoPLKacompanhamento"));
               lista.add(conexao.resultset.getString("IRPFsobreSalarioacompanhamento"));
               lista.add(conexao.resultset.getString("IRPFsobreServicoTomadoacompanhamento"));
               lista.add(conexao.resultset.getString("FGTSacompanhamento"));
               lista.add(conexao.resultset.getString("ICMSacompanhamento"));
               lista.add(conexao.resultset.getString("DASacompanhamento"));
               lista.add(conexao.resultset.getString("IPIacompanhamento"));
               lista.add(conexao.resultset.getString("ICMSServTomacompanhamento"));
               
            }
            String situacao="Em Aberto";
            for(int i =0 ; i<lista.size(); i++){
                if(!lista.get(i).contains("Finalizado")){
                    situacao="Em Aberto";
                    break;
                }
                else
                    situacao="Concluido";
            }
            atualiza_cadastro(Integer.parseInt(TelaPrincipal.txt_codigo.getText()),situacao);
            
        }catch(SQLException erro){
            System.out.println(""+erro);
        }finally{conexao.desconecta();}
        
    }
    
    public void atualiza_cadastro(int processo, String situacao){
        conexao = new Conexao();
        conexao.conecta();
        
        try{
            conexao.executeSQL("select * from cadastrodeprocesso where codNumerodoprocesso="+processo);
            if(conexao.resultset.first()){
                conexao.statement.executeUpdate("update cadastrodeprocesso set AcompanhamentodeEnvios='"+situacao+"' where codNumerodoprocesso="+processo);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{conexao.desconecta();}
    }
}

