/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Tiago
 */
public class Describle {
    public static void main(String[] args) throws SQLException, IOException{
        Connection con = new ConexaoStatement().getConnetion();
        File file = new File("c:/temp/describle.txt");
        
        
        List<String> table_names = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("show tables");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            table_names.add(rs.getString(1));
        }
        FileWriter writer = new FileWriter(file);
        for (String s : table_names){
            ps=null;
            List<String> colunas = new ArrayList<>();
            ps = con.prepareStatement("show columns from "+s);
            rs = null;
            rs = ps.executeQuery();
            while(rs.next()){
                colunas.add(rs.getString(1));
            }
            for(int i = 0; i<colunas.size(); i++){
                String value = null;
                if(i==0){
                    value = System.getProperty("line.separator")+"public final String "+s.toUpperCase()+"=\""+s+"\";";
                    value += System.getProperty("line.separator")+"public final String "+s.toUpperCase()+"_"+colunas.get(i)+"=\""+colunas.get(i)+"\";";
                }
                else{
                    value = "public final String "+s.toUpperCase()+"_"+colunas.get(i)+"=\""+colunas.get(i)+"\";";
                }
                writer.write(value);
                writer.write(System.getProperty("line.separator"));
            }
            String valor = "<!DOCTYPE html>\n" +
"<html>\n" +
"	<head>\n" +
"		<title></title>\n" +
"		<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\" />\n" +
"	</head>\n" +
"	<body id=\"cke_pastebin\" style=\"margin: 22px 10px 10px;\">\n" +
"		<div style=\"text-align: center;\">\n" +
"			<div style=\"text-align: left;\">\n" +
"				<span style=\"font-size: 18px;\"><span style=\"font-family: &quot;comic sans ms&quot;, cursive;\">Ol&aacute; {usuario.nome};</span></span></div>\n" +
"			<div style=\"text-align: left;\">&nbsp;</div>\n" +
"			<div style=\"text-align: left;\">\n" +
"				<span style=\"font-size: 18px;\"><span style=\"font-family: &quot;comic sans ms&quot;, cursive;\">A(s) seguinte(s) tarefa(s) esta(ao) vencendo.</span></span></div>\n" +
"			<div style=\"text-align: left;\">nbsp;</div>\n" +
"		</div>\n" +
"		<div style=\"text-align: center;\">\n" +
"			<table align=\"left\" border=\"2\" cellpadding=\"2\" cellspacing=\"0\" height=\"130\" width=\"900\">\n" +
"				<thead>\n" +
"					<tr>\n" +
"						<th scope=\"row\" style=\"background-color: rgb(255, 153, 0); width: 10%;\">\n" +
"							<span style=\"color:#ffffff;\"><font face=\"comic sans ms, cursive\">N&uacute;mero</font></span></th>\n" +
"						<th scope=\"row\" style=\"background-color: rgb(255, 153, 0); width: 10%;\">\n" +
"							<span style=\"color:#ffffff;\"><span style=\"font-family: comic sans ms,cursive;\">Data</span></span></th>\n" +
"						<th colspan=\"3\" scope=\"col\" style=\"background-color: rgb(255, 153, 0); width: 10%;\">\n" +
"							<span style=\"color:#ffffff;\"><span style=\"font-family: comic sans ms,cursive;\">Refer&ecirc;ncia</span></span></th>\n" +
"						<th scope=\"col\" style=\"background-color: rgb(255, 153, 0); width: 10%;\">\n" +
"							<span style=\"color:#fff0f5;\"><span style=\"font-family: comic sans ms,cursive;\">Tipo</span></span></th>\n" +
"						<th scope=\"col\" style=\"background-color: rgb(255, 153, 0); width: 10%;\">\n" +
"							<span style=\"color:#fff0f5;\"><span style=\"font-family: comic sans ms,cursive;\">Descri&ccedil;&atilde;o</span></span></th>\n" +
"					</tr>\n" +
"				</thead>\n" +
"				<tbody>\n" +
"					<tr>\n" +
"						<th scope=\"row\" style=\"background-color: rgb(255, 255, 204); width: 5%;\">\n" +
"							<span style=\"color:#ff8c00;\"><font face=\"comic sans ms, cursive\"><span style=\"font-size: 14px;\">3</span></font></span></th>\n" +
"						<th scope=\"row\" style=\"background-color: rgb(255, 255, 204); width: 10%;\">\n" +
"							<span style=\"color:#ff0000;\"><font face=\"comic sans ms, cursive\"><span style=\"font-size: 14px;\">17/04/2017 as 11:10</span></font></span></th>\n" +
"						<th style=\"background-color: rgb(255, 255, 204); width: 5%;\">\n" +
"							<span style=\"color:#ff8c00;\"><span style=\"font-size: 14px;\"><font face=\"comic sans ms, cursive\">2407</font></span></span></th>\n" +
"						<th style=\"background-color: rgb(255, 255, 204); width: 5%;\">\n" +
"							<span style=\"color:#ff8c00;\"><span style=\"font-size: 14px;\"><font face=\"comic sans ms, cursive\">Negocio</font></span></span></th>\n" +
"						<th style=\"background-color: rgb(255, 255, 204); width: 20%;\">\n" +
"							<span style=\"color:#ff8c00;\"><span style=\"font-size: 14px;\"><span style=\"font-family: comic sans ms,cursive;\">JANALICE VASCONCELOS</span></span></span></th>\n" +
"						<th style=\"background-color: rgb(255, 255, 204); width: 5%;\">\n" +
"							<p><span style=\"color:#ff8c00;\"><span style=\"font-family: comic sans ms,cursive;\"><strong><span style=\"font-size: 14px;\">Liga&ccedil;&atilde;o</span></strong></span></span></p>\n" +
"						</th>\n" +
"						<th style=\"background-color: rgb(255, 255, 204); width: 50%;\">\n" +
"							<p><span style=\"color:#ff8c00;\"><font face=\"comic sans ms, cursive\"><span style=\"font-size: 14px;\">Ligar Para contato</span></font></span></p>\n" +
"						</th>\n" +
"					</tr>\n" +
"				</tbody>\n" +
"			</table>\n" +
"		</div>\n" +
"		<div style=\"text-align: left;\">&nbsp;</div>\n" +
"		<div style=\"text-align: left;\">&nbsp;</div>\n" +
"		<p>&nbsp;</p>\n" +
"		<p>&nbsp;</p>\n" +
"		<p>&nbsp;</p>\n" +
"		<p><span style=\"color:#d3d3d3;\"><span style=\"font-family:comic sans ms,cursive;\">Esse aviso &eacute; gerado automaticamente</span></span></p>\n" +
"		<p>&nbsp;</p>\n" +
"		<p><span style=\"color:#d3d3d3;\"><span style=\"font-family:comic sans ms,cursive;\"><img alt=\"\" src=\"http://prolinkvip.prolinkcontabil.com.br/uploadimages/prolinkvip.prolinkcontabil.com.br/assinatura_email_prolink(1).gif\" style=\"width: 365px; height: 123px; float: left;\" /></span></span></p>\n" +
"	</body>\n" +
"</html>";
        }
        writer.flush();
        con.close();
        System.exit(0);
    }
}
