/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.view.interfaces;

import java.net.URL;

/**
 *
 * @author Tiago
 */
public class Icons {

    private static Icons instance;

    public static Icons getInstance() {
        if (instance == null) {
            instance = new Icons();
        }
        return instance;
    }

    public URL getIcon() {
        return getClass().getClassLoader().getResource("br/com/prolink/view/imagens/logo.png");
    }

    public URL getEstilo() {
        return getClass().getClassLoader().getResource("br/com/prolink/view/css/estilo.css");
    }
}
