/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package testeAbstractTable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class TesteModeloTabela extends AbstractTableModel {

    private int colunas, linhas;
    private ResultSet resultSet;
    private ResultSetMetaData rsMetaData;//pega quantidade de colunas e retorna todos os campos e tipos do banco
    
    public TesteModeloTabela(ResultSet resultset) throws SQLException{
        rsMetaData = resultset.getMetaData();
        this.resultSet = resultset;
        //select * from
        resultset.last();//posicionar no ultimo registro
        linhas = resultset.getRow();//pegar numero da linha
        //aciona alterações na estrutura da tabela
        fireTableStructureChanged();
        
        
    }    
    @Override
    public String getColumnName(int column){
        try{
            return rsMetaData.getColumnName(column+1);
        }catch(SQLException e){
            System.out.printf(""+e);
            return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return linhas;
    }

    @Override
    public int getColumnCount() {
        this.colunas = 0;
        //contar colunas
        try{
            this.colunas = rsMetaData.getColumnCount();
        }catch(SQLException e){
            System.out.println("Erro ao ler quantidade de colunas");
        }
        return this.colunas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    //povoar o jtable
        try{
            resultSet.absolute(rowIndex+1);
            return resultSet.getObject(columnIndex+1);
        }catch(SQLException e){
            System.out.println("");
            return "";
        }
    }
    
}
