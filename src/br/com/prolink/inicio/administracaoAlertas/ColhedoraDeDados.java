/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

import br.com.prolink.inicio.ConexaoStatement;
import br.com.prolink.recepcao.HtmlEntities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class ColhedoraDeDados {
    
    private int contagemDocumentos;//valor total de documentos pendentes
    private int contagemDepartamento;//valor total de pendencias do departamento
    private int contagemTudo;
//montar texto/detalhes dos documentos    
    private String textoDocumentos=""; //texto descricação
    private String textoDepartamento="";//texto descrição do departamento
//montar interior tableas
    private String tabelaContagem="";
    private String tabelaDepartamento="";
    private String tabelaDocumentos="";
    
    private String nomeCliente;
    private String apelidoCliente;
    
    private boolean html=false;
    
    
    String contador;
    
    HtmlEntities conversor = new HtmlEntities();
    
    public void conexaoDocumentos(int processo, boolean html, String tela){
    
    this.html = html;//se o resultado será em html ou não
    
    Connection con = new ConexaoStatement().getConnetion();
    String sql = "select * from documentos as a inner join cadastrodeprocesso as b"
            + " on b.codNumerodoprocesso = a.Numerodoprocesso where a.Numerodoprocesso=?";
    try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, processo);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    rsTextoDocumentos(processo, tela, rs);
                    }
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao realizar a consulta!\n" +erro);
            }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    public void conexaoDepartamentos(int processo, boolean html, String tela){
    
    this.html = html;//se o resultado será em html ou não
    
    Connection con = new ConexaoStatement().getConnetion();
    String sql ="select a.AndamentoTaxaDeImplantacaoEFormaDePagamento as COMERCIAL1," +
                            "a.AndamentoGravarSenhasFiscais AS COMERCIAL2," +
                            "a.AndamentoGerarOS AS COMERCIAL3," +
                            "a.AndamentoEnviarTermoResponsaparacliente AS COMERCIAL4," +
                            "a.AndamentoPropastaComercial AS COMERCIAL5," +
                            "a.AndamentoEnvioDiagnose AS COMERCIAL6," +
                            "a.AndamentoPesquisaFiscal AS COMERCIAL7," +
                            "a.AndamentoRequisicaoDocumentos AS COMERCIAL8," +
                            "a.AndamentoConfirmarRecebimentoDeposito AS COMERCIAL9," +
                            "b.AndamentoGerarPlanoDeContas AS CONTABIL1," +
                            "c.AndamentoElaborarContratoPrestacaoDeServico AS CONTRATOS1," +
                            "c.AndamentoCadastrarControlEContmatic AS CONTRATOS2," +
                            "c.AndamentoAtivarCliente AS CONTRATOS3," +
                            "c.AndamentoElaborarPrefilFiscal AS CONTRATOS4," +
                            "c.AndamentoReceberContratoAssCliente AS CONTRATOS5," +
                            "c.AndamentoGerarIDPlanCadastro AS CONTRATOS6," +
                            "d.AndamentoCadastroDoSocioNoControl AS DP1," +
                            "d.AndamentoCadastroDependentesdoSocioADM AS DP2," +
                            "d.AndamentoIplantacaodadosFolhaPg AS DP3," +
                            "f.AndamenoDistribuirFuncionarioInterno AS FISC1," +
                            "f.AndamentoValidarPerfilFiscal AS FISC2," +
                            "r.AndamentoEnviarTernoReponsaParaComercial AS REG1," +
                            "r.AndamentoArquivarProcesso AS REG2 " +
                            "from comercial as a " +
                            "inner join contabil as b " +
                            "on a.Numerodoprocesso= b.Numerodoprocesso " +
                            "inner join contratos as c " +
                            "on b.Numerodoprocesso=c.Numerodoprocesso " +
                            "inner join fiscal as f " +
                            "on c.Numerodoprocesso=f.Numerodoprocesso " +
                            "inner join dp as d " +
                            "on f.Numerodoprocesso=d.Numerodoprocesso " +
                            "inner join regularizacao as r " +
                            "on d.Numerodoprocesso= r.Numerodoprocesso " +
                            "where a.Numerodoprocesso=?";;
    try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, processo);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    rsTextoDepartamento(tela, rs);
                    }
//            statusTabel(tbRecebimento);
//            statusTabel(tbSolicitacao);
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao realizar a consulta!\n" +erro);
            }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    
    private void rsTextoDepartamento(String tela, ResultSet rs) throws SQLException{
        if(tela.equals("Comercial")){
            textoDepartamento("Taxa De ImplantacaoEFormaDePagamento", rs.getString("COMERCIAL1"));
            textoDepartamento("Gravar Senhas Fiscais", rs.getString("COMERCIAL2"));
            textoDepartamento("Gerar OS", rs.getString("COMERCIAL3"));
            textoDepartamento("Enviar Termo Responsaparacliente", rs.getString("COMERCIAL4"));
            textoDepartamento("Propasta Comercial", rs.getString("COMERCIAL5"));
            textoDepartamento("Envio Diagnose", rs.getString("COMERCIAL6"));
            textoDepartamento("Pesquisa Fiscal", rs.getString("COMERCIAL7"));
            textoDepartamento("Requisicao Documentos", rs.getString("COMERCIAL8"));
            textoDepartamento("Confirmar RecebimentoDeposito", rs.getString("COMERCIAL9"));
        }
        else if(tela.equals("Contabil")){
            textoDepartamento("Gerar Plano De Contas", rs.getString("CONTABIL1"));
        }
        else if(tela.equals("Contratos")){
            textoDepartamento("Elaborar Contrato Prestacao De Servico", rs.getString("CONTRATOS1"));
            textoDepartamento("Cadastrar Control E Contmatic", rs.getString("CONTRATOS2"));
            textoDepartamento("Ativar Cliente", rs.getString("CONTRATOS3"));
            textoDepartamento("Elaborar Perfil Fiscal", rs.getString("CONTRATOS4"));
            textoDepartamento("Receber Contrato Assinatura Cliente", rs.getString("CONTRATOS5"));
            textoDepartamento("Gerar ID No Cadastro", rs.getString("CONTRATOS6")); 
        }
        else if(tela.equals("Fiscal")){
            textoDepartamento("Distribuir a Funcionario Interno", rs.getString("FISC1"));
            textoDepartamento("Validar Perfil Fiscal", rs.getString("FISC2"));
        }
        else if(tela.equals("Pessoal")){
            textoDepartamento("CadastroDoSocioNoControl", rs.getString("DP1"));
            textoDepartamento("Cadastro Dependentes do Socio ADM", rs.getString("DP2"));
            textoDepartamento("Implantacao de Dados na Folha Pg", rs.getString("DP3"));
        }
        else if (tela.equals("Regularizacao")){
            textoDepartamento("Enviar Termo de Reponsabilidade Para Comercial", rs.getString("REG1"));
            textoDepartamento("Arquivar Processo", rs.getString("REG2"));
        }
    }
    private void rsTextoDocumentos(int processo, String tela, ResultSet rs) throws SQLException{
        apelidoCliente = rs.getString("Apelido");
        pegaNome(processo);
        
        if(tela.equals("Comercial")){
            //area contratos
            textoDocumentosComercial("Ato Constitutivo",rs.getString("AtoConstitutivo"));
            textoDocumentosComercial("Documentos do Socio",rs.getString("RGeCPFSocio"));
            textoDocumentosComercial("Comprovantes dos Sócios",rs.getString("ComprovanteResidencia"));
            textoDocumentosComercial("Numero Pis",rs.getString("NumeroPIS"));
            textoDocumentosComercial("Habilitar NFe PMSP",rs.getString("AutorizacaoNotaFiscalEletronica"));
            textoDocumentosComercial("Senha Posto Fiscal",rs.getString("SenhaPostoFiscal"));
            textoDocumentosComercial("Senha Simples Nacional",rs.getString("SenhaSimplesNacional"));
            textoDocumentosComercial("Perfil Fiscal PMSP",rs.getString("ConfigurarPerfilFiscalNoSitePrefeituraDocumento"));
                        
            //area contabil
            textoDocumentosComercial("Balanço e D.R.E",rs.getString("BalancoDRE"));
            textoDocumentosComercial("Contas Patrimoniais",rs.getString("ComposicaoDeContasPatrimoniais"));
            textoDocumentosComercial("Plano de Contas",rs.getString("PlanoDeContas"));
            textoDocumentosComercial("Balancete",rs.getString("BalanceteExercicio"));
            //departamento pessoal
            textoDocumentosComercial("Folha de Pagamento",rs.getString("FolhadePagamentoDocumento"));
            textoDocumentosComercial("Fichs de Funcionários",rs.getString("LivroOuFichadeRegistroFuncionario"));
            textoDocumentosComercial("Caged",rs.getString("CAGED"));
            textoDocumentosComercial("Recisões",rs.getString("Recisao"));
            textoDocumentosComercial("Recibo de Férias",rs.getString("Ferias"));
            textoDocumentosComercial("Afastamentos",rs.getString("Afastamento"));
            //regularizacao senhas
            textoDocumentosComercial("Senha Receita Federal",rs.getString("OutorgaSenhaEletronicaReceita"));
            textoDocumentosComercial("Termo Resp.Tecnica",rs.getString("TermodeResponsabilidadeDocumento"));
            textoDocumentosComercial("Senha do Inss",rs.getString("SenhaINSS"));
        }
        else if(tela.equals("Contabil")){
            textoDocumentosOutros("Balanço e D.R.E",rs.getString("BalancoDRE"));
            textoDocumentosOutros("Contas Patrimoniais",rs.getString("ComposicaoDeContasPatrimoniais"));
            textoDocumentosOutros("Plano de Contas",rs.getString("PlanoDeContas"));
            textoDocumentosOutros("Balancete",rs.getString("BalanceteExercicio"));
        }
        else if(tela.equals("Contratos")){
            //area contratos
            textoDocumentosOutros("Ato Constitutivo",rs.getString("AtoConstitutivo"));
            textoDocumentosOutros("Documentos do Socio",rs.getString("RGeCPFSocio"));
            textoDocumentosOutros("Comprovantes dos Sócios",rs.getString("ComprovanteResidencia"));
            textoDocumentosOutros("Numero Pis",rs.getString("NumeroPIS"));
            textoDocumentosOutros("Habilitar NFe PMSP",rs.getString("AutorizacaoNotaFiscalEletronica"));
            textoDocumentosOutros("Senha Posto Fiscal",rs.getString("SenhaPostoFiscal"));
            textoDocumentosOutros("Senha Simples Nacional",rs.getString("SenhaSimplesNacional"));
            textoDocumentosOutros("Perfil Fiscal PMSP",rs.getString("ConfigurarPerfilFiscalNoSitePrefeituraDocumento"));
        }
        else if(tela.equals("Regularizacao")){
            textoDocumentosOutros("Senha Receita Federal",rs.getString("OutorgaSenhaEletronicaReceita"));
            textoDocumentosOutros("Termo Resp.Tecnica",rs.getString("TermodeResponsabilidadeDocumento"));
            textoDocumentosOutros("Senha do Inss",rs.getString("SenhaINSS"));
        }
        else if(tela.equals("Pessoal")){
            textoDocumentosOutros("Folha de Pagamento",rs.getString("FolhadePagamentoDocumento"));
            textoDocumentosOutros("Fichs de Funcionários",rs.getString("LivroOuFichadeRegistroFuncionario"));
            textoDocumentosOutros("Caged",rs.getString("CAGED"));
            textoDocumentosOutros("Recisões",rs.getString("Recisao"));
            textoDocumentosOutros("Recibo de Férias",rs.getString("Ferias"));
            textoDocumentosOutros("Afastamentos",rs.getString("Afastamento"));
        }
    }
    private void pegaNome(int processo){
    Connection con = new ConexaoStatement().getConnetion();
    String sql = "select SUBSTRING_INDEX(SUBSTRING_INDEX(Cliente, ' ', 3), ' ', -3) as Cliente "
            + "from cadastrodeprocesso where codNumerodoprocesso=?";
    try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, processo);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    this.nomeCliente = rs.getString("Cliente");
                    if(this.html==true){
                        this.nomeCliente = conversor.Converter(nomeCliente);
                    }
                }
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao realizar a consulta!\n" +erro);
            }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    private void textoDepartamento(String label, String valor){
        if(valor.trim().equals("Em Aberto") || valor.trim().equals("")){
            if(this.html==true){
                textoDepartamento+="<li>"+conversor.Converter(label)+"</li>";
            }
            else if(!this.textoDepartamento.equals("") && this.html==false)
                this.textoDepartamento+="\n"+conversor.Converter(label);
            else if(this.textoDepartamento.equals("") && this.html==false)
                this.textoDepartamento+=conversor.Converter(label);
            //contar
            this.contagemDepartamento+=1;
        }
        else
            this.textoDepartamento+="";
    }
    private void contarDocumentos(String valor){
        int novoValor=1;
        if(valor.trim().equals("Aguardando Validação")){
            this.contagemDocumentos+=novoValor;
        }
    }
    private void contarDocumentosComercial(String valor){
        if(!valor.trim().equals("Validação Efetuada") && !valor.trim().equals("Aguardando Validação")){
            //acumula comercial
            this.contagemDocumentos+=1;
        }
    }
    private void textoDocumentosOutros(String nomeLabel, String valor){
        contarDocumentos(valor);
        if(valor.trim().equals("Aguardando Validação")){
            if(this.html==true){
                this.textoDocumentos+="<li>"+conversor.Converter(nomeLabel)+"</li>";
            }
            else if(!this.textoDocumentos.equals("") && this.html==false)
                this.textoDocumentos+="\n"+conversor.Converter(nomeLabel);
            else if(this.textoDocumentos.equals("") && this.html==false)
                this.textoDocumentos+=conversor.Converter(nomeLabel);
        }
        else
            this.textoDocumentos+="";
    }
    
    private void textoDocumentosComercial(String nomeLabel, String valor){
        contarDocumentosComercial(valor);
        if(valor.trim().equals("") || valor.contains("Em Aberto") || valor.contains("Enviado")){
            if(this.html==true){
                this.textoDocumentos+="<li>"+conversor.Converter(nomeLabel)+"</li>";
            }
            else if(!this.textoDocumentos.equals("") && this.html==false)
                this.textoDocumentos+="\n"+conversor.Converter(nomeLabel);
            else if(this.textoDocumentos.equals("") && this.html==false)
                this.textoDocumentos+=conversor.Converter(nomeLabel);
        }
        else
            this.textoDocumentos+="";
    }
    public String getTabelaContador(){
        if(this.html==true){
            this.tabelaContagem="<tr><td style=\"text-align: center;\"><strong>"+apelidoCliente+"</strong></td>"+
                "<td style=\"text-align: center;\"><strong>"+nomeCliente+"</strong></td>"
                    + "<td style=\"text-align: center;\">"+this.contagemDepartamento+"</td>"
                    + "<td style=\"text-align: center;\">"+this.contagemDocumentos+"</td></tr>";
        }
        else{
            //criar modelo para o relatorio
        }
        return this.tabelaContagem;
    }
    public String getTabelaDocumentos(){
        if(this.html==true){
            String novoTexto="";
            if(textoDocumentos.equals("")){
                novoTexto="<p></p>";
            }
            else
                novoTexto="<ul>"+textoDocumentos+"</ul>";
            this.tabelaDocumentos="<tr>" +
                                    "<td><strong>"+apelidoCliente+"</strong></td>" +
                                    "<td><strong>"+nomeCliente+"</strong></td>" +
                                    "<td>"+novoTexto+"</td>"+
                                    "</tr>";
        }
        return this.tabelaDocumentos;
    }
    public String getTabelaDepartamento(){
        if(this.html==true){
            String novoTexto="";
            if(textoDepartamento.equals("")){
                novoTexto="<p></p>";
            }
            else
                novoTexto="<ul>"+textoDepartamento+"</ul>";
            this.tabelaDepartamento="<tr>" +
                                "<td><strong>"+apelidoCliente+"</strong></td>" +
                                "<td><strong>"+nomeCliente+"</strong></td>"+
                                "<td>"+novoTexto+"</td>"+
                                "</tr>";
        }
        return this.tabelaDepartamento;
    }
    public int getContaTudo(int valor){
        return this.contagemTudo = valor+this.contagemDepartamento+this.contagemDocumentos;
    }
      
}
