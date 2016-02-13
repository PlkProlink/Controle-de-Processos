
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class testehora {
    public static void main(String[] args){
//        Date date = new Date();
//        SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
//        String hora = sh.format(date);
//        
//        System.out.println(hora);
//        
//        String horaf = hora.substring(0, 2);
//        String minuto = hora.substring(3, 5);
//        
//        System.out.print(horaf+":"+minuto);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        
        Date data2 = new Date();
        
        
        String datarec = sdf.format(data2);
        
        try {
            Date datarec2 = sdf.parse(datarec);
            System.out.println(new java.sql.Date(data2.getTime())+"/n"+datarec2);
        } catch (ParseException ex) {
            Logger.getLogger(testehora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        
//        String s="wetrtyyu";
//        int pos=s.indexOf("yyu");
//        System.out.print(pos);
        
    }
}
