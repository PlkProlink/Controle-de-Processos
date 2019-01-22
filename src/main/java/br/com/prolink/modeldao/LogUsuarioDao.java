/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//*Class criada para registrar ações dos usuarios,insert, update and delete

package br.com.prolink.modeldao;

import br.com.prolink.factory.ConfigTables;
import br.com.prolink.model.LogUsuarioBean;
import br.com.prolink.config.init.UsuarioLogado;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago Dias
 */

public class LogUsuarioDao implements ConfigTables{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
    
    public void inserir(LogUsuarioBean log, Connection con){
        Calendar calendar = Calendar.getInstance();
        String enviaDataBanco = sdf.format(calendar.getTime());
        String hora = sh.format(calendar.getTime());
        log.setData(enviaDataBanco);
        log.setHora(hora);
        log.setDepartamento(UsuarioLogado.getInstance().getUsuario().getDepartamento());
        try {
            InetAddress ip = InetAddress.getLocalHost();
            log.setEndereco(ip.getHostAddress());
            log.setHostname(ip.getHostName());
        } catch (UnknownHostException erro) {   
        }
        try{
            String sql = "insert into "+LOG_USUARIO+" ("+LOG_USUARIO_Usuario+", "
                    + LOG_USUARIO_Departamento+","
                    + LOG_USUARIO_Menu+", "
                    +LOG_USUARIO_Tela+", "
                    +LOG_USUARIO_Acao+", "
                    +LOG_USUARIO_Descricao+", "
                    +LOG_USUARIO_Processo+", "
                    +LOG_USUARIO_Apelido+", "
                    +LOG_USUARIO_Cliente+", "
                    +LOG_USUARIO_Data+","
                    +LOG_USUARIO_Hora+", "
                    +LOG_USUARIO_Endereco+", "
                    +LOG_USUARIO_Hostname+") values ('"
                    +log.getUsuario()+"','"+log.getDepartamento()+"','"+log.getMenu()+"','"+log.getTela()+"','"+log.getAcao()+"','"+log.getDescricao()+"','"
                    +log.getProcesso()+"','"+log.getApelido()+"','"+log.getCliente()+"','"
                    +log.getData()+"','"+log.getHora()+"','"+log.getEndereco()+"','"+log.getHostname()+"')";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException add){
            JOptionPane.showMessageDialog(null,"Erro no log\n"+add);
        }
        
    }
    
}