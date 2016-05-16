import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class Estudos extends JFrame{
  public Estudos(){
    super("Exemplo de uma tabela simples");
		
    // colunas da tabela
    String[] colunas = {"Nome", "Idade", "Sexo"};
		
    // conteúdo da tabela	
    Object[][] conteudo = {
        {"Osmar J. Silva", "32", "Masculino"},
        {"Maria Clara Gomes", "19", "Feminino"},
        {"Fernando Gomes", "15", "Masculino"},
        {"Carlos Vieira", "40", "Masculino"}
    };
        
    // constrói a tabela
    JTable tabela = new JTable(conteudo, colunas);
    
    // quero colorir o fundo das células da segunda coluna
    // se o valor encontrado for menor que 20
    TableCellRenderer tcr = new Colorir();
    TableColumn column = 
      tabela.getColumnModel().getColumn(1);
	column.setCellRenderer(tcr);
 
    tabela.setPreferredScrollableViewportSize(new 
        Dimension(350, 50));
	
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
			
    JScrollPane scrollPane = new JScrollPane(tabela);
    c.add(scrollPane);
    	
    setSize(400, 300);
    setVisible(true);
  }
	
  public static void main(String args[]){
    Estudos app = new Estudos();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

class Colorir extends JLabel implements TableCellRenderer{
  public Component getTableCellRendererComponent(
     JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column){
    
     if(Integer.parseInt(value.toString()) < 20){
       setForeground(Color.RED);	
     }
     else{
       setForeground(Color.BLUE);		
     }
     
     setText(value.toString());
     	
     return this;   	
  }
  
  public void validate() {}
  public void revalidate() {}
  protected void firePropertyChange(String propertyName,
      Object oldValue, Object newValue) {}
  public void firePropertyChange(String propertyName,
      boolean oldValue, boolean newValue) {}  
}
