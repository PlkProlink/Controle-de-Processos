package br.com.prolink.util;

import com.tecnick.htmlutils.htmlentities.HTMLEntities;

/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */

/**
 *
 * @author Tiago Dias
 */
public class HtmlEntities {
//*Simples classe de conversão de texto para html    
    public String Converter(String texto){
        String html = HTMLEntities.htmlentities(texto);
        return html;
    }
}
