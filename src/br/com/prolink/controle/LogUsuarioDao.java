/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//*Class criada para registrar ações dos usuarios,insert, update and delete

package br.com.prolink.controle;

import br.com.prolink.login.Login;
import br.com.prolink.inicio.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago Dias
 */

public class LogUsuarioDao {
    Conexao con_log;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
    
    
    public void inserir(LogUsuarioBean log){
        con_log  = new Conexao();
        con_log.conecta();
        
        Date dt = new Date();
        String data = sdf.format(dt);
        
        //Date data = sdf.parse(data)
        
        //converter usando o substring
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String enviaDataBanco = ano+"-"+mes+"-"+dia;
        
        String hora = sh.format(dt);
        
        log.setData(enviaDataBanco);
        log.setHora(hora);
        
        log.setUsuario(Login.usuario);
        log.setDepartamento(Login.departamento);
        //JOptionPane.showMessageDialog(null, "Data:" +enviaDataBanco+ "\nHora: "+hora);
        try {
            InetAddress ip = InetAddress.getLocalHost();
            
            log.setEndereco(ip.getHostAddress());
            log.setHostname(ip.getHostName());
        } catch (UnknownHostException erro) {
            
        }
        
        try{
            con_log.exeQuery("insert into log_usuario (Usuario, Departamento, Menu, Tela, Acao, Descricao, Processo, Apelido, Cliente, Data,Hora, Endereco, Hostname) values ('"+
                            log.getUsuario()+"','"+log.getDepartamento()+"','"+log.getMenu()+"','"+log.getTela()+"','"+log.getAcao()+"','"+log.getDescricao()+"','"
                            +log.getProcesso()+"','"+log.getApelido()+"','"+log.getCliente()+"','"
                           +log.getData()+"','"+log.getHora()+"','"+log.getEndereco()+"','"+log.getHostname()+"')");
        
        }catch(Exception add){
            JOptionPane.showMessageDialog(null,"Erro no log\n"+add);
        }
        con_log.desconecta();
    }
    
}