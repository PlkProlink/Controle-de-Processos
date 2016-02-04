/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

/**
 *
 * @author Tiago
 */
public class teste extends DocumentosIntModelo{
    
    public teste(){
        super.inicializacao("teste", "atoconstitutivo", "");
        conexao.conecta();
        conexao.executeSQL("select * from "+tabela+" where NumeroProcesso='48'");
        try{
            while(conexao.resultset.next()){
                System.out.println(conexao.resultset.getString("Cod"));
                System.out.println(conexao.resultset.getString("DatadeCadastroAndamento"));
                System.out.println( conexao.resultset.getString("DataDevulucaoCliente"));
                System.out.println(conexao.resultset.getString("DataFinalAndamento"));
                System.out.println(conexao.resultset.getString("Obsevacao"));
                System.out.println(conexao.resultset.getString("Usuario"));
            }
        }catch(Exception e){
            
        }
        conexao.desconecta();
        
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new teste();
    }
}
