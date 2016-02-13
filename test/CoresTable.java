/*
 * Prof Neri Neitzke - Mais de 100 palestras em 7 países
 * Videoaulas Neri wwww.informaticon.com.br
 * email: videoaulaneri@gmail.com
 */


import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * Videoaulas Neri www.informaticon.com.br email:videoaulaneri@gmail.com
 */
public class CoresTable extends JPanel  {

    public CoresTable() {
        Object[] nomeColunas = {"Nome da Cliente", "Idade", "Email", "Ativo"};
        Object[][] dados = {
            {"Prisciele Fragoso", 25, "prisciele@informaticon.com.br", Boolean.TRUE},
            {"Neri Aldoir Neitzke", 35, "neri@informaticon.com.br", Boolean.FALSE},
            {"Lisiane Batista Neitzke", 45, "lisiane@informaticon.com.br", Boolean.TRUE},
            {"Giulia Batista Neiitzke", 15, "giulia@informaticon.com.br", Boolean.TRUE},
            {"Gustavo Neitzke", 12, "gustavo@informaticon.com.br", Boolean.FALSE},
            {"Selvino João Neitzke", 64, "selvino@informaticon.com.br", Boolean.TRUE},
            {"Romilda Arreal Neitzke", 60, "mae@informaticon.com.br", Boolean.FALSE},
            {"Lizete Maria Neitzke", 38, "dete@informaticon.com.br", Boolean.FALSE},
            {"Valderi Neitzke", 36, "pi@informaticon.com.br", Boolean.TRUE},
            {"Vanderlei Neitzke", 34, "vande@informaticon.com.br", Boolean.FALSE},
            {"Sidinei Neitzke", 33, "sidi@informaticon.com.br", Boolean.TRUE},
            {"Thiago Rafael Neitzke", 24, "thiago@informaticon.com.br", Boolean.FALSE},
            {"Lucas Neitzke", 21, "lucas@informaticon.com.br", Boolean.TRUE}
        };
        DefaultTableModel defaultTableModel = new DefaultTableModel(dados, nomeColunas) {
            
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Cores Alternadas",coresAlternadas(defaultTableModel));
        jTabbedPane.addTab("Cores Conforme Conteúdo",coresConformeConteudo(defaultTableModel));
        jTabbedPane.addTab("Cor Borda",corBorda(defaultTableModel));
        add(jTabbedPane);
    }
    //Videoaulas Neri www.informaticon.com.br email:videoaulaneri@gmail.com
    private JComponent coresAlternadas(DefaultTableModel defaultTableModel) {
        JTable jTable = new JTable(defaultTableModel) {
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                //component.setBackground(Color.ORANGE); //muda cor para toda a tabela
                //component.setBackground(row % 2 == 0 ? Color.ORANGE : Color.WHITE);
                if (!isRowSelected(row)) {
                	component.setBackground(row % 2 == 0 ? getBackground() : Color.YELLOW);
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
    //Videoaulas Neri www.informaticon.com.br email:videoaulaneri@gmail.com
    private JComponent corBorda(DefaultTableModel defaultTableModel) {
        JTable jTable = new JTable(defaultTableModel) {
        	private final Border BORDA = new MatteBorder(1, 0, 1, 0, Color.RED);
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                JComponent jComponent = (JComponent) component;
                if (isRowSelected(row)) {
                	jComponent.setBorder(BORDA);
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
  //Videoaulas Neri www.informaticon.com.br email:videoaulaneri@gmail.com
    private JComponent coresConformeConteudo(DefaultTableModel defaultTableModel) {
        JTable jTable = new JTable(defaultTableModel) {
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                //component.setBackground(Color.ORANGE); //muda cor para toda a tabela
                //component.setBackground(row % 2 == 0 ? Color.ORANGE : Color.WHITE);
                if (!isRowSelected(row)) {
                	component.setBackground(getBackground());
                	int linha = convertRowIndexToModel(row);
                	
                	//as 3 linhas abaixo mudam a cor de todos os que sua idade seja maior ou igual a 30 anos
                	int idade = (int) getModel().getValueAt(linha, 1);
                	if (idade >= 30)
                		component.setBackground(Color.CYAN);
                	
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
    //Videoaulas Neri www.informaticon.com.br email:videoaulaneri@gmail.com
    public static void main(String args[]) {
         JFrame jFrame = new JFrame("Videoaulas Neri - Cores em Table");
         jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jFrame.add(new CoresTable());
         jFrame.pack(); 
         jFrame.setLocationRelativeTo(null);
         jFrame.setVisible(true);
    };
    
    /**
        * Videoaulas Neri www.informaticon.com.br email:videoaulaneri@gmail.com
 */
}
