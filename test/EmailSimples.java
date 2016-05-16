/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */

/**
 *
 * @author Tiago
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSimples
{
      public static void main(String[] args) {
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl","true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");

            
            
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("tiagoicekiss@gmail.com", "alhoecebolayoutube");
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("tiagoicekiss@gmail.com")); //Remetente
                  
                  message.setRecipients(Message.RecipientType.TO, 
                                    InternetAddress.parse("tiagoice@hotmail.com")); //Destinatário(s)
                  message.setSubject("Enviando email com JavaMail");//Assunto
                  message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}
