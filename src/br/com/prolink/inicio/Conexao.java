package br.com.prolink.inicio;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Tiago Dias
 */
public class Conexao
{
    final private String driver = "com.mysql.jdbc.Driver";
    // base de dados no amazon rds.
    //final private String url = "jdbc:mysql://implantacao.csghj3rzcv99.us-east-1.rds.amazonaws.com/clientev2";
    final private String url = "jdbc:mysql://localhost/clientev2";
    final private String usuario = "root";
    final private String senha = "";
    private Connection Conexao;  //vai chamar a conexao

    /**
     *
     */
    public Statement statement; //abre caminho para a conexao

    /**
     *
     */
    public ResultSet resultset; //mostra os resultados da conexao
        
    /**
     *
     * @return
     */
    public boolean conecta()
       {
            boolean result = true;
            try 
            {
                Class.forName(driver);//carrega o driver
                Conexao = DriverManager.getConnection(url, usuario, senha);
                //JOptionPane.showMessageDialog(null,"Conexão bem sucedida");
            }
            catch(ClassNotFoundException Driver) 
            {
               JOptionPane.showMessageDialog(null,"Driver não localizado: "+Driver);
               result = false;
            }
            catch(SQLException Fonte) 
            {
                JOptionPane.showMessageDialog(null,"Deu erro na conexão, falha de comunicação "+
                        "com a fonte de dados. \nVerifique sua conexão com a internet, mais detalhes do erro: \n" +Fonte);
                result = false;
            }
            return result; 
       }
       
    /**
     *
     */
    public void desconecta()
       {
            boolean result = true;
            try 
            {
                Conexao.close();
                JOptionPane.showMessageDialog(null,"Banco fechado");
            }
            catch(SQLException fecha) 
            {
                JOptionPane.showMessageDialog(null,"Não foi possivel "+
                        "fechar o banco de dados: "+fecha);
                result = false;
            }

       }
       
    /**
     *
     * @param sql
     */
    public void executeSQL(String sql)
       {
            try 
            {
                statement = Conexao.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                resultset = statement.executeQuery(sql);
                
            }
            catch(SQLException sqlex) 
            {
               JOptionPane.showMessageDialog(null,"Não foi possível "+
                       "executar o comando sql,\n "+sqlex+", \no sql passado foi: " +sql);
            }

       }

    /**
     *
     * @param gry
     * @return
     */
    public int exeQuery(String gry){
           int result = 0;
           try
           {
               statement = Conexao.createStatement();
               result=statement.executeUpdate(gry);
               statement.close();
           }catch(SQLException erro){
               JOptionPane.showMessageDialog(null,"Erro exeQuery: Inserir registro \nClass Conexao!" +erro);               
           }
           return result;
       }
       
}