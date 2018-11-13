/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.cadastros;

import java.io.File;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
/**
 *
 * @author User
 */
public class AlertaExclusao {
    
    public static String assunto;
    public static String destino;
    public static String mensagem;
    
    static Properties props = new Properties();
    static Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("prolinkcontabil@gmail.com", "prolink10");
                             }
                        });
    public static void main(String[] args){
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com"); 
            props.put("mail.smtp.auth", "true"); 
            props.put("mail.smtp.port", "465"); 
            props.put("mail.smtp.starttls.enable", "true"); 
            props.put("mail.smtp.socketFactory.port", "465"); 
            props.put("mail.smtp.socketFactory.fallback", "false"); 
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
            /** Ativa Debug para sessão */
            
            session.setDebug(true);

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("prolinkcontabil@gmail.com")); //Remetente

                HtmlEmail email = new HtmlEmail();
                String idArquivo = email.embed(new File("robot.png"));


                Address[] toUser = InternetAddress //Destinatário(s)
                         .parse("tiago.dias@prolinkcontabil.com.br");  

                message.setRecipients(Message.RecipientType.TO, toUser);
                //message.setSubject("Enviando email com JavaMail");//Assunto
                message.setSubject("Teste mail");

                StringBuilder builder = new StringBuilder();
                builder.append("<p style=\"color: blue;\">Ol&aacute; Tiago"
                      +"<span style=\"color:#000000;\"><img alt=\"\" height=\"210\" src=\"cid:"
                ).append(idArquivo).append("\" style=\"float: right;\" width=\"210\" /></span><br />");

                Multipart multipart = new MimeMultipart("related");
                BodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(builder.toString(), "text/html");

                EmailAttachment anexo = new EmailAttachment();
                anexo.setPath("anexo.pdf");
                anexo.setDisposition(EmailAttachment.ATTACHMENT);
                anexo.setName("boteco.pdf");

                multipart.addBodyPart(htmlPart);
                message.setContent(multipart);

                Transport.send(message);

            } catch (MessagingException | EmailException e) {
                  throw new RuntimeException(e);
            }
}
}
