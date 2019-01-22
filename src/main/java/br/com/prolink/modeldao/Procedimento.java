/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.modeldao;

import br.com.prolink.util.HtmlEntities;
import br.com.prolink.model.ProtocoloEntrada;
import br.com.prolink.model.SendMail;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class Procedimento {

    private static Procedimento instance;

    public static Procedimento getInstance() {
        if (instance == null) {
            instance = new Procedimento();
        }
        return instance;
    }
    private Procedimento(){        
    }
    //usando o boolean trySucess, significa tentar enviar o alerta consecutivas vezes ate resultar em sucesso, se não informado a tentativa será única
    public void programarEnvioDocumentoRecebido(ProtocoloEntrada p, String email, boolean trySucess) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final SendMail aviso = new SendMail();
                List<String> itemNome = new ArrayList<>();
                List<String> qtde = new ArrayList<>();
                List<String> detalhes = new ArrayList<>();
                HtmlEntities htmlConversor = new HtmlEntities();
                p.getItems().forEach(item -> {
                    itemNome.add(htmlConversor.Converter(String.valueOf(item.getNome())));
                    qtde.add(String.valueOf(item.getQuantidade()));
                    detalhes.add(htmlConversor.Converter(String.valueOf(item.getDetalhe())));
                });
                String novoId = p.getApelido().length() >= 4 ? p.getApelido()
                        : (p.getApelido().length() == 1 ? "000" + p.getApelido() : (p.getApelido().length() == 2 ? "00" + p.getApelido() : "0" + p.getApelido()));
                String[] spEmpresa = p.getEmpresa().split(" ");
                String novoNome = spEmpresa.length>=3?spEmpresa[0]+spEmpresa[1]+spEmpresa[2]:p.getEmpresa();
                
                if (aviso.enviaAlerta(p.getId() + "", novoId, htmlConversor.Converter(novoNome),
                        itemNome.iterator(), qtde.iterator(), detalhes.iterator(), p.getParaQuem(), email, "")) {
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Enviado com sucesso!");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Email enviado para:\n"+p.getParaQuem()+" sob o protocolo nº: "+p.getId()+" foi entregue com sucesso!");
//                    alert.showAndWait();
                    JOptionPane.showMessageDialog(null, "Email enviado para:\n"+p.getParaQuem()+" sob o protocolo nº: "+p.getId()+" foi entregue com sucesso!");
                    timer.cancel();
                }
                else if(!trySucess){
                   JOptionPane.showMessageDialog(null, "Não foi possivel entregar o comunicado do protocolo "+p.getId()+" \nTalvez o servidor de e-mail esteja temporiaramnte disponivel, tente mais tarde!");
                   timer.cancel();
                }
            }

        }, 1000,5*60000);

    }
}
