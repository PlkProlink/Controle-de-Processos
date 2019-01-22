/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Tiago
 */
public class FTPDownload {
    String server = "ftp.prolinkcontabil.com.br";
    int port = 21;
    String user = "prolinkcontabil";
    String pass = "plk*link815";
    
    String dirFTP= "comprovantes_protocolo";
    private File novoArquivo;
    
    public File returnFile(){
        return this.novoArquivo;
    }
    public boolean downloadFile(String arquivo){
        FTPClient ftp = new FTPClient();
        try{
            ftp.connect(server,port);
            ftp.login(user, pass);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            
            String remoteFile1 = dirFTP+"/"+arquivo;
            novoArquivo= new File("c:/temp/"+arquivo);
            try (OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(novoArquivo))) {
                boolean success = ftp.retrieveFile(remoteFile1, outputStream1);
                if (success) {
                    System.out.println("File #1 has been downloaded successfully.");
                    return true;
                }
            }
            return false;
        }catch(IOException e){
            System.out.println("Erro = "+e.getMessage());
            return false;
        }finally{
            try {
                if (ftp.isConnected()) {
                    ftp.logout();
                    ftp.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
