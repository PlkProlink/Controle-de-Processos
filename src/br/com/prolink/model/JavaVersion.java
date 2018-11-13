/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

import br.com.prolink.factory.ConexaoStatement;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago
 */
public class JavaVersion {
    public boolean iniciar() {
        String javaVersion = System.getProperty("java.version");
        try {
            if (javaVersion.contains(".") && javaVersion.contains("_")) {
                String[] value = javaVersion.split("\\.");
                if (value.length > 1) {
                    if (Integer.parseInt(value[0]) >= 1) {
                        if (Integer.parseInt(value[1]) < 8) {
                            chamaAtualizador();
                        } else if (Integer.parseInt(value[1]) == 8) {
                            String[] arg = javaVersion.split("_");
                            if (arg.length > 1) {
                                int v2 = Integer.parseInt(arg[1]);
                                if (v2 < 99) {
                                    return true;
                                }
                            } else {
                                chamaLog(javaVersion);
                            }
                        }
                    }
                } else chamaLog(javaVersion);
            } else chamaLog(javaVersion);
        } catch (Exception e) {
            chamaLog(javaVersion);
        }
        return false;
    }

    public void chamaAtualizador() {
        new Thread(() -> {
            try {
                File jar = new File("\\\\plkserver\\Sistemas\\jre-8_121.exe");
                Desktop.getDesktop().open(jar);
            } catch (IOException ex) {
                try {
                    Desktop.getDesktop().browse(URI.create("http://www.java.com"));
                } catch (IOException e) {
                }
            }
        }).start();
    }

    private void chamaLog(String javaVersion) {
        Connection con = ConexaoStatement.getInstance().getConnetion();
        try{
            StringBuilder builder = new StringBuilder();
            builder.append(InetAddress.getLocalHost().getHostName());
            builder.append(" - ");
            builder.append(System.getProperty("user.name"));
            builder.append(" - ");
            builder.append(javaVersion);
            PreparedStatement ps = con.prepareStatement("insert into log_java_version (detalhes) values (?)");
            ps.setString(1,builder.toString());
            ps.executeUpdate();
        }catch(SQLException e){
        }catch(UnknownHostException ex){
        }finally{try{con.close();}catch(SQLException es){}}
    }
}
