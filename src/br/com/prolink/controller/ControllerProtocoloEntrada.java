package br.com.prolink.controller;

import br.com.prolink.factory.ConfigTables;
import br.com.prolink.model.Cliente;
import br.com.prolink.modeldao.ClienteDao;
import br.com.prolink.modeldao.Procedimento;
import br.com.prolink.modeldao.ProtocoloDao;
import br.com.prolink.model.ProtocoloEntrada;
import br.com.prolink.model.ProtocoloItem;
import br.com.prolink.modeldao.ProtocoloItemDao;
import br.com.prolink.model.Usuario;
import br.com.prolink.modeldao.UsuarioDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 *
 * @author Tiago
 */
public class ControllerProtocoloEntrada implements Initializable, ConfigTables {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Map<Usuario, String> usuariosDepartamentos = new HashMap<>();
    Map<String, Usuario> usuariosNome = new HashMap<>();
    Map<String, Cliente> clientes = new HashMap<>();
    ProtocoloDao dao;
    UsuarioDao userDao;
    ProtocoloItemDao itemDao;

    @FXML
    TableView<ProtocoloEntrada> tbPrincipal;
    @FXML
    Label txData;
    @FXML
    private JFXTextField txEntreguePor;
    @FXML
    private JFXTextField txCliente;
    @FXML
    private JFXRadioButton rbTudo;
    @FXML
    private JFXButton btSalvar;
    @FXML
    private JFXRadioButton rbApelido;
    @FXML
    private JFXButton btItemIncluir;
    @FXML
    private JFXDatePicker dtInicial;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXCheckBox ckInformarPeriodo;
    @FXML
    private TableView<ProtocoloItem> tbItem;
    @FXML
    private JFXTextArea txObservacao;
    @FXML
    private JFXButton btOk;
    @FXML
    private JFXComboBox<String> cbBusca;
    @FXML
    private JFXRadioButton rbUsuario;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btAlerta;
    @FXML
    private JFXRadioButton rbProtocolo;
    @FXML
    private JFXTextField txCodigo;
    @FXML
    private JFXComboBox<String> cbFuncionario;
    @FXML
    private JFXComboBox<Number> cbItemQuantidade;
    @FXML
    private JFXDatePicker dtFinal;
    @FXML
    private JFXComboBox<String> cbItemNome;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXRadioButton rbAberto;
    @FXML
    private JFXComboBox<String> cbDepartamento;
    @FXML
    private JFXTextArea txClienteNome;
    @FXML
    private JFXButton btExportar;
    @FXML
    private JFXRadioButton rbQualquer;
    @FXML
    private JFXRadioButton rbRecebido;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private AnchorPane pnCadastro;
    @FXML
    private JFXTextArea txDetalhes;
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private Tab tabCadastro, tabPesquisa;
    
    ToggleGroup pesquisa = new ToggleGroup();
    ToggleGroup status = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.getSelectionModel().select(tabCadastro);
        dao = new ProtocoloDao();
        List<ProtocoloEntrada> items = dao.listar();
        tbPrincipal.setItems(FXCollections.observableArrayList(items));
        tbPrincipal.setTableMenuButtonVisible(true);
        iniciarCombos();
        tratarTabela();
        tratarTabelaItems();
        tbItem.setTableMenuButtonVisible(true);
        radioButtons();
        limparTela();
    }

    @FXML
    void alerta(ActionEvent event) {
        enviarAlerta("Deseja enviar alerta por e-mail?");
    }

    @FXML
    void alterar(ActionEvent event) {
        if (!txCodigo.getText().equals("")) {
            desbloquear(true);
        }
    }

    @FXML
    void checarSelecao(ActionEvent event) {
        if (rbProtocolo.isSelected()) {
            cbBusca.getItems().clear();
            cbBusca.setDisable(false);
        } else if (rbApelido.isSelected()) {
            cbBusca.setDisable(false);
        } else if (rbUsuario.isSelected()) {
            Set<String> lista = new TreeSet<>();
            usuariosDepartamentos.keySet().forEach(u -> {
                lista.add(u.getUsuario());
            });
            cbBusca.setDisable(false);
            cbBusca.setItems(FXCollections.observableArrayList(lista));
        } else {
            cbBusca.setValue("");
            cbBusca.setDisable(true);
        }
        if (ckInformarPeriodo.isSelected()) {
            dtFinal.setDisable(false);
            dtInicial.setDisable(false);
        } else {
            dtFinal.setDisable(true);
            dtInicial.setDisable(true);
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        limparTela();
        desbloquear(false);
    }

    @FXML
    void excluir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exclusão...");
        alert.setHeaderText(null);
        if (!txCodigo.getText().equals("")) {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Tem certeza disso?");
            if (alert.showAndWait().get() == ButtonType.OK) {
                ProtocoloEntrada p = new ProtocoloEntrada();
                p.setId(Integer.parseInt(txCodigo.getText()));
                dao = new ProtocoloDao();
                if (dao.deletar(p)) {
                    limparTela();
                    for (ProtocoloEntrada c : tbPrincipal.getItems()) {
                        if (c.getId() == p.getId()) {
                            tbPrincipal.getItems().remove(c);
                            break;
                        }
                    }
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("Registro excluido com sucesso!");
                    alert.showAndWait();
                    desbloquear(false);
                }
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Selecione um registro e tente novamente!");
            alert.showAndWait();
        }
    }

    @FXML
    void executarPesquisa(ActionEvent event) {
        try {
            String sql = "select d.*, "
                    + "(select c." + CLIENTE_nome + " from " + CLIENTE + " as c where d." + DOCUMENTOS_RECEBIDOS_ID + "=c." + CLIENTE_id + ") AS EmpresaNome, "
                    + "(select l." + LOGIN_Usuario + " from " + LOGIN + " as l where d." + DOCUMENTOS_RECEBIDOS_para_quem_id + "=l." + LOGIN_cod + ") as ParaQuemNome,"
                    + "(select l." + LOGIN_Usuario + " from " + LOGIN + " as l where d." + DOCUMENTOS_RECEBIDOS_quem_recebeu_id + "=l." + LOGIN_cod + ") as QuemRecebeuNome"
                    + " from " + DOCUMENTOS_RECEBIDOS + " as d "
                    + " where " + DOCUMENTOS_RECEBIDOS_Data_Recebimento + " is not null";
            if (rbProtocolo.isSelected() && !cbBusca.getValue().equals("")) {
                sql += " and " + DOCUMENTOS_RECEBIDOS_cod + " like '" + cbBusca.getValue() + "%'";
                dao = new ProtocoloDao();
                List<ProtocoloEntrada> lista = dao.filtrar(sql);
                tbPrincipal.getItems().clear();
                tbPrincipal.setItems(FXCollections.observableArrayList(lista));
                return;
            } else if (rbApelido.isSelected() && !cbBusca.getValue().equals("")) {
                sql += " and " + DOCUMENTOS_RECEBIDOS_ID + " like '" + cbBusca.getValue() + "%'";
            } else if (rbUsuario.isSelected() && !cbBusca.getValue().equals("")) {
                int usuario = usuariosNome.get(cbBusca.getValue()).getCod();
                sql += " and " + DOCUMENTOS_RECEBIDOS_para_quem_id + " =" + usuario + "";
            }
            if (rbAberto.isSelected()) {
                sql += " and " + DOCUMENTOS_RECEBIDOS_Recebido + "='N'";
            } else if (rbRecebido.isSelected()) {
                sql += " and " + DOCUMENTOS_RECEBIDOS_Recebido + "='S'";
            }
            if (ckInformarPeriodo.isSelected()) {
                try {
                    LocalDate data1 = dtInicial.getValue();
                    LocalDate data2 = dtFinal.getValue();
                    if (data1.isAfter(data2)) {
                        return;
                    } else {
                        sql += " and " + DOCUMENTOS_RECEBIDOS_Data_Recebimento + " between '"
                                + data1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "' and '"
                                + data2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "'";
                    }
                } catch (NullPointerException e) {
                    return;
                }
            }
            dao = new ProtocoloDao();
            List<ProtocoloEntrada> lista = dao.filtrar(sql);
            tbPrincipal.getItems().clear();
            tbPrincipal.setItems(FXCollections.observableArrayList(lista));
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Campo valor não informado");
            alert.setHeaderText(null);
            alert.setContentText("Informe um valor para executar a sua busca!");
            alert.showAndWait();
        }
    }

    private void executeFiltro() {

    }

    public void iniciarlizarFormulario(ProtocoloEntrada p) {
        txCodigo.setText("" + p.getId());
        txEntreguePor.setText(p.getQuemEntregou());
        txCliente.setText(p.getApelido());
        txClienteNome.setText(p.getEmpresa());
        cbDepartamento.setValue(p.getDepartamento());
        cbFuncionario.setValue(p.getParaQuem());
        txObservacao.setText(p.getObservacao());
        txData.setText("Criado em: " + new SimpleDateFormat("dd/MM/yyyy").format(p.getDataRecebimento()));
        itemDao = new ProtocoloItemDao();
        List<ProtocoloItem> pi = (List<ProtocoloItem>) itemDao.receberLista("select * from " + PROTOCOLO_ITEM + " where " + PROTOCOLO_ITEM_item_prot_entrada_id + "=" + p.getId());
        tbItem.setItems(FXCollections.observableArrayList(pi));
    }

    @FXML
    void gerarExcel(ActionEvent event) {

    }

    private void iniciarCombos() {
        //combobox quantidade
        ObservableList<Number> numeros = FXCollections.observableArrayList();
        for (int i = 1; i <= 100; i++) {
            numeros.add(i);
        }
        cbItemNome.setItems(nomeItems());
        cbItemQuantidade.setItems(numeros);
        userDao = new UsuarioDao();
        List<Usuario> lista = (List<Usuario>) userDao.usuariosAtivos();
        Set<String> dep = new TreeSet<>();
        lista.forEach(u -> {
            usuariosDepartamentos.put(u, u.getDepartamento());
            usuariosNome.put(u.getUsuario(), u);
            dep.add(u.getDepartamento());
        });
        ObservableList<String> departamentos = FXCollections.observableArrayList();
        departamentos.addAll(dep);
        cbDepartamento.setItems(departamentos);
        //comboBoxFuncionarios

        ClienteDao daoCli = new ClienteDao();
        List<Cliente> todosClientes = daoCli.listar();
        todosClientes.forEach(c -> {
            clientes.put("" + c.getId(), c);
        });
        cbDepartamento.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                if (newValue!=null) {
                    cbFuncionario.getItems().clear();
                    usuariosDepartamentos.keySet().forEach(u -> {
                        if (u.getDepartamento().equals(newValue)) {
                            cbFuncionario.getItems().add(u.getUsuario());
                        }
                    });
                }
            } catch (NullPointerException e) {}
        });
    }

    @FXML
    void novoItem(ActionEvent event) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Falta de informação!");
        alert.setHeaderText(null);

        if (validarApelidoDigitado() && usuariosNome.containsKey(cbFuncionario.getValue())) {
            if (!txDetalhes.getText().equals("")) {
                try {
                    ProtocoloItem i = new ProtocoloItem();
                    i.setId(0);
                    i.setClienteId(Integer.parseInt(txCliente.getText()));
                    i.setNome(cbItemNome.getValue());
                    i.setQuantidade(cbItemQuantidade.getValue().intValue());
                    i.setDetalhe(txDetalhes.getText());
                    int responsavel = usuariosNome.get(cbFuncionario.getValue()).getCod();
                    i.setItem_responsavel_id(responsavel);
                    i.setPassivelDevolucao(0);
                    i.setEntregue(0);
                    tbItem.getItems().add(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.setContentText("O campo detalhes do documento não pode ficar em branco!");
                alert.showAndWait();
            }
        } else {
            alert.setContentText("Os campos cliente,funcionario e detalhes devem ser preencidos!");
            alert.showAndWait();
        }

    }

    private ObservableList<String> nomeItems() {
        ObservableList<String> itensNomes = FXCollections.observableArrayList();
        itensNomes.add("Aviso de Férias");
        itensNomes.add("Carimbo");
        itensNomes.add("Carta de Recomendação");
        itensNomes.add("Carteira de Trabalho");
        itensNomes.add("Certificado Digital A3");
        itensNomes.add("Comprovantes de Pagamentos Diversos");
        itensNomes.add("Diário Geral");
        itensNomes.add("Documentos Admissionais");
        itensNomes.add("Documentos de Abertura");
        itensNomes.add("Documentos de Alteração");
        itensNomes.add("Documentos de Encerramento");
        itensNomes.add("Documentos Demissionais");
        itensNomes.add("Documentos para Alteração Contratual");
        itensNomes.add("Documentos para Homologação");
        itensNomes.add("Documentos para Implantação");
        itensNomes.add("Documentos para Imposto de Renda");
        itensNomes.add("Documentos para Processos - Prefeitura");
        itensNomes.add("Documentos para Processos - Receita");
        itensNomes.add("Extrato");
        itensNomes.add("FGTS");
        itensNomes.add("DAS");
        itensNomes.add("DARF");
        itensNomes.add("GPS");
        itensNomes.add("Ficha de Plano de Saude");
        itensNomes.add("Guia Previdência Social");
        itensNomes.add("Livro de Registro");
        itensNomes.add("Midia (CD");
        itensNomes.add("Pen Drive)");
        itensNomes.add("Movimentação Financeira");
        itensNomes.add("Movimento Contabil");
        itensNomes.add("Movimento Fiscal (Notas Fiscais de Entrada");
        itensNomes.add("Saida)");
        itensNomes.add("Notas Fiscais(Entrada");
        itensNomes.add("Saida)");
        itensNomes.add("Outros");
        itensNomes.add("Procuração");
        return itensNomes;
    }

    private void limparTela() {
        ObservableList<Node> nodes = pnCadastro.getChildren();
        nodes.stream().forEach((n) -> {
            if (n instanceof JFXTextField) {
                ((JFXTextField) n).setText("");
            } else if (n instanceof JFXComboBox) {
                ((JFXComboBox)n).setValue(null);
            } else if (n instanceof JFXTextArea) {
                ((JFXTextArea) n).setText("");
            } else if (n instanceof TableView) {
                ((TableView) n).getItems().clear();
            }
        });
        cbItemNome.setValue("Outros");
        cbItemQuantidade.setValue(1);
        txData.setText("");
    }

    private void desbloquear(boolean value) {
        ObservableList<Node> nodes = pnCadastro.getChildren();
        nodes.stream().forEach((n) -> {
            if (n instanceof JFXTextField) {
                ((JFXTextField) n).setEditable(value);
            } else if (n instanceof JFXComboBox) {
                ((JFXComboBox) n).setDisable(!value);
            } else if (n instanceof JFXTextArea) {
                ((JFXTextArea) n).setEditable(value);
            } else if (n instanceof TableView) {
                ((TableView) n).setDisable(!value);
            }
        });
        cbItemNome.setValue("Outros");
        cbItemQuantidade.setValue(1);
        txData.setText("");
    }

    void enviarAlerta(String aviso) {
        if (txCodigo.getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Paramentro invalido");
            alert.setHeaderText(null);
            alert.setContentText("Selecione um registro e tente novamente!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText(aviso);
            Optional<ButtonType> resultado = alert.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                Procedimento procedimento = Procedimento.getInstance();
                dao = new ProtocoloDao();
                itemDao = new ProtocoloItemDao();
                ProtocoloEntrada p = (ProtocoloEntrada) dao.retornaClasse(Integer.parseInt(txCodigo.getText()));
                List<ProtocoloItem> pi = (List<ProtocoloItem>) itemDao.receberLista("select * from " + PROTOCOLO_ITEM + " where " + PROTOCOLO_ITEM_item_prot_entrada_id + "=" + p.getId());
                p.getItems().addAll(pi);
                String email = buscarEmail();
                if (email != null) {
                    procedimento.programarEnvioDocumentoRecebido(p, email, true);
                }
            }
        }
    }

    private String buscarEmail() {
        String contaEmail = usuariosNome.get(cbFuncionario.getValue()).getEmail();
        return contaEmail;
    }

    @FXML
    public void novo(ActionEvent event) {
        limparTela();
        desbloquear(true);
    }

    void radioButtons() {
        //inicializando propriedade togglegroup para os radiobuttons
        pesquisa.getToggles().add(rbTudo);
        pesquisa.getToggles().add(rbProtocolo);
        pesquisa.getToggles().add(rbApelido);
        pesquisa.getToggles().add(rbUsuario);
        status.getToggles().add(rbAberto);
        status.getToggles().add(rbRecebido);
        status.getToggles().add(rbQualquer);
    }

    @FXML
    void salvar(ActionEvent event) {
        if(!validarApelidoDigitado()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Paramentro invalido");
            alert.setHeaderText(null);
            alert.setContentText("Cliente não informado ou incorreto!");
            alert.showAndWait();
            return;
        }
        if(cbFuncionario.getSelectionModel().isEmpty() || cbDepartamento.getSelectionModel().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Paramentro invalido");
            alert.setHeaderText(null);
            alert.setContentText("Selecione quem irá receber e o seu departamento!");
            alert.showAndWait();
            return;
        }
        ProtocoloEntrada p = new ProtocoloEntrada();
        int user = usuariosNome.get(cbFuncionario.getValue()).getCod();
        SimpleDateFormat sdh = new SimpleDateFormat("HH:mm:ss");
        dao = new ProtocoloDao();
        itemDao = new ProtocoloItemDao();
        if (txCodigo.getText().equals("")) {
            p.setDataRecebimento(new Date());
            p.setQuemEntregou(txEntreguePor.getText());
            p.setApelido(txCliente.getText());
            p.setObservacao("");
            p.setDepartamento(cbDepartamento.getValue());
            p.setHora(sdh.format(new Date()));
            p.setAlerta("S");
            p.setRecebido("N");
            p.setParaQuemId(user);
            p.setAdiado(0);
            p.setAdiadoMotivo("");
            if (dao.inserir(p)) {
                txCodigo.setText("" + dao.getKey());
                if (itemDao.inserirOuAtualizar(tbItem.getItems(), dao.getKey())) {
                    enviarAlerta("Deseja enviar alerta por e-mail?");
                }
            }
            limparTela();
        } else {
            p = (ProtocoloEntrada)dao.retornaClasse(Integer.parseInt(txCodigo.getText()));
            p.setQuemEntregou(txEntreguePor.getText());
            p.setApelido(txCliente.getText());
            p.setObservacao(txObservacao.getText());
            p.setDepartamento(cbDepartamento.getValue());
            p.setId(Integer.parseInt(txCodigo.getText()));
            boolean otherUser = p.getParaQuemId()!=user;
            p.setParaQuemId(user);
            if (dao.atualizar(p)) {
                itemDao.inserirOuAtualizar(tbItem.getItems(), p.getId());
                p = (ProtocoloEntrada) dao.retornaClasse(p.getId());
                if(otherUser) enviarAlerta("Destinatário foi alterado, deseja enviar alerta por e-mail?");
                iniciarlizarFormulario(p);
                desbloquear(false);
            }
        }
        tbPrincipal.setItems(FXCollections.observableArrayList(dao.listar()));
    }

    @FXML
    void textoAdicionado(KeyEvent event) {
        if (!txCliente.getText().equals("")) {
            if (clientes.containsKey(txCliente.getText())) {
                txClienteNome.setText(clientes.get(txCliente.getText()).getNome());
                txClienteNome.setStyle("-fx-text-fill: red");
            } else {
                txClienteNome.setText("");
                txClienteNome.setStyle("");
            }
        } else {
            txCliente.setStyle("");
        }
    }

    public void tratarTabela() {
        TableColumn<ProtocoloEntrada, Number> colunaId = new TableColumn<>("Protocolo");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbPrincipal.getColumns().add(colunaId);
        TableColumn<ProtocoloEntrada, Date> colunaData = new TableColumn<>("Data");
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataRecebimento"));
        colunaData.setCellFactory((TableColumn<ProtocoloEntrada, Date> param) -> new TableCell<ProtocoloEntrada, Date>() {
            @Override
            protected void updateItem(Date item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(format.format(item));
                }
            }
        });
        tbPrincipal.getColumns().add(colunaData);
        TableColumn<ProtocoloEntrada, String> colunaHora = new TableColumn<>("Hora");
        colunaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tbPrincipal.getColumns().add(colunaHora);
        TableColumn<ProtocoloEntrada, String> colunaApelido = new TableColumn<>("Apelido");
        colunaApelido.setCellValueFactory(new PropertyValueFactory<>("apelido"));
        tbPrincipal.getColumns().add(colunaApelido);
        TableColumn<ProtocoloEntrada, String> colunaEmpresa = new TableColumn<>("Empresa");
        colunaEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        colunaEmpresa.setCellFactory((TableColumn<ProtocoloEntrada, String> param) -> new TableCell<ProtocoloEntrada, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                if (item==null){
                    setText(null);
                    setGraphic(null);
                }
                else {
                    String[] em = item.split(" ");
                    if (em.length >= 3) {
                        setText(em[0] + " " + em[1] + " " + em[2]);
                    } else {
                        setText(item);
                    }
                }
            }
        });
        tbPrincipal.getColumns().add(colunaEmpresa);
        TableColumn<ProtocoloEntrada, String> colunaParaQuem = new TableColumn<>("Para Quem");
        colunaParaQuem.setCellValueFactory(new PropertyValueFactory<>("paraQuem"));
        tbPrincipal.getColumns().add(colunaParaQuem);
        TableColumn<ProtocoloEntrada, String> colunaSetor = new TableColumn<>("Setor");
        colunaSetor.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        tbPrincipal.getColumns().add(colunaSetor);
        TableColumn<ProtocoloEntrada, String> colunaStatus = new TableColumn<>("Status");
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("recebido"));
        colunaStatus.setCellFactory((TableColumn<ProtocoloEntrada, String> param) -> new TableCell<ProtocoloEntrada, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                Label label = new Label();
                if (item == null) {
                    setText(null);
                    setStyle("");
                    setGraphic(null);
                } 
                else{
                    if (item.equals("N")) {
                        label.setText("Não Recebido");
                        label.setStyle("-fx-background-color:red;-fx-text-fill: white;");
                    } else if (item.equals("S")) {
                        label.setText("Entregue");
                        label.setStyle("-fx-background-color:green;-fx-text-fill: white;");
                    }
                    setGraphic(label);
                }
            }
        });
        tbPrincipal.getColumns().add(colunaStatus);

        TableColumn actionEdit = new TableColumn("");
        actionEdit.setCellValueFactory(new PropertyValueFactory<>("Editar"));
        Callback<TableColumn<ProtocoloEntrada, String>, TableCell<ProtocoloEntrada, String>> editFactory
                = (final TableColumn<ProtocoloEntrada, String> param) -> {
                    final TableCell<ProtocoloEntrada, String> cell = new TableCell<ProtocoloEntrada, String>() {
                final JFXButton btn = new JFXButton("Editar");
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.getStyleClass().add("btJFXDefault");
                        btn.setOnAction((ActionEvent event) -> {
                            ProtocoloEntrada prot = tbPrincipal.getItems().get(getIndex());
                            iniciarlizarFormulario(prot);
                            desbloquear(true);
                            tabPane.getSelectionModel().select(tabCadastro);
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        actionEdit.setCellFactory(editFactory);
        tbPrincipal.getColumns().add(actionEdit);

        TableColumn actionCol = new TableColumn("");
        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        Callback<TableColumn<ProtocoloEntrada, String>, TableCell<ProtocoloEntrada, String>> cellFactory
                = (final TableColumn<ProtocoloEntrada, String> param) -> {
                    final TableCell<ProtocoloEntrada, String> cell = new TableCell<ProtocoloEntrada, String>() {
                final JFXButton btn = new JFXButton("Remover");
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    btn.getStyleClass().add("btJFXDefault");
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        ProtocoloEntrada p = tbPrincipal.getItems().get(getIndex());
                        if (p.getRecebido().equals("S")) {
                            btn.setDisable(true);
                            btn.setText("Baixado");
                        } else {
                            btn.setDisable(false);
                            btn.setText("Remover");
                        }
                        btn.setOnAction((ActionEvent event) -> {
                            ProtocoloEntrada prot = tbPrincipal.getItems().get(getIndex());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Pedido de remoção...");
                            alert.setHeaderText(null);
                            alert.setContentText("Deseja remover o protocolo " + prot.getId() + "?");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                                ProtocoloDao dao = new ProtocoloDao();
                                if (dao.deletar(prot)) {
                                    tbPrincipal.getItems().remove(prot);
                                    alert.setAlertType(Alert.AlertType.INFORMATION);
                                    alert.setContentText("Removido com sucesso!");
                                    alert.showAndWait();
                                }
                                limparTela();
                                desbloquear(false);
                            }
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        actionCol.setCellFactory(cellFactory);
        tbPrincipal.getColumns().add(actionCol);
    }

    public void tratarTabelaItems() {
        TableColumn<ProtocoloItem, Number> colunaId = new TableColumn<>("*");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(40);
        TableColumn<ProtocoloItem, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaNome.setPrefWidth(120);
        TableColumn<ProtocoloItem, Number> colunaQuantidade = new TableColumn<>("Qtde");
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaQuantidade.setPrefWidth(50);
        TableColumn<ProtocoloItem, String> colunaDetalhes = new TableColumn<>("Detalhes");
        colunaDetalhes.setCellValueFactory(new PropertyValueFactory<>("detalhe"));
        colunaDetalhes.setPrefWidth(250);
        TableColumn actionCol = new TableColumn("");
        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        Callback<TableColumn<ProtocoloItem, String>, TableCell<ProtocoloItem, String>> cellFactory
                = (final TableColumn<ProtocoloItem, String> param) -> {
                    final TableCell<ProtocoloItem, String> cell = new TableCell<ProtocoloItem, String>() {
                final JFXButton btn = new JFXButton("Excluir");
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    btn.getStyleClass().add("btJFXDefault");
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction((ActionEvent event) -> {
                            ProtocoloItem prot = tbItem.getItems().get(getIndex());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Pedido de remoção...");
                            alert.setHeaderText(null);
                            alert.setContentText("Deseja remover o item " + prot.getId() + "?");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                                if (prot.getId() == 0) {
                                    tbItem.getItems().remove(prot);
                                } else {
                                    ProtocoloItemDao itemDao = new ProtocoloItemDao();
                                    if (itemDao.deletar(prot)) {
                                        tbItem.getItems().remove(prot);
                                        alert.setAlertType(Alert.AlertType.INFORMATION);
                                        alert.setContentText("Removido com sucesso!");
                                        alert.showAndWait();
                                    }
                                }
                            }
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        actionCol.setCellFactory(cellFactory);
        tbItem.getColumns().addAll(colunaId, colunaNome, colunaQuantidade, colunaDetalhes, actionCol);
    }

    private boolean validarApelidoDigitado() {
        try {
            Integer.parseInt(txCliente.getText());
            return clientes.get(txCliente.getText())!=null;
        } catch (Exception e) {
            return false;
        }
    }
}
