


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class AvisoEmail {

    public static void main(String[] args){
    
    HtmlEmail email = new HtmlEmail();
    email.setHostName( "smtp.gmail.com" );
    email.setSmtpPort(465);//tentei com o gmail mas nao consegui
//    email.setSslSmtpPort( "465" );
    email.setStartTLSRequired(true);
    email.setSSLOnConnect(true);
    
    email.setAuthenticator( new DefaultAuthenticator("tiagoicekiss@gmail.com", "alhoecebolayoutube") );
    
//    Properties props = new Properties();
//    props.put("mail.smtp.host", "smtp.gmail.com");
//    props.put("mail.from","tiagoicekiss@gmail.com");
//    props.put("mail.smtp.starttls.enable", "true");
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.debug", "true");
//    Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("tiagoicekiss@gmail.com", "alhoecebolayoutube");
//            }
//        });

    try {
        email.setFrom( "tiagoicekiss@gmail.com" , "Tiago Dias");
        email.setDebug(true); 
        email.setSubject( "Que bom que voltou Tiago" );

        StringBuilder builder = new StringBuilder();
        builder.append("<h2>Olá Tiago,</h2>");
        builder.append("<p></p>. Duis nec aliquam tortor. Sed dignissim dolor ac est consequat egestas. Praesent adipiscing dolor in consectetur fringilla.</p>");
        builder.append("<a href=\"http://wwww.botecodigital.info\">Boteco Digital</a> <br> ");
        builder.append("<img src=\"http://www.botecodigital.info/wp-content/themes/boteco/img/logo.png\">");

//        EmailAttachment anexo = new EmailAttachment();
//        anexo.setPath("relatorios/Jose201602261746.pdf");
//        anexo.setDisposition(EmailAttachment.ATTACHMENT);
//        anexo.setName("teste.pdf");
 
//        String id = email.embed(new File("imagens/robot.png"));
//        
//        String mensagem = "<img src=\"cid:"+id+"\">";
        
//        email.attach(anexo);
        
        email.setHtmlMsg( builder.toString()+"\n");
        
        email.addTo("tiagoice@hotmail.com" );
        email.send();
        
        System.out.println("Sucesso!");
    } catch (Exception e) {
        e.printStackTrace();
    } 
    }
}