package br.com.prolink.inicio;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;

/**
 *
 * @author Tiago Dias
 */
public class Conexao
{
    final public static String driver = "com.mysql.jdbc.Driver";
    public static String url="jdbc:mysql://200.207.224.87:3306/clientev1";
    final public static String usuario = "prolink";
    final public static String senha = "77i#EU&K";
    
    public Conexao(){
//        lerConfig();
    }
    private void lerConfig(){
        try{
        Properties propriedades = new Properties();
        FileInputStream file = new FileInputStream("config.txt");
        propriedades.load(file);
        url = propriedades.getProperty("urlBanco");
        file.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Falha ao ler arquivo de configurações!\n"
                    + "Para corrigir copie e cole o arquivo Controle de Processos.lnk do diretorio Sistemas \n"
                    + "e cole na área de trabalho substituindo o atual");
        }
    }
    public Connection connection;  //vai chamar a conexao

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
                connection = DriverManager.getConnection(url, usuario, senha);
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
                        "com a fonte de dados. \nVerifique sua conexão com a internet, mais detalhes do erro: \n\n\n" +Fonte);
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
                connection.close();
                //JOptionPane.showMessageDialog(null,"Banco fechado");
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
                statement = connection.createStatement(
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
               statement = connection.createStatement();
               result=statement.executeUpdate(gry);
               statement.close();
           }catch(SQLException erro){
               JOptionPane.showMessageDialog(null,
                       "Erro exeQuery: Inserir registro \nClass Conexao!" +erro);               
           }
           return result;
       }
       
}