
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
/**
 *
 * @author Tiago
 */
public class JTableCoresColumn  extends JPanel {

    public JTableCoresColumn() {
        Object[] nomeColunas = {"Nome do Cliente", "Idade", "Email", "Ativo"};
        Object[][] dados = {
            {"Tiago Dias", 25, "tiagoice@hotmail.com", Boolean.TRUE},
            {"Celso Dias", 31, "celso@hotmail.com", Boolean.FALSE},
            {"Fulano Souza", 26, "fulano@hotmail.com", Boolean.TRUE},
            {"Marcos", 14, "teste@hotmail.com", Boolean.FALSE}
        };
        DefaultTableModel defaultTableModel = new DefaultTableModel(dados, nomeColunas) {

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Cores Conforme Conteúdo", coresConformeConteudo(defaultTableModel));
        add(jTabbedPane);
    }

    private JComponent coresConformeConteudo(DefaultTableModel defaultTableModel) {
        JTable jTable = new JTable(defaultTableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                //component.setBackground(Color.ORANGE); //muda cor para toda a tabela
                //component.setBackground(row % 2 == 0 ? Color.ORANGE : Color.WHITE);
                if (!isRowSelected(row)) {
                    component.setBackground(getBackground());
                    int linha = convertRowIndexToModel(row);
                    //as 3 linhas abaixo mudam a cor de todos os que sua idade seja maior ou igual a 30 anos
                    
                    String valor = (String) getModel().getValueAt(linha, 0);
                    int pos = valor.indexOf("Dias");
                    if (pos != -1) {
                        component.setBackground(Color.CYAN);
                    }

                    //muda as cores conforme se cliente é ativo ou não
                    //boolean ativo = (boolean) getModel().getValueAt(linha, 3);
                    //if (ativo == true)
                    //	component.setBackground(Color.CYAN);          		
                }

                return component;
            }
        };
        jTable.setAutoCreateRowSorter(true);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(140);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable.changeSelection(0, 0, false, false);
        //jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize()); // se ajusta ao tamanho da tabela
        return new JScrollPane(jTable);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Teste tiago - cores em Jtable");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new JTableCores());
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
;
}
