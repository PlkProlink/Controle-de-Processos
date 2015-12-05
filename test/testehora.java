
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date date = new Date();
        SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
        String hora = sh.format(date);
        
        System.out.println(hora);
        
        String horaf = hora.substring(0, 2);
        String minuto = hora.substring(3, 5);
        
        System.out.print(horaf+":"+minuto);
    }
}
