package br.com.prolink.recepcao;


import br.com.prolink.login.Login;
import br.com.prolink.relatorios.RelatorioRecepcao;
import br.com.prolink.relatorios.exportExcel.ListagemExcel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tiago
 */
public class ControleRecepcaoBean {

    private int cod;
    private String data;
    private String hora;
    private String id;
    private String empresa;
    private String entreguepor;
    private String historico;
    private String para;
    private String departamento;
    private String quemrecebeu;
    private String observacao;
    private String dataRecebimento;
    private String recebido;
//essa area é dedica a area de consulta
    private final String usuario = Login.usuario;
    private String valorPesquisa;
    private String data1,data2;
    private String comando;
    ControleRecepcao controle;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        //clausula para converter data caso exista e caso tenha o caractere - (yyyy-mm-dd)
        int pos = data.indexOf("-");
        if (data.length() == 10 && pos != -1) {
            String ano = data.substring(0, 4);
            String mes = data.substring(5, 7);
            String dia = data.substring(8);
            String recebeMysql = dia + "/" + mes + "/" + ano;
            this.data = recebeMysql;
        } else {
            this.data = data;
        }
    }

    public String getUsuario(){
        return usuario;
    }
    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the entreguepor
     */
    public String getEntreguePor() {
        return entreguepor;
    }

    /**
     * @param recebidopor the entreguepor to set
     */
    public void setEntreguePor(String recebidopor) {
        this.entreguepor = recebidopor;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @param historico the historico to set
     */
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * @return the para
     */
    public String getPara() {
        return para;
    }

    /**
     * @param para the para to set
     */
    public void setPara(String para) {
        this.para = para;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the quemrecebeu
     */
    public String getQuemrecebeu() {
        return quemrecebeu;
    }

    /**
     * @param quemrecebeu the quemrecebeu to set
     */
    public void setQuemrecebeu(String quemrecebeu) {
        this.quemrecebeu = quemrecebeu;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        //clausula para converter data caso exista e caso tenha o caractere / (dd/mm/aaaa)
        int pos = dataRecebimento.indexOf("/");
        if (dataRecebimento.trim().length() == 10 && pos != -1) {
            String dia = dataRecebimento.substring(0, 2);
            String mes = dataRecebimento.substring(3, 5);
            String ano = dataRecebimento.substring(6);
            String enviaBanco = ano + "-" + mes + "-" + dia;
            this.data = enviaBanco;
        } else {
            this.data = dataRecebimento;
        }

        this.dataRecebimento = dataRecebimento;
    }

    public String getRecebido() {
        return recebido;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }
    /**
     * @return the valorPesquisa
     */
    //gerar relatorio na tela
    public boolean gerarRelatorioPDF() {
        RelatorioRecepcao relatorioView = new RelatorioRecepcao();
        buscar(this.data1, this.data2, this.valorPesquisa);
        if (controle.relatorio == false) {
            JOptionPane.showMessageDialog(null, "Relatório não liberado!\n"
                    + "Verifique se as informações foram marcadas corretamente!");
            return false;
        } else {
            relatorioView.setComando(this.comando);
            relatorioView.listagem();
            return true;
        }

    }

    //criar e salvar relatorio excel

    public boolean gerarRelatorioExcel() {
        ListagemExcel toExcel = new ListagemExcel();
        buscar(this.data1, this.data2, valorPesquisa);
        if (controle.relatorio == false) {
            JOptionPane.showMessageDialog(null, "Relatório não liberado!\n"
                    + "Verifique se as informações foram marcadas corretamente!");
            return false;
        } else {
            toExcel.setComando(this.comando);
            toExcel.openFileChooser();
            return true;
        }
    }

    //1ª busca do usuario
        public boolean buscar(String data1, String data2, String valorPesquisa) {
        this.data1 = data1; this.data2=data2; this.valorPesquisa=valorPesquisa;
        if ("".equals(controle.pesquisa)) {
            JOptionPane.showMessageDialog(null, "Selecione o Status!(Protocolo, ID, Funcionario, Geral)");
            controle.relatorio = false;
            return false;
        }
        else{
            switch (controle.pesquisa) {
                case "Geral":
                case "Protocolo":
                    if(controle.pesquisa.equals("Protocolo") && valorPesquisa.equals("")){
                        JOptionPane.showMessageDialog(null, "Vefique o campo digitado, não pode ficar em branco");
                        controle.relatorio = false;
                        return false;
                        
                    }
                    else if(controle.pesquisa.equals("Geral") && controle.situacao.equals("")){
                        JOptionPane.showMessageDialog(null, "Selecione o Status!(Aberto, Fechado)");
                        controle.relatorio = false;
                        return false;
                    }
                    
                    else
                        verificarData();
                    controle.relatorio = true;
                    break;
                case "ID":
                case "ParaQuem":
                    if(valorPesquisa.equals("")){
                        JOptionPane.showMessageDialog(null, "Vefique o campo digitado, não pode ficar em branco");
                        controle.relatorio = false;
                        return false;
                    }
                    else if(controle.situacao.equals("")){
                        JOptionPane.showMessageDialog(null, "Selecione o Status!(Aberto, Fechado)");
                        controle.relatorio = false;
                        return false;
                    }
                    else{
                        verificarData();
                        controle.relatorio = true;
                }   break;
            }
        }
        return true;
    }
    boolean verificarData(){
        
        if(controle.check.isSelected()){
            if(data1.trim().length()<10 || data2.trim().length()<10){
                JOptionPane.showMessageDialog(null, "Verifique a data informada!");
                controle.relatorio=false;
                return false;
            }
            else{
                tratarDatas();
                return true;
            }
        }
        else{
            controle.pegaAno="";
            gerarConsulta();
            controle.relatorio = true;
            return true;
        }
}
    void tratarDatas() {
        String dia1 = data1.substring(0, 2);
        String mes1 = data1.substring(3, 5);
        String ano1 = data1.substring(6);
        String campo1 = ano1 + "-" + mes1 + "-" + dia1;

        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6);
        String campo2 = ano2 + "-" + mes2 + "-" + dia2;

        controle.pegaAno = " and Data_Recebimento between '" + campo1 + "' and '" + campo2 + "'";

        gerarConsulta();
        controle.relatorio = true;
    }

    boolean gerarConsulta() {
        switch (controle.pesquisa) {
            case "Protocolo":
                this.comando=("select * from documentos_recebidos where cod="
                        + valorPesquisa + " order by cod desc");
//                controle.preencher_tabela();
                break;

            case "Geral":
                this.comando=("select * from documentos_recebidos where "
                        + controle.situacao + "" + controle.pegaAno);
//                controle.preencher_tabela();
                break;
            case "ID":
                this.comando=("select * from documentos_recebidos where ID='"
                        + valorPesquisa + "' and " + controle.situacao + "" + controle.pegaAno);
//                controle.preencher_tabela();
                break;
            case "ParaQuem":
                this.comando=("select * from documentos_recebidos where "
                        + "Para_Quem like '" + this.valorPesquisa + "' and " + controle.situacao + "" + controle.pegaAno);
//                controle.preencher_tabela();
                break;
        }
        return true;
    }
    public void setComando(String comando){
        this.comando = comando;
    }
    public String getComando(){
        return comando;
    }

}