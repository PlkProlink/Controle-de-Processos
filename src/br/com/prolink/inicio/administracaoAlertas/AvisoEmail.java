package br.com.prolink.inicio.administracaoAlertas;


import br.com.prolink.login.Login;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import sun.nio.cs.ext.ISO_8859_11;

public class AvisoEmail {

    public static void main(String[] args){
    }
    public boolean enviaAlerta(String conta, String usuario, String departamento, String tabelaContador, String tabelaDepartamento, String tabelaDocumentos, int total){
    
    HtmlEmail email = new HtmlEmail();
    email.setHostName( "smtp.prolinkcontabil.com.br" );
    email.setSmtpPort(587);
//tentei com o gmail mas nao consegui se nao desativar o antivirus
//    email.setContent("mail.smtp.socketFactory.port", "465")
//    email.setContent("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    email.setSslSmtpPort( "465" );
//    email.setStartTLSRequired(true);
//    email.setSSLOnConnect(true);
    
    email.setAuthenticator( new DefaultAuthenticator( "documentos@grupoprolink.com.br" ,  "l!nk2016Cont" ) );
    
    try {
        email.setFrom( "documentos@grupoprolink.com.br" , "Controle de Processsos - Implantação");
        email.setDebug(true); 
        
        String subject = new String(("Prolink - Implantação de Cliente - "+usuario+", estamos aguardando sua interação").getBytes(), "UTF-8");
        
        email.setSubject(subject);
        
        StringBuilder builder = new StringBuilder();

        builder.append("<body><div style=\"text-align: left;\"><p><strong>Ol&aacute; ").append(usuario).append(";</strong><br />\n" +
"				<br />Nesse momento foi disparado para voc&ecirc; uma cobra&ccedil;a de valida&ccedil;&otilde;es dentro do sistema Controle de Processo por ").append(Login.usuario).append(";</p>\n" +
"			<ul><li>Para validar o controle do seu departamento utilize a guia Implanta&ccedil;&atilde;o&gt;").append(departamento).append(".</li>\n" +
"			<li>Para validar os documentos de Implanta&ccedil;&atilde;o use a guia Implanta&ccedil;&atilde;o&gt;Documentos Recebidos.</li></ul>\n" +
"			<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 800px\">\n" +
"				<caption style=\"text-align: center;\"><br /><strong>Quantidade de Valida&ccedil;&otilde;es Pendentes do Departamento ").append(departamento).append("</strong></caption>\n" +
"				<thead><tr><th scope=\"col\" style=\"text-align: center;\"><strong>ID</strong></th>\n" +
"						<th scope=\"col\" style=\"text-align: center;\"><strong>Nome</strong></th>\n" +
"						<th scope=\"col\" style=\"text-align: center;\"><strong>Controle do Departamento</strong></th>\n" +
"						<th scope=\"col\" style=\"text-align: center;\"><strong>Documentos Recebidos de Implanta&ccedil;&atilde;o</strong></th></tr></thead>\n" +
"				<tbody>").append(tabelaContador).append("\n" +
"					<tr><td><strong></strong></td><td><strong></strong></td><td><strong>Total</strong></td><td style=\"text-align: center;\">").append(total).append("</td></tr>\n" +
"				</tbody>\n" +
"			</table><p>&nbsp;</p>\n" +
"			<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 800px\">\n" +
"				<caption><br /><br /><strong><strong>Detalhes do Controle do Departamento</strong></strong></caption>\n" +
"				<thead><tr>\n" +
"						<th scope=\"col\" style=\"text-align: center;\"><strong>ID</strong></th>\n" +
"						<th scope=\"col\" style=\"text-align: center;\"><strong>Nome</strong></th>\n" +
"						<th scope=\"col\" style=\"text-align: center;\"><strong>Controle em Aberto</strong></th></tr>\n" +
"				</thead>\n" +
"				<tbody>").append(tabelaDepartamento).append("\n" +
"					</tbody>\n" +
"			</table><p>&nbsp;</p>\n" +
"		<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 800px;\">\n" +
"			<caption>\n" +
"				<strong>Detalhes dos Documentos Recebidos - Pend&ecirc;ncias de Valida&ccedil;&atilde;o do ").append(departamento).append("</strong></caption>\n" +
"			<thead><tr>\n" +
"					<th scope=\"col\" style=\"text-align: center;\"><strong>ID</strong></th>\n" +
"					<th scope=\"col\" style=\"text-align: center;\"><strong>Nome</strong></th>\n" +
"					<th scope=\"col\" style=\"text-align: center;\">Valida&ccedil;&atilde;o em Aberto</th>\n" +
"				</tr></thead>\n" +
"			<tbody>").append(tabelaDocumentos).append("</tbody>\n" +
"		</table></div>\n" +
"		<p>&nbsp;</p><p><span style=\"color:#a9a9a9;\">***N&atilde;o h&aacute; necessidade de responder esse e-mail***</span></p>\n" +
"		<p><span style=\"color: rgb(169, 169, 169);\">***Todos os direitos reservados a Prolink***</span></p></body>");
        
        email.setHtmlMsg( builder.toString()+"");
        
        email.addTo(conta);
        email.send();
        
        System.out.println("Sucesso!");
        return true;
    } catch (EmailException e) {
        JOptionPane.showMessageDialog(null, "Falha ao enviar o email!"+e);
        return false;
    } catch (UnsupportedEncodingException ex) { 
        JOptionPane.showMessageDialog(null,"Falha ao criar o assunto da mensagem"+ex);
        return false;
    } 
    }
}