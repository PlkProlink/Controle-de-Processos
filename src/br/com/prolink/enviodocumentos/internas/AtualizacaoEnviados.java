/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.factory.Conexao;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AtualizacaoEnviados {
    Conexao conexao;
    List<String> lista = new ArrayList<>();
    Processo processo = ProcessoLogado.getInstance().getProcesso();
    //1º Envio Realizado,2º Envio Realizado,Finalizado
    boolean atualizar_acompanhamento(String tela, String campo, String status, Connection con){
        try{
            String sql = "update acompanhamentodeenvios set "+campo+"=? where Numerodoprocesso=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, processo.getId());
            ps.executeUpdate();
            atualizar_status(processo, con);
            return true;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar acompanhamento: tela>" +tela+"\n"+erro);
            return false;
        }
    }

    private void atualizar_status(Processo p,Connection con){
        try{
            PreparedStatement ps = con.prepareStatement("select * from acompanhamentodeenvios where Numerodoprocesso=?");
            ps.setInt(1, p.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lista.add(rs.getString("PISacompanhamento"));
                lista.add(rs.getString("COFIISacompanhamento"));
                lista.add(rs.getString("IRPJacompanhamento"));
                lista.add(rs.getString("CSLLacompanhamento"));
                lista.add(rs.getString("ISSacompanhamento"));
                lista.add(rs.getString("GPSacompanhamento"));
                lista.add(rs.getString("BoletoPLKacompanhamento"));
                lista.add(rs.getString("IRPFsobreSalarioacompanhamento"));
                lista.add(rs.getString("IRPFsobreServicoTomadoacompanhamento"));
                lista.add(rs.getString("FGTSacompanhamento"));
                lista.add(rs.getString("ICMSacompanhamento"));
                lista.add(rs.getString("DASacompanhamento"));
                lista.add(rs.getString("IPIacompanhamento"));
                lista.add(rs.getString("ICMSServTomacompanhamento"));
            }
            String situacao="Em Aberto";
            for(int i =0 ; i<lista.size(); i++){
                if(!lista.get(i).contains("Finalizado")){
                    situacao="Em Aberto";
                    break;
                }
                else
                    situacao="Concluido";
            }
            atualiza_cadastro(p,situacao, con);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro Atualizador Enviados:\n"+ erro);
        }
    }
    private void atualiza_cadastro(Processo p, String situacao,Connection con){
        try{
            PreparedStatement ps = con.prepareStatement(
                    "update cadastrodeprocesso set AcompanhamentodeEnvios=? where codNumerodoprocesso=?");
            ps.setString(1, situacao);
            ps.setInt(2, p.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar o cadastro\n"+e);
        }
    }
}

