/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.inicio.Ativador;
import br.com.prolink.inicio.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AtualizacaoEnviados {
 
    Conexao conexao;
    
    boolean atualizar_acompanhamento1(String campo, String tela){
        try{
            conexao = new Conexao();
            conexao.conecta();
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+Ativador.processo+"'");
            if(conexao.resultset.first()){
            
            conexao.statement.executeUpdate("update acompanhamentodeenvios set "
                                            + campo+"='1º Envio Realizado' where Numerodoprocesso='"+Ativador.processo+"'");
            }
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
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+Ativador.processo+"'");
            if(conexao.resultset.first()){
            conexao.statement.executeUpdate("update acompanhamentodeenvios set "
                                                + campo+"='2º Envio Realizado' where Numerodoprocesso='"+Ativador.processo+"'");
            }
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
            conexao.executeSQL("select * from acompanhamentodeenvios where Numerodoprocesso='"+Ativador.processo+"'");
            if(conexao.resultset.first()){
            conexao.statement.executeUpdate("update acompanhamentodeenvios set "
                                            + campo+"='Finalizado' where Numerodoprocesso='"+Ativador.processo+"'");
            }
            return true;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar acompanhamento: tela>" +tela);
            return false;
        }finally{
            conexao.desconecta();
        }
}
}
