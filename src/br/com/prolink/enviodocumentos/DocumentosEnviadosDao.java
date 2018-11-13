/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.enviodocumentos;

import br.com.prolink.model.ProcessoLogado;
import static br.com.prolink.enviodocumentos.DocumentosEnviados.*;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.factory.ConfigTables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago Dias
 */
public class DocumentosEnviadosDao implements ConfigTables{
    private final String processo=ProcessoLogado.getInstance().getProcesso().getId()+"";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Connection con;
    private Connection getConnection(){
        this.con =  ConexaoStatement.getInstance().getConnetion();
        return con;
    }
    private void closeConnection(){
        try{con.close();}catch(SQLException e){}
    }
    public void atualizarTudo(){
        getConnection();
        tudo(con);
        closeConnection();
    }
    public void tudo(Connection con){
        boleto(con);
        cofins(con);
        csll(con);
        das(con);
        fgts(con);
        gps(con);
        icms(con);
        icms_servico(con);
        ipi(con);
        irpf_salario(con);
        irpf_servico(con);
        irpj(con);
        iss(con);
}    
private void buscar(String tabela, String columnProcesso,String[] campoData,JLabel[] label){
    try{
        PreparedStatement ps = con.prepareStatement("select * from "+tabela+" where "+columnProcesso+"=?");
        ps.setInt(1, ProcessoLogado.getInstance().getProcesso().getId());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            if(rs.last()){
                for(int i = 0 ; i<campoData.length; i++){
                    java.sql.Date data = rs.getDate(campoData[i]);
                    if(data!=null && !sdf.format(data).equals("11/11/1111")){
                        label[i].setText(sdf.format(data));
                    }
                    else
                        label[i].setText("");
                }
            }
        }
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, erro);
    }
}
public void boleto(Connection con){
    buscar(BOLETOPLKACOMPANHAMENTO,
            BOLETOPLKACOMPANHAMENTO_NumeroProcesso,
            new String[]{BOLETOPLKACOMPANHAMENTO_Data1Envio,BOLETOPLKACOMPANHAMENTO_Data2Envio,BOLETOPLKACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbBol1,lbBol2,lbBol3});
}           
public void das(Connection con){
    buscar(DASACOMPANHAMENTO,
            DASACOMPANHAMENTO_NumeroProcesso,
            new String[]{DASACOMPANHAMENTO_Data1Envio,DASACOMPANHAMENTO_Data2Envio,DASACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbDas1,lbDas2,lbDas3});
}
public void cofins(Connection con){
    buscar(PISACOMPANHAMENTO,
            PISACOMPANHAMENTO_NumeroProcesso,
            new String[]{PISACOMPANHAMENTO_Data1Envio,PISACOMPANHAMENTO_Data2Envio,PISACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbCofins1,lbCofins2,lbCofins3});
}
public void irpj(Connection con){
    buscar(IRPJACOMPANHAMENTO,
            IRPJACOMPANHAMENTO_NumeroProcesso,
            new String[]{IRPJACOMPANHAMENTO_Data1Envio,IRPJACOMPANHAMENTO_Data2Envio,IRPJACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIrpj1,lbIrpj2,lbIrpj3});
}
public void csll(Connection con){
    buscar(CSLLACOMPANHAMENTO,
            CSLLACOMPANHAMENTO_NumeroProcesso,
            new String[]{CSLLACOMPANHAMENTO_Data1Envio,CSLLACOMPANHAMENTO_Data2Envio,CSLLACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbCsll1,lbCsll2,lbCsll3});
}
public void iss(Connection con){
    buscar(ISSACOMPANHAMENTO,
            ISSACOMPANHAMENTO_NumeroProcesso,
            new String[]{ISSACOMPANHAMENTO_Data1Envio,ISSACOMPANHAMENTO_Data2Envio,ISSACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIss1,lbIss2,lbIss3});
}
public void gps(Connection con){
    buscar(GPSACOMPANHAMENTO,
            GPSACOMPANHAMENTO_NumeroProcesso,
            new String[]{GPSACOMPANHAMENTO_Data1Envio,GPSACOMPANHAMENTO_Data2Envio,GPSACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbGps1,lbGps2,lbGps3});
}
public void irpf_salario(Connection con){
    buscar(IRPFSOBRESALARIOACOMPANHAMENTO,
            IRPFSOBRESALARIOACOMPANHAMENTO_NumeroProcesso,
            new String[]{IRPFSOBRESALARIOACOMPANHAMENTO_Data1Envio,IRPFSOBRESALARIOACOMPANHAMENTO_Data2Envio,IRPFSOBRESALARIOACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIrpfSal1,lbIrpfSal2,lbIrpfSal3});    
}
public void irpf_servico(Connection con){
    buscar(IRPFSOBRESERVICOTOMADOACOMPANHAMENTO,
            IRPFSOBRESERVICOTOMADOACOMPANHAMENTO_NumeroProcesso,
            new String[]{IRPFSOBRESERVICOTOMADOACOMPANHAMENTO_Data1Envio,IRPFSOBRESERVICOTOMADOACOMPANHAMENTO_Data2Envio,IRPFSOBRESERVICOTOMADOACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIrpfServ1,lbIrpfServ2,lbIrpfServ3});
}
public void fgts(Connection con){
    buscar(FGTSACOMPANHAMENTO,
            FGTSACOMPANHAMENTO_NumeroProcesso,
            new String[]{FGTSACOMPANHAMENTO_Data1Envio,FGTSACOMPANHAMENTO_Data2Envio,FGTSACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbFgts1,lbFgts2,lbFgts3});
}
public void icms(Connection con){
    buscar(ICMSACOMPANHAMENTO,
            ICMSACOMPANHAMENTO_NumeroProcesso,
            new String[]{ICMSACOMPANHAMENTO_Data1Envio,ICMSACOMPANHAMENTO_Data2Envio,ICMSACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIcms1,lbIcms2,lbIcms3});
}
public void ipi(Connection con){
    buscar(IPIACOMPANHAMENTO,
            IPIACOMPANHAMENTO_NumeroProcesso,
            new String[]{IPIACOMPANHAMENTO_Data1Envio,IPIACOMPANHAMENTO_Data2Envio,IPIACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIpi1,lbIpi2,lbIpi3});
}
public void icms_servico(Connection con){
    buscar(ICMSSERVTOMACOMPANHAMENTO,
            ICMSSERVTOMACOMPANHAMENTO_NumeroProcesso,
            new String[]{ICMSSERVTOMACOMPANHAMENTO_Data1Envio,ICMSSERVTOMACOMPANHAMENTO_Data2Envio,ICMSSERVTOMACOMPANHAMENTO_Data3Envio},
            new JLabel[]{lbIcmsServ1,lbIcmsServ2,lbIcmsServ3});
}
}
