package br.com.prolink.inicio.administracaoAlertas;

import br.com.prolink.config.init.UsuarioLogado;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class AvisoEmail {

    public boolean enviaAlerta(String contaDestino, String[] contaCopia, String titulo, String texto) {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("email-ssl.com.br");
        email.setSmtpPort(587);;
//tentei com o gmail mas nao consegui se nao desativar o antivirus
//    email.setContent("mail.smtp.socketFactory.port", "465")
//    email.setContent("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    email.setSslSmtpPort( "465" );
//    email.setStartTLSRequired(true);
//    email.setSSLOnConnect(true);

        email.setAuthenticator(new DefaultAuthenticator("documentos@prolinkcontabil.com.br", "l!nk2016Cont"));

        try {
            email.setFrom("documentos@prolinkcontabil.com.br", "Controle de Processsos - Implantação");
            //email.setDebug(true); 
            String subject = new String((titulo).getBytes(), "UTF-8");
            email.setSubject(subject);
            email.setHtmlMsg(texto);
            email.addTo(contaDestino);
            if (contaCopia != null) {
                for (String conta : contaCopia) {
                    email.addCc(conta);
                }
            }
            email.send();
            return true;
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(null, "Falha ao enviar o email!\n"
                    + "Esse problema ocorre quando a conta de e-mail documentos@prolinkcontabil.com.br esta fora do ar\n "
                    + "nesse caso não há necessidade de chamar o suporte,\n"
                    + "Apenas aguarde alguns minutos e tente novamente mais tarde.\n\n\nDetalhes do erro:" + e);
            return false;
        } catch (UnsupportedEncodingException ex) {
            return false;
        }
    }
}
