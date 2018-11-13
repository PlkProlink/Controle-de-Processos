package br.com.prolink.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Tiago Dias
 */
public class Calendario{

    String mes, dia, ano, dia_semana, hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");
    
    /**
     *
     */
    public void lerHora()
    {
        Date horaAtual = new Date();
        hora = horaformatada.format(horaAtual);
    }
    
    /**
     *
     */
    public void lerData()
    {
        Calendar calendar = Calendar.getInstance();
             
        mes = ""; //return 0 a 11
        dia = ""+calendar.get(Calendar.DAY_OF_MONTH);   
        ano = ""+calendar.get(Calendar.YEAR);
        dia_semana = "";
        
        switch(calendar.get(Calendar.MONTH))
        {
            case 0: mes="Janeiro"; break;
            case 1: mes="Fevereiro"; break;
            case 2: mes="Março"; break;
            case 3: mes="Abril"; break;
            case 4: mes="Maio"; break;
            case 5: mes="Junho"; break;
            case 6: mes="Julho"; break;
            case 7: mes="Agosto"; break;
            case 8: mes="Setembro"; break;
            case 9: mes="Outubro"; break;
            case 10: mes="Novembro"; break;
            case 11: mes="Dezembro"; break;
            default: break;
        }
        switch(calendar.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.SUNDAY: dia_semana="Domingo"; break;
            case Calendar.MONDAY: dia_semana="Segunda"; break;
            case Calendar.TUESDAY: dia_semana="Terça"; break;
            case Calendar.WEDNESDAY: dia_semana="Quarta"; break;
            case Calendar.THURSDAY: dia_semana="Quinta"; break;
            case Calendar.FRIDAY: dia_semana="Sexta"; break;
            case Calendar.SATURDAY: dia_semana="Sábado"; break;
            default: break;    
        }
    }
   
}