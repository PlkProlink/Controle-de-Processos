
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class UpdataColunas {
    
    Conexao con = new Conexao();
    
    public UpdataColunas(){
        con.conecta();
            try{    
                con.executeSQL("select AndamentoFiscal from cadastrodeprocesso where AndamentoFiscal='Concluido'");
                while(con.resultset.next()){
                    con.statement.executeUpdate("update cadastrodeprocesso set "
                            + "AndamentoFiscal='Finalizado'");
            }   
            }catch(SQLException erro){
                System.out.print("Erro ao atualizar : "+erro);
            }
        con.desconecta();
    }
        
        
        
    
    public static void main(String[] args){
        new UpdataColunas();
    }

}
