
import br.com.prolink.inicio.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.*;
import jxl.write.Label;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class ExportToExcel {
    
    Conexao con = new Conexao();
    
    public static void main(String[] args){
        new ExportToExcel();
    }
    public ExportToExcel(){
            ExportToExcel();
    }
    public void ExportToExcel(){
        
        
        File file = new File("H:\\RegistroMysql.xls");
        
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
        } catch (IOException ex) {
            Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        workbook.createSheet( "documentos recebidos", 0 );
        excelSheet = workbook.getSheet(0);
        System.out.println(  "creando hoja excel.....Listo"  );
        
        //Consulta SQL 
        String sql = "SELECT * from documentos_recebidos";
         try{
             con.executeSQL(sql);
             System.out.println(  "obteniendo registros.....Listo"  );
              while(con.resultset.next())
              {
                  Label id= new Label(0 ,row, con.resultset.getString( "ID" ) , cf );
                  Label empresa = new Label(1 ,row, con.resultset.getString( "Empresa" )  , cf );
                  Label para_quem = new Label(2, row, con.resultset.getString( "Para_Quem" ) , cf );
                  Label data  = new Label(4, row , con.resultset.getString( "Data_Recebimento" ) , cf );                  
                  Label entreguepor= new Label( 5,row, con.resultset.getString( "Quem_Entregou" ) , cf );                  
                  Label historico = new Label(6, row, con.resultset.getString( "Historico" )  , cf );
                  Label quem_recebeu= new Label(7 ,row, con.resultset.getString( "Quem_Recebeu" )  , cf );
                  Label observacao= new Label(8, row, con.resultset.getString( "Observacao" )  , cf );
                  row ++;                  
                 try {
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
             con.desconecta();         
         }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
         
        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println(  "Escribiendo en disco....Listo"  );         
        }
        catch (WriteException ex) {
           System.err.println(  ex.getMessage() );
        } catch (IOException ex) {
            System.err.println(  ex.getMessage() );
        }
        
        System.out.println(  "Proceso completado...."  );
    }
}
