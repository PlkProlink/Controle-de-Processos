/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.inicio.Ativador;
import br.com.prolink.inicio.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class AtualizaDocumentos {

    Conexao con;
    
    public void atualizar_documentos1(String tela, String campo){
        
        con = new Conexao();
        con.conecta();
        
        try{
            con.executeSQL("select * from documentos where Numerodoprocesso='"+Ativador.processo+"'");
            if(con.resultset.first()){
                String sql=("update documentos set "+campo+"='Enviado para o Cliente' where Numerodoprocesso='"+Ativador.processo+"'");
                con.statement.executeUpdate(sql);
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>"+tela+"\n"+erro);
        }
        con.desconecta();
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
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +tela+"\n"+erro);
        }
        con.desconecta();
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
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +tela+"\n"+erro);
        }
        con.desconecta();
    }
}
