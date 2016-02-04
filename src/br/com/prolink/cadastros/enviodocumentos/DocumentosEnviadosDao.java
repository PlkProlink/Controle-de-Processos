/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.cadastros.enviodocumentos;

import br.com.prolink.inicio.*;
/**
 *
 * @author Tiago Dias
 */
public class DocumentosEnviadosDao {
    
    Conexao con = new Conexao();
    
    private String processo=Ativador.processo;

public void tudo(){
        boleto();
        cofins();
        csll();
        das();
        fgts();
        gps();
        icms();
        icms_servico();
        ipi();
        irpf_salario();
        irpf_servico();
        irpj();
        iss();    

}
public void boleto(){
    
    DocumentosEnviados.lbBol1.setText("");
    DocumentosEnviados.lbBol2.setText("");
    DocumentosEnviados.lbBol3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from boletoplkacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbBol1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbBol2.setText(ndata2);
            }
         
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                DocumentosEnviados.lbBol3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void das(){
    
    DocumentosEnviados.lbDas1.setText("");
    DocumentosEnviados.lbDas2.setText("");
    DocumentosEnviados.lbDas3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from dasacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbDas1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbDas2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbDas3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void cofins(){
    
    DocumentosEnviados.lbCofins1.setText("");
    DocumentosEnviados.lbCofins2.setText("");
    DocumentosEnviados.lbCofins3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from pisacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbCofins1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbCofins2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbCofins3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void irpj(){

    DocumentosEnviados.lbIrpj1.setText("");
    DocumentosEnviados.lbIrpj2.setText("");
    DocumentosEnviados.lbIrpj3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from irpjacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpj1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpj2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpj3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void csll(){
    
    DocumentosEnviados.lbCsll1.setText("");
    DocumentosEnviados.lbCsll2.setText("");
    DocumentosEnviados.lbCsll3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from csllacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbCsll1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbCsll2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbCsll3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void iss(){
    
    DocumentosEnviados.lbIss1.setText("");
    DocumentosEnviados.lbIss2.setText("");
    DocumentosEnviados.lbIss3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from issacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIss1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIss2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIss3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void gps(){
    
    DocumentosEnviados.lbGps1.setText("");
    DocumentosEnviados.lbGps2.setText("");
    DocumentosEnviados.lbGps3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from gpsacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbGps1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbGps2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbGps3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void irpf_salario(){
    
    DocumentosEnviados.lbIrpfSal1.setText("");
    DocumentosEnviados.lbIrpfSal2.setText("");
    DocumentosEnviados.lbIrpfSal3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from irpfsobresalarioacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpfSal1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpfSal2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpfSal3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void irpf_servico(){
    
    DocumentosEnviados.lbIrpfServ1.setText("");
    DocumentosEnviados.lbIrpfServ2.setText("");
    DocumentosEnviados.lbIrpfServ3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from irpfsobreservicotomadoacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpfServ1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpfServ2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIrpfServ3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void fgts(){
    
    DocumentosEnviados.lbFgts1.setText("");
    DocumentosEnviados.lbFgts2.setText("");
    DocumentosEnviados.lbFgts3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from fgtsacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbFgts1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbFgts2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbFgts3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void icms(){
    
    DocumentosEnviados.lbIcms1.setText("");
    DocumentosEnviados.lbIcms2.setText("");
    DocumentosEnviados.lbIcms3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from icmsacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIcms1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIcms2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIcms3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void ipi(){
    
    DocumentosEnviados.lbIpi1.setText("");
    DocumentosEnviados.lbIpi2.setText("");
    DocumentosEnviados.lbIpi3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from ipiacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIpi1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIpi2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIpi3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}
public void icms_servico(){
    
    DocumentosEnviados.lbIcmsServ1.setText("");
    DocumentosEnviados.lbIcmsServ2.setText("");
    DocumentosEnviados.lbIcmsServ3.setText("");

    con.conecta();
    try{
        con.executeSQL("select * from icmsservtomacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIcmsServ1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIcmsServ2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                DocumentosEnviados.lbIcmsServ3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
    con.desconecta();
}

}
