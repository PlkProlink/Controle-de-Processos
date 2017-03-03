package br.com.prolink.recepcao;


import java.io.File;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class AvisoEmail {

    public static void main(String[] args){
    }
    public boolean enviaAlerta(String aux, String hora, String cliente, String idCliente, String conta, String user, String mensagem){
    
    HtmlEmail email = new HtmlEmail();
    email.setHostName( "smtp.prolinkcontabil.com.br" );
    email.setSmtpPort(587);//tentei com o gmail mas nao consegui
//    email.setContent("mail.smtp.socketFactory.port", "465")
//    email.setContent("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    email.setSslSmtpPort( "465" );
//    email.setStartTLSRequired(true);
//    email.setSSLOnConnect(true);
    
    email.setAuthenticator( new DefaultAuthenticator( "documentos@prolinkcontabil.com.br" ,  "l!nk2016Cont" ) );
    
    try {
        email.setFrom( "documentos@prolinkcontabil.com.br" , "Documentos");
        //email.setDebug(true); 
        email.setSubject( idCliente+" - Oi "+user+", Tem um Novo Documento Aguardando Sua Atenção" );

        String idArquivo = email.embed(new File("robot.png"));
        
        StringBuilder builder = new StringBuilder();

        builder.append("<p>" +
"			<span style=\"font-family:arial,helvetica,sans-serif;\"><span style=\"color:#0000cd;\"><strong>Ola ").append(user).append(";</strong></span></span></p>" +
"		<div style=\"text-align: left;\">&nbsp;</div>" +
"		<div style=\"text-align: left;\">" +
"			<span style=\"font-family:arial,helvetica,sans-serif;\">Tem um novo documento que acabou de chegar para voc&ecirc;;</span></div>" +
"		<div style=\"text-align: left;\">&nbsp;</div>" +
"		<div style=\"text-align: left;\">" +
"			<span style=\"font-family:arial,helvetica,sans-serif;\">").append(aux).append("</span></div>" +
"		<div style=\"text-align: left;\">&nbsp;</div>" +
"		<div style=\"text-align: left;\">" +
"			<span style=\"font-family:arial,helvetica,sans-serif;\">Antes de mostrar os detalhes preciso que voc&ecirc; valide o recebimento no Controle de Processos, certo?</span></div>" +
"		<div style=\"text-align: left;\">" +
"			<span style=\"font-family:arial,helvetica,sans-serif;\">E mesmo que n&atilde;o seja seu ou n&atilde;o receba &eacute; possivel Contestar a entrega (Op&ccedil;&atilde;o Constestar), f&aacute;cil...</span></div>" +
"		<div style=\"text-align: left;\">&nbsp;</div>" +
"		<div style=\"text-align: left;\">" +
"			<span style=\"font-family:arial,helvetica,sans-serif;\">Vamos l&aacute;:</span></div>" +
"		<div style=\"text-align: left;\">&nbsp;</div>" +
"		<div style=\"text-align: left;\">" +
"			<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 500px\">" +
"				<thead>" +
"					<tr>" +
"						<th scope=\"col\">" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">Hora da Entrada</span></th>" +
"						<th scope=\"col\">" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">ID Cliente</span></th>" +
"						<th scope=\"col\">" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">Nome</span></th>" +
"						<th scope=\"col\">" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">Detalhes</span></th>" +
"					</tr>" +
"				</thead>" +
"				<tbody>" +
"					<tr>" +
"						<td>" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">").append(hora).append("</span></td>" +
"						<td>" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">").append(idCliente).append("</span></td>" +
"						<td>" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">").append(cliente).append("</span></td>" +
"						<td>" +
"							<span style=\"font-family:arial,helvetica,sans-serif;\">").append(mensagem).append("</span></td>" +
"					</tr>" +
"				</tbody>" +
"			</table>" +
"		</div>" +
"		<p>&nbsp;</p>" +
"		<p><span style=\"font-family:arial,helvetica,sans-serif;\"><em style=\"color: rgb(169, 169, 169);\">***Ah! Outra coisa...n&atilde;o responde esse e-mail por favor. Tudo isso &eacute; autom&aacute;tico***</em></span></p>");
        
        email.setHtmlMsg( builder.toString()+"");
        
        email.addTo(conta);
        email.send();
        
        System.out.println("Sucesso!");
        return true;
    } catch (EmailException e) {
        JOptionPane.showMessageDialog(null, "Falha ao enviar o email!"+e);
        return false;
    } 
    }
}