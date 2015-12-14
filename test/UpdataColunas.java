
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
        int cont=1;
        con.conecta();
        while(cont<=100){
        
            try{    
                    con.executeSQL("select * from documentos_recebidos where cod="+cont);
                    if(con.resultset.first()){
                        con.statement.executeUpdate("update documentos_recebidos set Confirmado='Y' where cod="+cont);
                        cont++;
                    }
                    else
                        cont++;
            }catch(SQLException erro){
                System.out.print("Erro ao atualizar");
            }
        }
        con.desconecta();
        
        
    }
    public static void main(String[] args){
        
        
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
