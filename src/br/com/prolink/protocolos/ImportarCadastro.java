/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.protocolos;

import br.com.prolink.factory.ConexaoStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class ImportarCadastro {
    public static void main(String[] args){
        List<ClienteBean>clientes = new ArrayList<>();
        
        Connection con = getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("select COD,EMPRESA,STATUS from cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clientes.add(new ClienteBean(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{con.close();}catch(SQLException ex){}
        }
        
        ConexaoStatement con2 = new ConexaoStatement();
        Connection conMysql = con2.getConnetion();
        
        try{
            for(int i=0; i<clientes.size();i++){
                ClienteBean cliente = clientes.get(i);
                PreparedStatement ps = conMysql.prepareStatement("insert into cliente (id,nome,status) values (?,?,?)");
                ps.setInt(1, cliente.getId() );
                ps.setString(2, cliente.getNome());
                ps.setString(3, cliente.getStatus());
                if(ps.executeUpdate()==1){
                    System.out.println("Registro "+i+" incluido com sucesso!");
                }
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{conMysql.close();}catch(SQLException ex){}
        }
        System.out.print("concluido com sucesso!");
        System.exit(0);
    }
    private static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(
                    "jdbc:sqlserver://192.168.0.202:1433;databaseName=cadastro",
                    "sa",
                    "B0qbxRw9TL3xYTrHXOULROnH1cMu9JRx");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }   
}
