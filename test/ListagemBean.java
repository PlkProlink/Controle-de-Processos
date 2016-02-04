
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
public class ListagemBean {
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
    boolean relatorio=false;
//essa area é dedica a area de consulta
    static String comando;
    private String situacao=null; //correspondente a situaçao, aberto, fechado, todos
    private String pesquisa=null; //pesquisa nome, id, empresa, 
    private String pega_ano=null;
    private String valorPesquisa=""; //pega o valor txtField de listagem
    
    Listagem listagem;
    
    /*Inicia 
    
    aqui
    
    */
    
    public int getCod(){
        return cod;
    }
    public void setCod(int cod){
        this.cod=cod;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        //clausula para converter data caso exista e caso tenha o caractere - (yyyy-mm-dd)
        int pos = data.indexOf("-");
        if(data.length()==10 && pos!=-1){
            String ano = data.substring(0, 4);
            String mes = data.substring(5, 7);
            String dia = data.substring(8);
            String recebeMysql = dia+"/"+mes+"/"+ano;
            this.data = recebeMysql;
        }
        else
            this.data=data;
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
    
    public String getDataRecebimento(){
        return dataRecebimento;
    }
    
    public void setDataRecebimento(String dataRecebimento){
        //clausula para converter data caso exista e caso tenha o caractere / (dd/mm/aaaa)
        int pos = dataRecebimento.indexOf("/");
        if(dataRecebimento.trim().length()==10 && pos!=-1){
            String dia = dataRecebimento.substring(0, 2);
            String mes = dataRecebimento.substring(3, 5);
            String ano = dataRecebimento.substring(6);
            String enviaBanco = ano+"-"+mes+"-"+dia;
            this.data = enviaBanco;
        }
        else
            this.data=data;
        
        this.dataRecebimento=dataRecebimento;
    }
    
    public String getRecebido(){
        return recebido;
    }
    
    public void setRecebido(String recebido){
        this.recebido= recebido;
    }

    /*Termina aqui os campos da tabela*/
    
    

    /**
     * @param comando the comando to set
     */
    public void setComando(String comando) {
        this.comando = comando;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the pega_ano
     */
    public String getPegaAno() {
        return pega_ano;
    }

    /**
     * @param pega_ano the pega_ano to set
     */
    public void setPegaAno(String pega_ano) {
        this.pega_ano = pega_ano;
    }

    /**
     * @return the valorPesquisa
     */
    public String getValorPesquisa() {
        return valorPesquisa;
    }

    /**
     * @param valorPesquisa the valorPesquisa to set
     */
    public void setValorPesquisa(String valorPesquisa) {
        this.valorPesquisa = valorPesquisa;
    }
    
    /*Metodos para consulta*/
    
    void liberarRelatorio(){
        this.relatorio = true;
    }
    
    void bloquearRelatorio(){
        this.relatorio = false;
    }
    
    //gerar relatorio na tela
    boolean gerarRelatorioPDF(){
        RelatorioRecepcao relatorioView = new RelatorioRecepcao();
        buscar();
        if(relatorio==false){
            JOptionPane.showMessageDialog(null, "Relatório não liberado!\n"
                    + "Verifique as informações foram marcadas corretamente!");
            return false;
        } 
        else {
            relatorioView.setComando(this.comando);
            relatorioView.listagem();
            return true;
        }
        
        
    }
    //criar e salvar relatorio excel
    boolean gerarRelatorioExcel(){
        ListagemExcel toExcel = new ListagemExcel();
        buscar();
        if(relatorio==false){
            JOptionPane.showMessageDialog(null, "Relatório não liberado!\n"
                    + "Verifique as informações foram marcadas corretamente!");
            return false;
        } 
        else {
            toExcel.setComando(this.comando);
            toExcel.openFileChooser();
            return true;
        }
    }
    //1ª busca do usuario
    void carrega_usuario(){
        this.setComando("select * from documentos_recebidos where Para_Quem like '"+Login.usuario+"' and Recebido='N'");
        listagem.preencher_tabela();
    }
    
    void buscar(){
        if(this.pesquisa == null){
        JOptionPane.showMessageDialog(null, "Selecione o Status!(Protocolo, ID, Funcionario, Geral)");
        bloquearRelatorio();
    }
    else if(this.pesquisa==null){
        if(this.situacao==null){
            JOptionPane.showMessageDialog(null, "Selecione o Status!(Aberto, Fechado)");
            bloquearRelatorio();
        }
        else{
            listagem.verificarData();
            gerarConsulta();
            liberarRelatorio();
        }
    }
    else if(this.valorPesquisa.trim().equals("")){
        JOptionPane.showMessageDialog(null, "Vefique o campo digitado, não pode ficar em branco");
        bloquearRelatorio();
    }
    else if(this.pesquisa=="Protocolo"){
        gerarConsulta();
        
    }
    else if(this.situacao==null){
        JOptionPane.showMessageDialog(null, "Selecione o Status!(Aberto, Fechado)");
        bloquearRelatorio();
    }
    else
        listagem.verificarData();
    //pega o resultado geral
    }
    
    void tratarDatas(String ndata1, String ndata2){
        String data1 = ndata1;
        String dia1 = data1.substring(0, 2);
        String mes1 = data1.substring(3, 5);
        String ano1 = data1.substring(6);
        String campo1 = ano1+"-"+mes1+"-"+dia1;

        String data2 = ndata2;
        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6);
        String campo2 = ano2+"-"+mes2+"-"+dia2;
        
        this.pega_ano = " and Data_Recebimento between '"+campo1+"' and '"+campo2+"'";
        
        gerarConsulta();
        liberarRelatorio();
    }
    
    void gerarConsulta(){
        switch (this.pesquisa) {
            case "Protocolo":
                    listagem.limpar_tabela();
                    this.comando = ("select * from documentos_recebidos where cod="
                            +valorPesquisa+" order by cod desc");
                    listagem.preencher_tabela();
                    break;
                
            case "Geral":
                    listagem.limpar_tabela();
                    this.comando = ("select * from documentos_recebidos where " 
                            +situacao+ "" +pega_ano);
                    listagem.preencher_tabela();
                    break;
            case "ID":
                    listagem.limpar_tabela();
                    comando = ("select * from documentos_recebidos where ID='"
                            +valorPesquisa+"' and " + situacao + "" + pega_ano);
                    listagem.preencher_tabela();
                    break;
            default:
                    listagem.limpar_tabela();
                    comando = ("select * from documentos_recebidos where "
                            +pesquisa+"'"+valorPesquisa+"' and "+situacao+""+pega_ano);
                        listagem.preencher_tabela();
                    break;
        }
        
    }
    

    
    
}
