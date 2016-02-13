package br.com.prolink.recepcao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class ListagemDAO {
        
    Listagem listagem;
    
    private Connection con;
        public ListagemDAO(Connection con){
            setCon(con);
        }
        public String alterar(ListagemBean tabela){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");    
        Date date = new Date();
        
        //String dia;
        
            
        String sql = "update documentos_recebidos set Quem_recebeu = ?, "
                + "Data_Funcionario_Recebeu = ?, Observacao= ?, Recebido= ? " ;
        sql += "where cod = ?";

        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, tabela.getUsuario());
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setString(3, tabela.getObservacao());
            ps.setString(4, tabela.getRecebido());
            ps.setInt(5, tabela.getCod());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
            } 
            else{
                JOptionPane.showMessageDialog(null, "Erro ao alterar");
            }
            }catch (SQLException e){
                    return e.getMessage();
            }
        return null;
        }

        public List<ListagemBean> listarTodos(String comando) {
            
        String sql = sql = comando;
        
        List<ListagemBean> listarTabela = new ArrayList<ListagemBean>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
               while (rs.next ()){
                    ListagemBean tb = new ListagemBean();

                    tb.setCod(rs.getInt(1));
                    tb.setData(rs.getString(2));
                    tb.setEntreguePor(rs.getString(3));
                    tb.setEmpresa(rs.getString(4));
                    tb.setId(rs.getString(5));
                    tb.setHistorico(rs.getString(6));
                    tb.setPara(rs.getString(7));
                    tb.setQuemrecebeu(rs.getString(8));
                    tb.setObservacao(rs.getString(10));
                    tb.setDepartamento(rs.getString(11));
                    tb.setHora(rs.getString(12));
                    tb.setRecebido(rs.getString(14));
                    listarTabela.add(tb);
            }
            return listarTabela;
            }else{
                JOptionPane.showMessageDialog(null, "Não existe registro com a pesquisa informada");
                return null;
            }   
        }catch (SQLException e){   
            return null;
        }
    }
        public Connection getCon(){
            return con;
    }
        public void setCon(Connection con) {
            this.con = con;
        }
}
