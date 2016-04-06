/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recepcao.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tiago
 */
public class ConnectionFactory {
     String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://192.168.0.202/clientev2";
	private final String user = "root";
	private final String password   = "123456"; 
	public Connection getConnetion(){
		try {
			Class.forName(driver);
			return  DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException erro) {
			throw new RuntimeException(erro);		
		}
	}
}
