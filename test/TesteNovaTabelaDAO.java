/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;
/**
 *Criaremos metodos get e set para o atributo con
 * @author User
 */
public class TesteNovaTabelaDAO {
    private Connection con;
        public TesteNovaTabelaDAO(Connection con){
            setCon(con);
        }
//assinatura do metodo para avisar se tudo ocorreu bem
public String inserir(TesteNovaTabelaBean tabela){
    String sql="insert into carro(placa, cor, descricao) values (?,?,?)";  
//enviaremos os dados o banco com try para evitar SQLException

    try{
//interface PreparedStatement
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, tabela.getCod());
        ps.setString(2, tabela.getData());
        ps.setString(3, tabela.getHora());
        ps.setString(4, tabela.getId());
        ps.setString(5, tabela.getEmpresa());
        ps.setString(6, tabela.getRecebidopor());
        ps.setString(7, tabela.getHistorico());
        ps.setString(8, tabela.getPara());
        ps.setString(9, tabela.getDepartamento());
        ps.setString(10, tabela.getQuemrecebeu());
        ps.setString(11, tabela.getObservacao());
        
        
        
        
        if (ps.executeUpdate() > 0){
            return "Inserido com sucesso!";
        }else{
            return "Erro ao inserir!";
}
//se usamos try devemos ter ao menus um catch ou finally
    }catch (SQLException e){
        return e.getMessage();
}
}
public String alterar(TesteNovaTabelaBean tabela){
    String sql = "update carro set cor = ?, descricao = ?";
    sql += "where placa = ?";

    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(2, tabela.getData());
        ps.setString(3, tabela.getHora());
        ps.setString(4, tabela.getId());
        ps.setString(5, tabela.getEmpresa());
        ps.setString(6, tabela.getRecebidopor());
        ps.setString(7, tabela.getHistorico());
        ps.setString(8, tabela.getPara());
        ps.setString(9, tabela.getDepartamento());
        ps.setString(10, tabela.getQuemrecebeu());
        ps.setString(11, tabela.getObservacao());
        ps.setString(1, tabela.getCod());
        
        if (ps.executeUpdate() > 0) {
            return "Alterado com sucesso.";
}       else{
            return "Erro ao alterar";
}
}catch (SQLException e){
        return e.getMessage();
}
}
public String excluir(TesteNovaTabelaBean tabela){
    String sql ="delete from documentos_recebidos where cod = ?";
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, tabela.getCod());
        
        if(ps.executeUpdate()>0){
            return "Excluido com sucesso.";
        }else{
            return "Erro ao excluir";
        }
    }catch (SQLException e) {
    return e.getMessage();
    }
}

//medoto listagem
public List<TesteNovaTabelaBean> listarTodos() {
    String sql = sql = "select * from documentos_recebidos where Para_Quem like 'maikell' and Recebido like 'n'";
    List<TesteNovaTabelaBean> listarTabela = new ArrayList<TesteNovaTabelaBean>();
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs != null){
           while (rs.next ()){
                TesteNovaTabelaBean tb = new TesteNovaTabelaBean();
                
                tb.setCod(rs.getString(1));
                tb.setData(rs.getString(2));
                tb.setRecebidopor(rs.getString(3));
                tb.setEmpresa(rs.getString(4));
                tb.setId(rs.getString(5));
                tb.setHistorico(rs.getString(6));
                tb.setPara(rs.getString(7));
                tb.setQuemrecebeu(rs.getString(8));
                tb.setObservacao(rs.getString(10));
                tb.setDepartamento(rs.getString(11));
                tb.setHora(rs.getString(12));
                
                listarTabela.add(tb);
        }
        return listarTabela;
        }else{
            return null;
        }   
    }catch (SQLException e){   
        return null;
    }
}
    public Connection getCon(){
        return con;
}
    public void setCon(Connection con) {
        this.con = con;
    }
}