/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.cadastros;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author User
 */
public class AlertaExclusao {
    
    public static String assunto;
    public static String destino;
    public static String mensagem;
    
    Properties props = new Properties();
     Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("tiago.dias@prolinkcontabil.com.br", "plkc2004");
                             }
                        });
public void enviar_alerta(){
     /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.prolinkcontabil.com.br");
            //props.put("mail.smtp.socketFactory.port", "587");
            //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            /** Ativa Debug para sessão */
            
            session.setDebug(true);

             try {
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("tiago.dias@prolinkcontabil.com.br")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(destino);  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  //message.setSubject("Enviando email com JavaMail");//Assunto
                  message.setSubject(assunto);
                  
                  //message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
                  message.setText(mensagem);
                  
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  //JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!!!");
                  
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
             }
}
}
