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
    
    email.setAuthenticator( new DefaultAuthenticator( "documentos@grupoprolink.com.br" ,  "l!nk2016Cont" ) );
    
    try {
        email.setFrom( "documentos@grupoprolink.com.br" , "Documentos");
        email.setDebug(true); 
        email.setSubject( idCliente+" - Oi "+user+", Tem um Novo Documento Aguardando Sua Atenção" );

        String idArquivo = email.embed(new File("robot.png"));
        
        StringBuilder builder = new StringBuilder();
//+"<span style=\"color:#000000;\"><img alt=\"\" height=\"210\" src=\"http://img.actualidadgadget.com/wp-content/uploads/2015/04/robot-question-300x300.jpg\" style=\"float: right;\" width=\"210\" /></span><br />"
        //+"<span style=\"color:#000000;\"><img alt=\"\" height=\"210\" src=\"cid:").append(idArquivo).append("\" style=\"float: right;\" width=\"210\" /></span><br />"

        builder.append("<span style=\"color:#0000cd;\"><strong>Ola ").append(user).append(";</strong></span></div>"
		+"<div style=\"text-align: left;\">&nbsp;</div>"
		+"<div style=\"text-align: left;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Tem um novo documento que acabou de chegar para voc&ecirc;;</span></div>"
		+"<div style=\"text-align: left;\">&nbsp;</div>"
                                    +"<div style=\"text-align: left;\"><span style=\"font-family:verdana,geneva,sans-serif;\">").append(aux).append("</span></div>"
		+"<div style=\"text-align: left;\">&nbsp;</div>"
		+"<div style=\"text-align: left;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Antes de mostrar os detalhes preciso que voc&ecirc; valide o recebimento no Controle de Processos, certo?</span></div>"
		+"<div style=\"text-align: left;\"><span style=\"font-family:verdana,geneva,sans-serif;\">&Eacute; muito importante ter esse controle.</span></div>"
		+"<div style=\"text-align: left;\"><span style=\"font-family:verdana,geneva,sans-serif;\">E mesmo que n&atilde;o seja seu ou n&atilde;o receba &eacute; possivel Contestar a entrega (Op&ccedil;&atilde;o Constestar), f&aacute;cil...</span></div>"
		+"<div style=\"text-align: left;\">&nbsp;</div>"
		+"<div style=\"text-align: left;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Vamos l&aacute;</span></div>"
		+"<ul><li style=\"text-align: left;\">"
                                             +"<span style=\"color:#ff8c00;\"><span style=\"font-size:14px;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Hora da Entrega:").append(hora).append("</span></span></span></li>"
			+"<li style=\"text-align: left;\">"
				+"<span style=\"color:#ff8c00;\"><span style=\"font-size:14px;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Id:").append(idCliente).append("</span></span></span></li>"
			+"<li style=\"text-align: left;\">"
				+"<span style=\"color:#ff8c00;\"><span style=\"font-size:14px;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Nome:").append(cliente).append("</span></span></span></li>"
			+"<li style=\"text-align: left;\">"
				+"<span style=\"color:#ff8c00;\"><span style=\"font-size:14px;\"><span style=\"font-family:verdana,geneva,sans-serif;\">Detalhes:").append(mensagem).append("</span></span></span></li>"
		+"</ul>"
		+"<p><span style=\"color:#000000;\"><img alt=\"\" height=\"300\" src=\"cid:").append(idArquivo).append("\" style=\"float: right;\" width=\"300\" /></span></p>"
		+"<p>&nbsp;</p><p>&nbsp;</p>"
		+"<p>&nbsp;</p><div style=\"text-align: left;\">"
			+"<span style=\"font-family:verdana,geneva,sans-serif;\">Na vers&atilde;o nova tem gr&aacute;ficos onde &eacute; poss&iacute;vel ter uma vis&atilde;o geral.</span></div>"
		+"<p>&nbsp;</p><div style=\"text-align: left;\">"
			+"<span style=\"color:#a9a9a9;\"><em><span style=\"font-family:verdana,geneva,sans-serif;\">***Ah! Outra coisa...n&atilde;o responde esse e-mail por favor. Tudo isso &eacute; autom&aacute;tico***</span></em></span></div>"
            );
        
        email.setHtmlMsg( builder.toString()+"\n");
        
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