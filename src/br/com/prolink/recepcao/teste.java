/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.recepcao;

import br.com.prolink.inicio.ConexaoStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class teste {

    private static Connection con;

    public teste() {
        
    }

    public static void main(String[] args) {
        new teste().alterar();
    }
    public String alterar(){
            try {
            
            this.con = new ConexaoStatement().abrirConexao();
            
            Date date = new Date();
            
            String sql = "update documentos_recebidos set Quem_recebeu = ?, "
                    + "Data_Funcionario_Recebeu = ?, Observacao= ?, Recebido= ? " ;
            sql += "where cod = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "teste");
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setString(3, "Nenhuma observacao");
            ps.setString(4, "S");
            ps.setInt(5, 15);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }finally{
                ConexaoStatement.fecharConexao(con);
        }
            return null;
    }

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public static void setCon(Connection con) {
        teste.con = con;
    }
}

