


import java.io.File;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class AvisoEmail {

    public static void main(String[] args){
    
    HtmlEmail email = new HtmlEmail();
    email.setHostName( "smtp.prolinkcontabil.com.br" );
    email.setSmtpPort(587);
//    email.setContent("mail.smtp.socketFactory.port", "465");
//    email.setContent("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    email.setSslSmtpPort( "465" );
//    email.setStartTLSRequired(true);
//    email.setSSLOnConnect(true);
    
    email.setAuthenticator( new DefaultAuthenticator( "documentos@prolinkcontabil.com.br" ,  "plkc2004" ) );
    
    try {
        email.setFrom( "documentos@prolinkcontabil.com.br" , "Tiago Dias");
        email.setDebug(true); 
        email.setSubject( "Que bom que voltou Tiago" );

        StringBuilder builder = new StringBuilder();
        builder.append("<h2>Olá Tiago,</h2>");
        builder.append("<p></p>. Duis nec aliquam tortor. Sed dignissim dolor ac est consequat egestas. Praesent adipiscing dolor in consectetur fringilla.</p>");
        builder.append("<a href=\"http://wwww.botecodigital.info\">Boteco Digital</a> <br> ");
        builder.append("<img src=\"http://www.botecodigital.info/wp-content/themes/boteco/img/logo.png\">");

        EmailAttachment anexo = new EmailAttachment();
        anexo.setPath("relatorios/Jose201602261746.pdf");
        anexo.setDisposition(EmailAttachment.ATTACHMENT);
        anexo.setName("teste.pdf");
 
        String id = email.embed(new File("imagens/robot.png"));
        
        String mensagem = "<img src=\"cid:"+id+"\">";
        
        email.attach(anexo);
        
        email.setHtmlMsg( builder.toString()+"\n"+mensagem);
        
        email.addTo("tiagoice@hotmail.com" );
        email.send();
        
        System.out.println("Sucesso!");
    } catch (EmailException e) {
        e.printStackTrace();
    } 
    }
}