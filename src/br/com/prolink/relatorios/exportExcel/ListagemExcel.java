package br.com.prolink.relatorios.exportExcel;


import br.com.prolink.inicio.Conexao;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 * @www.facebook.com/groups/ProgramacionEnGeneral/
 * @author Jheyson Matta
 */
public class ListagemExcel {
    
  private Connection conn;  
  /** ruta y archivo de destino */
  //File file = new File("H:\\RegistroMysql.xls");
  private String comando;
  
  File file = null;
  
  private String id="Id";
  private String empresa="Empresa";
  private String paraQuem="Para Quem";
  private String data="Data";
  private String entreguePor="Entregue por";
  private String recebidoPor="Recebido por";
  private String historico="Historico";
  private String observacao="Observacao";
  private String cod="Protocolo";
  private String caminho="";
  
  /**
     * Constructor de clase
     */
    public ListagemExcel()
    {
    
      try {
          Class.forName(Conexao.driver);
          conn = DriverManager.getConnection(Conexao.url, Conexao.usuario, Conexao.senha);
          if ( conn!=null ){
              System.out.println("Conexao com a base de dados ...... ok ");
          }
////      this.url = "jdbc:mysql://192.168.0.202/"+this.db;
////       try{
////         //obtenemos el driver de para mysql
////         Class.forName("com.mysql.jdbc.Driver");
////         //obtenemos la conexión
////         
////         conn = DriverManager.getConnection( this.url, this.user , this.password );
////         if ( conn!=null ){
////            System.out.println("Conexao com a base de dados "+this.db+"...... ok ");
////         }
////      }catch(SQLException e){
////         System.err.println( e.getMessage() );
////      }catch(ClassNotFoundException e){
////         System.err.println( e.getMessage() );
////      }
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(ListagemExcel.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(ListagemExcel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void openFileChooser(){
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Planilha do Excel .xls", ".xls"));
        
        int retorno = chooser.showSaveDialog(null);
        if(retorno==JFileChooser.APPROVE_OPTION){
            caminho = chooser.getSelectedFile().getAbsolutePath(); //
        }
        if(!caminho.equals("")){
            file = new File(caminho+".xls");
            WriteExcel();
        }
        
    }
    /**
     * Metodo para obtener los registros de la base de datos y crear el archivo excel
     */
    
    public void WriteExcel()
    {
        int row=0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont( WritableFont.ARIAL, 12, WritableFont.NO_BOLD );
        WritableCellFormat cf = new WritableCellFormat(wf);    
        
        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;
        
        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        
        try {
            workbook = Workbook.createWorkbook( file, wbSettings );
            //hoja con nombre de la tabla
            workbook.createSheet( "listagem", 0 );
            excelSheet = workbook.getSheet(0);
            System.out.println(  "Creando Pasta de trabalho.....Feito"  );            
        } catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }
        
        //Consulta SQL 
        //String sql = "SELECT * from documentos_recebidos where Para_Quem like 'tiago'";
        try{
            PreparedStatement pstm = conn.prepareStatement(this.getComando());
            ResultSet res = pstm.executeQuery();
            System.out.println(  "Obtendo leitura de registros da base.....Feito"  );
            //inserindo nome da coluna 
            excelSheet.addCell( new Label( 0 , row, this.getCod() , cf ) );
            excelSheet.addCell( new Label( 1 , row, this.getId(), cf ) );
            excelSheet.addCell( new Label( 2 , row, this.getEmpresa() , cf ) );
            excelSheet.addCell( new Label( 3 , row, this.getParaQuem() , cf ) );
            excelSheet.addCell( new Label( 4 , row, this.getData() , cf ) );
            excelSheet.addCell( new Label( 5 , row, this.getEntreguePor()  , cf ) );
            excelSheet.addCell( new Label( 6 , row, this.getHistorico() , cf ) );
            excelSheet.addCell( new Label( 7 , row, this.getRecebidoPor() , cf ) );
            excelSheet.addCell( new Label( 8 , row, this.getObservacao()  , cf ) );
            //pulando a primeira linha reservada para o nome da coluna
            row=1;
            while(res.next())
              {
                  Number cod = new Number( 0 , row, res.getDouble("cod" ) , cf );
                  Number id = new Number( 1 , row, res.getDouble("ID" ) , cf );
                  Label empresa  = new Label( 2 , row, res.getString( "Empresa" ) , cf );                  
                  Label para_quem= new Label( 3 , row, res.getString( "Para_Quem" ) , cf );                  
                  Label data= new Label( 4 , row, res.getString( "Data_Recebimento" ) , cf );
                  Label entreguepor= new Label( 5 , row, res.getString( "Quem_Entregou" )  , cf );     
                  Label historico= new Label( 6 , row, res.getString( "Historico" ) , cf );                  
                  Label quem_recebeu= new Label( 7 , row, res.getString( "Quem_Recebeu" ) , cf );
                  Label observacao= new Label( 8 , row, res.getString( "Observacao" )  , cf ); 
                  row ++;                  
                 
                  try {
                     excelSheet.addCell( cod );
                     excelSheet.addCell( id );
                     excelSheet.addCell( empresa );
                     excelSheet.addCell( para_quem );
                     excelSheet.addCell( data );
                     excelSheet.addCell( entreguepor );
                     excelSheet.addCell( historico );
                     excelSheet.addCell( quem_recebeu );
                     excelSheet.addCell( observacao );
                 } catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
              }
             res.close();         
         }catch( SQLException | WriteException e ){
            System.err.println( e.getMessage() );
        }
        //escrevendo o arquivo em disco
        try {
            workbook.write();
            workbook.close();
            System.out.println(  "Escrevendo o arquivo em disco....Feito"  );         
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar o arquivo!\n"
                    + "Tente salvar em outro local\n\n"+ex);
            //System.err.println(  ex.getMessage() );
        }
        catch (WriteException ex) {
           System.err.println(  ex.getMessage() );
        }
        
        System.out.println(  "Proceso completado...."  );
    }
    
    public static void main(String[] args) {
        new ListagemExcel().openFileChooser();
    }
    
    public String getEmpresa(){
        return empresa;
    }

    /**
     * @return the paraQuem
     */
    public String getParaQuem() {
        return paraQuem;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @return the entreguePor
     */
    public String getEntreguePor() {
        return entreguePor;
    }

    /**
     * @return the recebidoPor
     */
    public String getRecebidoPor() {
        return recebidoPor;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }
    public String getComando() {
      return comando;
    }

    /**
     * @param comando the comando to set
     */
    public void setComando(String comando) {
        this.comando = comando;
    }

}
