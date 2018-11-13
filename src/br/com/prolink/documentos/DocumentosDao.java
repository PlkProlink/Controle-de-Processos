/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos;

import br.com.prolink.factory.Conexao;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Tiago Dias
 */
public class DocumentosDao {
    Connection con;
    private Connection getConnection(){
        this.con = ConexaoStatement.getInstance().getConnetion();
        return this.con;
    }
    Processo p = ProcessoLogado.getInstance().getProcesso();
    String processo=p.getId()+"";

    public void tudo(){
        afastamentos();
        ato();
        balancete();
        balanco();
        caged();
        comSocios();
        contas();
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
        simples();
        termo();
        folha();

}
    public void afastamentos(){
    
    Documentos.lbAfastamentos1.setText("");
    Documentos.lbAfastamentos2.setText("");
    Documentos.lbAfastamentos3.setText("");
    
    
    try{
        String sql = ("select * from afastamento where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbAfastamentos1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbAfastamentos2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbAfastamentos3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
}

    public void ato() {
    Documentos.lbAto1.setText("");
    Documentos.lbAto2.setText("");
    Documentos.lbAto3.setText("");
    
    
    try{
        String sql = ("select * from atoconstitutivo where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbAto1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbAto2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbAto3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void balancete() {
    Documentos.lbBalancete1.setText("");
    Documentos.lbBalancete2.setText("");
    Documentos.lbBalancete3.setText("");
    
    
    try{
        String sql = ("select * from balanceteexercicio where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalancete1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalancete2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbBalancete3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void balanco() {
    Documentos.lbBalanco1.setText("");
    Documentos.lbBalanco2.setText("");
    Documentos.lbBalanco3.setText("");
    
    
    try{
        String sql = ("select * from balancodre where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalanco1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbBalanco2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbBalanco3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void caged() {
    Documentos.lbCaged1.setText("");
    Documentos.lbCaged2.setText("");
    Documentos.lbCaged3.setText("");
    
    
    try{
        String sql = ("select * from caged where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbCaged1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbCaged2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbCaged3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void comSocios() {
    Documentos.lbComp1.setText("");
    Documentos.lbComp2.setText("");
    Documentos.lbComp3.setText("");
    
    
    try{
        String sql = ("select * from comprovanteresidencia where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbComp1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbComp2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbComp3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void contas() {
    Documentos.lbContas1.setText("");
    Documentos.lbContas2.setText("");
    Documentos.lbContas3.setText("");
    
    
    try{
        String sql = ("select * from composicaodecontaspatrimoniais where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbContas1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbContas2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbContas3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void docSocios() {
    Documentos.lbDoc1.setText("");
    Documentos.lbDoc2.setText("");
    Documentos.lbDoc3.setText("");
    
    
    try{
        String sql = ("select * from rgecpfsocio where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbDoc1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbDoc2.setText(ndata2);
            }
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbDoc3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }  finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }  
    
    }

    public void ferias() {
    Documentos.lbFerias1.setText("");
    Documentos.lbFerias2.setText("");
    Documentos.lbFerias3.setText("");
    
    
    try{
        String sql = ("select * from ferias where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbFerias1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbFerias2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                Documentos.lbFerias3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void funcionarios() {
    Documentos.lbFuncionarios1.setText("");
    Documentos.lbFuncionarios2.setText("");
    Documentos.lbFuncionarios3.setText("");
    
    
    try{
        String sql = ("select * from livrooufichaderegistrofuncionario where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbFuncionarios1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbFuncionarios2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbFuncionarios3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void hab() {
    Documentos.lbHab1.setText("");
    Documentos.lbHab2.setText("");
    Documentos.lbHab3.setText("");
    
    
    try{
        String sql = ("select * from autorizacaonotafiscaleletronica where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbHab1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbHab2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbHab3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }    
    
    public void inss() {
    Documentos.lbInss1.setText("");
    Documentos.lbInss2.setText("");
    Documentos.lbInss3.setText("");
    
    
    try{
        String sql = ("select * from senhainss where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbInss1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbInss2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbInss3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }
    
    public void pisSocio() {
    Documentos.lbPis1.setText("");
    Documentos.lbPis2.setText("");
    Documentos.lbPis3.setText("");
    
    
    try{
        String sql = ("select * from numeropis where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPis1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPis2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbPis3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }  finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void plano() {
    Documentos.lbPlano1.setText("");
    Documentos.lbPlano2.setText("");
    Documentos.lbPlano3.setText("");
    
    
    try{
        String sql = ("select * from planodecontas where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPlano1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPlano2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbPlano3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }

    public void posto() {
    Documentos.lbPosto1.setText("");
    Documentos.lbPosto2.setText("");
    Documentos.lbPosto3.setText("");
    
    
    try{
        String sql = ("select * from senhapostofiscal where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPosto1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPosto2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbPosto3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }   finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        } 
    
    }

    public void prefeitura() {
    Documentos.lbPrefeitura1.setText("");
    Documentos.lbPrefeitura2.setText("");
    Documentos.lbPrefeitura3.setText("");
    
    
    try{
        String sql = ("select * from configurarperfilfiscalnositeprefeituradocumento where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbPrefeitura1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbPrefeitura2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
               Documentos.lbPrefeitura3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }    
    
    }

    public void receita() {
    Documentos.lbReceita1.setText("");
    Documentos.lbReceita2.setText("");
    Documentos.lbReceita3.setText("");
    
    
    try{
        String sql = ("select * from outorgasenhaeletronicareceita where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbReceita1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbReceita2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbReceita3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }    
    
    }

    public void recisoes() {
    Documentos.lbRecisoes1.setText("");
    Documentos.lbRecisoes2.setText("");
    Documentos.lbRecisoes3.setText("");
    
    
    try{
        String sql = ("select * from recisao where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbRecisoes1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbRecisoes2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbRecisoes3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }    
    
    }

    public void simples() {
    Documentos.lbSimples1.setText("");
    Documentos.lbSimples2.setText("");
    Documentos.lbSimples3.setText("");
    
    
    try{
        String sql = ("select * from senhasimplesnacional where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbSimples1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbSimples2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbSimples3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }    
    
    }

    public void termo() {
    Documentos.lbTermo1.setText("");
    Documentos.lbTermo2.setText("");
    Documentos.lbTermo3.setText("");
    
    
    try{
        String sql = ("select * from termoderesponsabilidadedocumento where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbTermo1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbTermo2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbTermo3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }    
    
    }
    
    public void folha(){
    Documentos.lbFolha1.setText("");
    Documentos.lbFolha2.setText("");
    Documentos.lbFolha3.setText("");
    
    
    try{
        String sql = ("select * from folhadepagamentodocumento where NumeroProcesso='"+processo+"'");
        PreparedStatement ps = getConnection().prepareStatement(sql);
ResultSet resultset = ps.executeQuery();
        if(resultset.last()){
            
            String data1, data2, data3;
            
            data1 = resultset.getString("DatadeCadastroAndamento");
            data2 = resultset.getString("DataDevulucaoCliente");
            data3 = resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                Documentos.lbFolha1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data2.substring(0, 4);
                String mes = data2.substring(5, 7);
                String dia = data2.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                Documentos.lbFolha2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data3.substring(0, 4);
                String mes = data3.substring(5, 7);
                String dia = data3.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                Documentos.lbFolha3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    
    }    
}