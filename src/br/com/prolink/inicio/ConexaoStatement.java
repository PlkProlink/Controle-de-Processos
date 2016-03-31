package br.com.prolink.inicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *Essa classe vai abrir e fechar conexao com o banco de dados
 * @author User
 */
        
public class ConexaoStatement{
//vamos abrir a conexao
    
    static String driver = "com.mysql.jdbc.Driver";
    //private static String url = "jdbc:mysql://192.168.0.202/clientev1";
    private static String user = "root";
    //private static String password = "123456"; 
    
    private static String url = "jdbc:mysql://localhost/clientev1";
    private static String password = ""; 
    
    
    public static Connection abrirConexao() {
        Connection con = null;
    try {
        /*vamos dizer ao java que esse é o driver que ultilizaremos para todas
        as conexoes*/
        Class.forName(driver).newInstance();
        
        //*faremos a conexao e passar o valor para a vaeriavel
        con = DriverManager.getConnection(url, user, password);
        //System.out.println("Conexao aberta.");
        /*como abrimos um try devemos ter no minimo um catch ou finally para
        encerra-lo
        */
    } catch (SQLException e) {
        System.out.println((e.getMessage()));
    } catch (ClassNotFoundException e){
        System.out.println((e.getMessage()));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return con;
    }
    public static void fecharConexao(Connection con) {
        try{
            con.close();
            //System.out.println("Conexao fechada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnetion(){
		try {
			Class.forName(driver);
			return  DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException erro) {
			throw new RuntimeException(erro);		
		}
	}
}