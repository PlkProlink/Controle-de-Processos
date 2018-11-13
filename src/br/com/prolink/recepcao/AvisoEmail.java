package br.com.prolink.recepcao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class AvisoEmail {
    
    public boolean enviaAlerta(
            String protocolo, 
            String clienteId, 
            String clienteNome, 
            Iterator<String>itemNome, 
            Iterator<String>qtde, 
            Iterator<String>descricao, 
            String user, 
            String conta, 
            String mensagem)
    {
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
        email.setSubject(clienteId+" - Protocolo de Entrada Nº." +protocolo);

        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html>" )
                .append("<html>" )
                    .append("<head>" )
                    .append("<title></title>" )
                    .append("<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\" />" )
                    .append("</head>")
                    .append("<body id=\"cke_pastebin\" style=\"margin: 22px 10px 10px;\">" )
                    .append("<div style=\"text-align: center;\">" )
                    .append("<div style=\"text-align: left;\">" )
                    .append("<span style=\"font-size: 18px;\"><span style=\"font-family: &quot;comic sans ms&quot;, cursive;\">Ol&aacute; ")
                    .append(user)
                    .append(";</span></span></div>" )
                    .append("<div style=\"text-align: left;\">&nbsp;</div>" )
                    .append("<div style=\"text-align: left;\">" )
                    .append("<span style=\"font-size: 18px;\"><span style=\"font-family: &quot;comic sans ms&quot;, cursive;\">Existe(m) novo(s) documento(s) para voc&ecirc;.</span></span></div>" )
                    .append("<div style=\"text-align: left;\">&nbsp;</div>" )
                    .append(mensagem)
                    .append("<div style=\"text-align: left;\">" )
                    .append("<span style=\"font-size: 18px;\"><span style=\"font-family: &quot;comic sans ms&quot;, cursive;\">Agora &eacute; necess&aacute;rio que voc&ecirc; informe se os documentos devem ou n&atilde;o serem devolvidos atrav&eacute;s do protocolo de entrada.</span></span></div>" )
                    .append("<div style=\"text-align: left;\">")
                    .append("<span style=\"color:#ff0000;\"><span style=\"font-size: 18px;\"><span style=\"font-family: &quot;comic sans ms&quot;,cursive;\">Lembre-se, quando voc&ecirc; participa, estar&aacute; apoiando esse projeto, em consequ&ecirc;ncia ir&aacute; crescer e melhorar o trabalho de todos com novas fun&ccedil;&otilde;es para todos os setores.</span></span></span></div>")
                    .append("<div>&nbsp;</div>" )
                    .append("</div>" )
                    .append("<div style=\"text-align: center;\">" )
                        .append("<table align=\"left\" border=\"2\" cellpadding=\"2\" cellspacing=\"0\" style=\"width: 90%\">" )
                        .append("<thead>" )
                        .append("<tr>" )
                        .append("<th scope=\"row\" style=\"background-color: rgb(255, 204, 153); width: 10%;\">" )
                        .append("<font color=\"#a52a2a\" face=\"comic sans ms, cursive\">Protocolo de &nbsp;Entrada</font></th>" )
                        .append("<th scope=\"row\" style=\"background-color: rgb(255, 204, 153); width: 10%;\">" )
                        .append("<span style=\"color:#a52a2a;\"><span style=\"font-family:comic sans ms,cursive;\">Data</span></span></th>" )
                        .append("<th colspan=\"2\" scope=\"col\" style=\"background-color: rgb(255, 204, 153); width: 10%;\">" )
                        .append("	<span style=\"color:#a52a2a;\"><span style=\"font-family:comic sans ms,cursive;\">Refer&ecirc;ncia</span></span></th>" )
                        .append("	<th scope=\"col\" style=\"background-color: rgb(255, 204, 153); width: 10%;\">" )
                        .append("	<span style=\"color:#a52a2a;\"><span style=\"font-family:comic sans ms,cursive;\">Tipo</span></span></th>" )
                        .append("	<th scope=\"col\" style=\"background-color: rgb(255, 204, 153); width: 10%;\">" )
                        .append("	<span style=\"color:#a52a2a;\"><span style=\"font-family:comic sans ms,cursive;\">Qtde</span></span></th>" )
                        .append("	<th scope=\"col\" style=\"background-color: rgb(255, 204, 153); width: 10%;\">" )
                        .append("	<span style=\"color:#a52a2a;\"><span style=\"font-family:comic sans ms,cursive;\">Descri&ccedil;&atilde;o</span></span></th>" )
                        .append("	</tr>" )
                        .append("</thead>" )
                        .append("   <tbody>" )
                        .append("	<tr>" )
                        .append("	<th scope=\"row\" style=\"background-color: rgb(255, 255, 204); width: 10%;\">" )
                        .append("	<span style=\"color:#ff0000;\"><font face=\"comic sans ms, cursive\"><span style=\"font-size: 14px;\">")
                        .append(protocolo)
                        .append("</span></font></span></th>" )
                        .append("	<th scope=\"row\" style=\"background-color: rgb(255, 255, 204); width: 10%;\">" )
                        .append("	<span style=\"color:#ff8c00;\"><font face=\"comic sans ms, cursive\"><span style=\"font-size: 14px;\">")
                        .append(new SimpleDateFormat("dd/MM/yyyy").format(new Date()))
                        .append(" &agrave;s ")
                        .append(new SimpleDateFormat("HH:mm").format(new Date()))
                        .append("</span></font></span></th>" )
                        .append("	<th style=\"background-color: rgb(255, 255, 204); width: 10%;\">" )
                        .append("	<span style=\"font-size:14px;\"><span style=\"color:#ff8c00;\"><font face=\"comic sans ms, cursive\">")
                        .append(clienteId)
                        .append("</font></span></span></th>" )
                        .append("	<th style=\"background-color: rgb(255, 255, 204); width: 20%;\">" )
                        .append("	<span style=\"font-size:14px;\"><span style=\"color:#ff8c00;\"><span style=\"font-family:comic sans ms,cursive;\">")
                        .append(clienteNome)
                        .append("</span></span></span></th>")
                        .append("	<th style=\"background-color: rgb(255, 255, 204); width: 10%;\">");

            while(itemNome.hasNext()){
                builder.append("	<p><span style=\"color:#ff8c00;\"><span style=\"font-family:comic sans ms,cursive;\"><strong><span style=\"font-size:14px;\">")
                        .append(itemNome.next())
                        .append("</span></strong></span></span><p>");
            }

            builder.append("       </th>" )
                    .append("	<th style=\"background-color: rgb(255, 255, 204); width: 10%;\">");
            while(qtde.hasNext()){
                builder.append("<p>	<span style=\"color:#ff8c00;\"><span style=\"font-family:comic sans ms,cursive;\"><strong><span style=\"font-size:14px;\">")
                        .append(qtde.next())
                        .append("</span></strong></span></span><p>");
            }
            builder.append("       </th>" )
                    .append("	<th style=\"background-color: rgb(255, 255, 204); width: 40%;\">");
            while(descricao.hasNext()){
                builder.append("<p>	<font color=\"#ff8c00\" face=\"comic sans ms, cursive\"><span style=\"font-size: 14px;\">")
                        .append(descricao.next())
                        .append("</span></font></p>");
            }

                builder.append("       </th>" )
                        .append("	</tr>" )
                        .append("	</tbody>" )
                        .append("</table>" )
                        .append("</div>" )
                    
                    .append("<div style=\"text-align: left;\">&nbsp;</div>" )
                    .append("<p style=\"text-align: left;\">" )
                    .append("<span style=\"font-family: &quot;comic sans ms&quot;, cursive; font-size: 18px; text-align: left;\">Preciso que valide o recebimento pelo sistema Controle de Processos,</span></p>" )
                    .append("<div style=\"text-align: left;\">" )
                    .append("<font face=\"comic sans ms, cursive\"><span style=\"font-size: 18px;\">se notar algo errado, use a op&ccedil;&atilde;o Contestar ou encaminhe para outra pessoa.</span></font></div>" )
                    .append("<div style=\"text-align: left;\">&nbsp;</div>" )
                    .append("</div>" )
                    .append("<p><span style=\"color:#d3d3d3;\"><span style=\"font-family:comic sans ms,cursive;\">***Esse aviso &eacute; gerado automaticamente, n&atilde;o &eacute; necess&aacute;rio que responda***</span></span></p>" )
                    .append("<p>&nbsp;</p>" )
                    .append("<p><span style=\"color:#d3d3d3;\"><span style=\"font-family:comic sans ms,cursive;\"><img alt=\"\" src=\"http://prolinkvip.prolinkcontabil.com.br/uploadimages/prolinkvip.prolinkcontabil.com.br/assinatura_email_prolink(1).gif\" style=\"width: 365px; height: 123px; float: left;\" /></span></span></p>" )
                    .append("</body>" )
                .append("</html>");
        email.setHtmlMsg( builder.toString() );
        
        email.addTo(conta);
        email.send();
        return true;
    } catch (EmailException e) {
        JOptionPane.showMessageDialog(null, "Falha ao enviar o email!\n"+e.getMessage());
        return false;
    } 
    }
}