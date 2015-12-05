/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos;

import br.com.prolink.inicio.*;
/**
 *
 * @author Tiago Dias
 */
public class DocumentosDao {
    
    Conexao con = new Conexao();
    
    private String processo=Ativador.processo;

    public void tudo(){
        afastamentos();
        ato();
        balancete();
        balanco();
        caged();
        comSocios();
        contas();
        darf();
        docSocios();
        ferias();
        funcionarios();
        hab();
        inss();
        pisSocio();
        plano();
        posto();
        prefeitura();
        receita();
        recisoes();
        sefip();
        simples();
        sindical();
        termo();
        folha();

}
    public void afastamentos(){
    
    Documentos.lbAfastamentos1.setText("");
    Documentos.lbAfastamentos2.setText("");
    Documentos.lbAfastamentos3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from afastamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbAfastamentos1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbAfastamentos2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbAfastamentos3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }
}

    public void ato() {
    Documentos.lbAto1.setText("");
    Documentos.lbAto2.setText("");
    Documentos.lbAto3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from atoconstitutivo where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbAto1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbAto2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbAto3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }
    }

    public void balancete() {
    Documentos.lbBalancete1.setText("");
    Documentos.lbBalancete2.setText("");
    Documentos.lbBalancete3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from balanceteexercicio where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalancete1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalancete2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbBalancete3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void balanco() {
    Documentos.lbBalanco1.setText("");
    Documentos.lbBalanco2.setText("");
    Documentos.lbBalanco3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from balancodre where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalanco1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalanco2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbBalanco3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void caged() {
    Documentos.lbCaged1.setText("");
    Documentos.lbCaged2.setText("");
    Documentos.lbCaged3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from caged where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbCaged1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbCaged2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbCaged3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void comSocios() {
    Documentos.lbComp1.setText("");
    Documentos.lbComp2.setText("");
    Documentos.lbComp3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from comprovanteresidencia where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbComp1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbComp2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbComp3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void contas() {
    Documentos.lbContas1.setText("");
    Documentos.lbContas2.setText("");
    Documentos.lbContas3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from composicaodecontaspatrimoniais where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbContas1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbContas2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbContas3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void darf() {
    Documentos.lbDarf1.setText("");
    Documentos.lbDarf2.setText("");
    Documentos.lbDarf3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from guiasdarfgpsfgts where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbDarf1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbDarf2.setText(ndata2);
            }
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbDarf3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void docSocios() {
    Documentos.lbComp1.setText("");
    Documentos.lbComp2.setText("");
    Documentos.lbComp3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from rgecpfsocio where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbComp1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbComp2.setText(ndata2);
            }
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbComp3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void ferias() {
    Documentos.lbFerias1.setText("");
    Documentos.lbFerias2.setText("");
    Documentos.lbFerias3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from ferias where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbFerias1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbFerias2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbFerias3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void funcionarios() {
    Documentos.lbFuncionarios1.setText("");
    Documentos.lbFuncionarios2.setText("");
    Documentos.lbFuncionarios3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from livrooufichaderegistrofuncionario where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbFuncionarios1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbFuncionarios2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbFuncionarios3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void hab() {
    Documentos.lbHab1.setText("");
    Documentos.lbHab2.setText("");
    Documentos.lbHab3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from autorizacaonotafiscaleletronica where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbHab1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbHab2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbHab3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }    
    
    public void inss() {
    Documentos.lbInss1.setText("");
    Documentos.lbInss2.setText("");
    Documentos.lbInss3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from senhainss where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbInss1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbInss2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbInss3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }
    
    public void pisSocio() {
    Documentos.lbPis1.setText("");
    Documentos.lbPis2.setText("");
    Documentos.lbPis3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from numeropis where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPis1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPis2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbPis3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void plano() {
    Documentos.lbPlano1.setText("");
    Documentos.lbPlano2.setText("");
    Documentos.lbPlano3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from planodecontas where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPlano1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPlano2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbPlano3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void posto() {
    Documentos.lbPosto1.setText("");
    Documentos.lbPosto2.setText("");
    Documentos.lbPosto3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from senhapostofiscal where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPosto1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPosto2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbPosto3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void prefeitura() {
    Documentos.lbPrefeitura1.setText("");
    Documentos.lbPrefeitura2.setText("");
    Documentos.lbPrefeitura3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from configurarperfilfiscalnositeprefeituradocumento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPrefeitura1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPrefeitura2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
               Documentos.lbPrefeitura3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void receita() {
    Documentos.lbReceita1.setText("");
    Documentos.lbReceita2.setText("");
    Documentos.lbReceita3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from outorgasenhaeletronicareceita where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbReceita1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbReceita2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbReceita3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void recisoes() {
    Documentos.lbRecisoes1.setText("");
    Documentos.lbRecisoes2.setText("");
    Documentos.lbRecisoes3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from recisao where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbRecisoes1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbRecisoes2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbRecisoes3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void sefip() {
    Documentos.lbSefip1.setText("");
    Documentos.lbSefip2.setText("");
    Documentos.lbSefip3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from sefip where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbSefip1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbSefip2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbSefip3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void simples() {
    Documentos.lbSimples1.setText("");
    Documentos.lbSimples2.setText("");
    Documentos.lbSimples3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from senhasimplesnacional where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbSimples1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbSimples2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbSimples3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    public void sindical() {
    Documentos.lbSindical1.setText("");
    Documentos.lbSindical2.setText("");
    Documentos.lbSindical3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from guiasindical where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbSindical1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbSindical2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
               Documentos.lbSindical3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }    

    public void termo() {
    Documentos.lbTermo1.setText("");
    Documentos.lbTermo2.setText("");
    Documentos.lbTermo3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from termoderesponsabilidadedocumento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbTermo1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbTermo2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbTermo3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }
    
    public void folha(){
    Documentos.lbFolha1.setText("");
    Documentos.lbFolha2.setText("");
    Documentos.lbFolha3.setText("");
    
    con.conecta();
    try{
        con.executeSQL("select * from folhadepagamentodocumento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbFolha1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbFolha2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbFolha3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }
    }    
}