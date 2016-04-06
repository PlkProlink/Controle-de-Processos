/*
 * Direitos reservados para Neri Aldoir Neitzke
 * www.informaticon.com.br 
 */
package testeAbstractTable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 * @author Neri Aldoir Neitke Autor de 4.600 videoaulas - Palestrante
 * Internacional
 */
public class ModeloTabela2 extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetPessoas;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Codigo", "Nome da Pessoa"
    };
    @Override
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabela2(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetPessoas = new ArrayList<String[]>();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("codigo"),
                resultset.getString("nome"),
                //resultset.getString("telefone"),
                //resultset.getString("email"), 
            };
            resultSetPessoas.add(linha);
            
        }
        fireTableStructureChanged();
    }
    public void deletarLinha(int linha) {
        resultSetPessoas.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
            

    @Override
    public int getRowCount() {
        return resultSetPessoas.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetPessoas.get(rowIndex);
        return linha[columnIndex];
    }
    
}
