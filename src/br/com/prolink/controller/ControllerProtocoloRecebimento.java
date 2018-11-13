/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.controller;

import br.com.prolink.factory.ConfigTables;
import br.com.prolink.model.Cliente;
import br.com.prolink.model.ClienteDao;
import br.com.prolink.model.Procedimento;
import br.com.prolink.model.ProtocoloDao;
import br.com.prolink.model.ProtocoloEntrada;
import br.com.prolink.model.ProtocoloItem;
import br.com.prolink.model.ProtocoloItemDao;
import br.com.prolink.model.Usuario;
import br.com.prolink.model.UsuarioDao;
import br.com.prolink.model.UsuarioLogado;
import br.com.prolink.protocolos.ProtocoloView;
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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.Pair;
/**
 *
 * @author Tiago
 */
public class ControllerProtocoloRecebimento implements Initializable, ConfigTables {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Map<Usuario, String> usuariosDepartamentos = new HashMap<>();
    Map<String, Usuario> usuariosNome = new HashMap<>();
    Map<String, Cliente> clientes = new HashMap<>();
    Set<String> nomesAlfabetico = new TreeSet<>();

    ProtocoloDao dao;
    UsuarioDao userDao;
    ProtocoloItemDao itemDao;
    @FXML
    Label txData;
    @FXML
    TableView<ProtocoloEntrada> tbPrincipal;
    @FXML
    private JFXTextField txEntreguePor;
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
    private JFXDatePicker dtFinal;
    @FXML
    private JFXRadioButton rbAberto;
    @FXML
    private JFXComboBox<String> cbCliente;
    @FXML
    private JFXComboBox<String> cbDepartamento;
    @FXML
    private JFXTextField txClienteNome;
    @FXML
    private JFXButton btExportar;
    @FXML
    private JFXRadioButton rbQualquer;
    @FXML
    private JFXRadioButton rbRecebido;
    @FXML
    private JFXRadioButton rbDevolucaoPendente;
    @FXML
    private JFXRadioButton rbDevolvido;
    @FXML
    private AnchorPane pnCadastro;
    ToggleGroup pesquisa = new ToggleGroup();
    ToggleGroup status = new ToggleGroup();
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private Tab tabCadastro, tabPesquisa;
    @FXML
    private PieChart chart1;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.getSelectionModel().select(tabCadastro);
        dao = new ProtocoloDao();
        String sql = "select d.*, "
                + "(select c." + CLIENTE_nome + " from " + CLIENTE + " as c where d." + DOCUMENTOS_RECEBIDOS_ID + "=c." + CLIENTE_id + ") AS EmpresaNome, "
                + "(select l." + LOGIN_Usuario + " from " + LOGIN + " as l where d." + DOCUMENTOS_RECEBIDOS_para_quem_id + "=l." + LOGIN_cod + ") as ParaQuemNome, "
                + "(select l." + LOGIN_Usuario + " from " + LOGIN + " as l where d." + DOCUMENTOS_RECEBIDOS_quem_recebeu_id + "=l." + LOGIN_cod + ") as QuemRecebeuNome"
                + " from " + DOCUMENTOS_RECEBIDOS + " as d where d."
                + DOCUMENTOS_RECEBIDOS_para_quem_id + "="
                + UsuarioLogado.getInstance().getUsuario().getCod() + " and d."
                + DOCUMENTOS_RECEBIDOS_Recebido + "='N' or d."
                + DOCUMENTOS_RECEBIDOS_para_quem_id + "="
                + UsuarioLogado.getInstance().getUsuario().getCod() + " and d."
                + DOCUMENTOS_RECEBIDOS_passivel_devolucao + "=1 and d."
                + DOCUMENTOS_RECEBIDOS_devolvido + "=0";
        List<ProtocoloEntrada> items = dao.filtrar(sql);
        tbPrincipal.setItems(FXCollections.observableArrayList(items));
        tbPrincipal.setTableMenuButtonVisible(true);
        tbItem.setTableMenuButtonVisible(true);
        iniciarCombos();
        tratarTabela();
        tratarTabelaItems();
        radioButtons();
        preencherGrafico();
        limparTela();
        desbloquear(false);
        ObservableList<FadeTransition> arrayTransitions = FXCollections.observableArrayList();
        arrayTransitions.add(addFadeTransition(tabPane));
        arrayTransitions.add(addFadeTransition(tbPrincipal));
        initTransition(arrayTransitions);
    }

    @FXML
    void checarSelecao(ActionEvent event) {
        if (rbProtocolo.isSelected()) {
            cbBusca.getItems().clear();
            cbBusca.setDisable(false);
        } else if (rbApelido.isSelected()) {
            cbBusca.setDisable(false);
            cbBusca.setItems(cbCliente.getItems());
        } else if (rbUsuario.isSelected()) {
            cbBusca.setDisable(false);
            cbBusca.setItems(FXCollections.observableArrayList(nomesAlfabetico));
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
            } else if (rbDevolucaoPendente.isSelected()) {
                sql += " and " + DOCUMENTOS_RECEBIDOS_passivel_devolucao + "=1 and "
                        + DOCUMENTOS_RECEBIDOS_devolvido + "=0";
            } else if (rbDevolvido.isSelected()) {
                sql += " and " + DOCUMENTOS_RECEBIDOS_passivel_devolucao + "=1 and "
                        + DOCUMENTOS_RECEBIDOS_devolvido + "=1";
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

    public void iniciarlizarFormulario(ProtocoloEntrada p) {
        txCodigo.setText("" + p.getId());
        txEntreguePor.setText(p.getQuemEntregou());
        cbCliente.setValue(p.getApelido());
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
        userDao = new UsuarioDao();
        List<Usuario> lista = (List<Usuario>) userDao.usuariosAtivos();
        Set<String> dep = new TreeSet<>();
        lista.forEach(u -> {
            nomesAlfabetico.add(u.getUsuario());
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
            cbCliente.getItems().add("" + c.getId());
        });
        cbDepartamento.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                if (!newValue.equals("")) {
                    cbFuncionario.getItems().clear();
                    usuariosDepartamentos.keySet().forEach(u -> {
                        if (u.getDepartamento().equals(newValue)) {
                            cbFuncionario.getItems().add(u.getUsuario());
                        }

                    });
                }
            } catch (NullPointerException e) {
            }
        });
    }

    private void limparTela() {
        ObservableList<Node> nodes = pnCadastro.getChildren();
        nodes.stream().forEach((n) -> {
            if (n instanceof JFXTextField) {
                ((JFXTextField) n).setText("");
            } else if (n instanceof JFXComboBox) {
                ((JFXComboBox) n).setValue(null);
            } else if (n instanceof JFXTextArea) {
                ((JFXTextArea) n).setText("");
            } else if (n instanceof TableView) {
                ((TableView) n).getItems().clear();
            }
        });
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
                ((TableView) n).setEditable(value);
            }
        });
        txData.setText("");
    }

    void enviarAlerta(boolean trySucess) {
        if (txCodigo.getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Paramentro invalido");
            alert.setHeaderText(null);
            alert.setContentText("Selecione um registro e tente novamente!");
            alert.showAndWait();
        } else {
            String aviso = "Deseja enviar alerta por e-mail?";
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
                    procedimento.programarEnvioDocumentoRecebido(p, email, trySucess);
                }
            }
        }
    }

    private String buscarEmail() {
        String contaEmail = usuariosNome.get(cbFuncionario.getValue()).getEmail();
        return contaEmail;
    }

    @FXML
    void tabelaAcionada(MouseEvent event) {
        if (tbPrincipal.getSelectionModel().getSelectedIndex() != -1) {
            ProtocoloEntrada p = tbPrincipal.getSelectionModel().getSelectedItem();
            iniciarlizarFormulario(p);
            tabPane.getSelectionModel().select(tabCadastro);
        }
    }
    
    void preencherGrafico(){
        chart1.setTitle("Protocolo de Documentos - "+UsuarioLogado.getInstance().getUsuario().getNome());
        UsuarioDao uDao = new UsuarioDao();
        Map<String,Integer> map = uDao.protocoloEntrada(UsuarioLogado.getInstance().getUsuario());
        chart1.getData().clear();
        map.keySet().forEach(c->{ if(map.get(c)>0) chart1.getData().add(new PieChart.Data(c+"("+map.get(c)+")", map.get(c)));});
        chart1.setLabelsVisible(true);
        chart1.setLegendVisible(true);
        chart1.setLabelLineLength(10);
    }
    private FadeTransition addFadeTransition(Node node) {
        FadeTransition iTransition = new FadeTransition(Duration.millis(3000), node);
        iTransition.setFromValue(0);
        iTransition.setToValue(1);
        return iTransition;
    }
    private void initTransition(ObservableList<FadeTransition> transition) {
        ParallelTransition pTransition = new ParallelTransition();
        pTransition.getChildren().addAll(transition);
        pTransition.play();
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
        status.getToggles().add(rbDevolucaoPendente);
        status.getToggles().add(rbDevolvido);
    }

    public void tratarTabela() {
        TableColumn<ProtocoloEntrada, Number> colunaId = new TableColumn<>("*");
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
                    ProtocoloEntrada p = tbPrincipal.getItems().get(getIndex());
                    String[] hora = p.getHora().split(":");
                    setText(format.format(item) + " " + hora[0] + ":" + hora[1]);
                }
            }
        });
        tbPrincipal.getColumns().add(colunaData);

        TableColumn<ProtocoloEntrada, String> colunaStatus = new TableColumn<>("Status");
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("recebido"));
        colunaStatus.setCellFactory((TableColumn<ProtocoloEntrada, String> param) -> new TableCell<ProtocoloEntrada, String>() {
            final Label label = new Label();
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                if (item == null) {
                    setText(null);
                    setStyle("");
                    setGraphic(null);
                } else {
                    ProtocoloEntrada p = tbPrincipal.getItems().get(getIndex());
                    if (p.getRecebido().equals("N")) {
                        label.setText("Não recebido");
                        label.setStyle("-fx-background-color:red;-fx-text-fill: white;");
                    } else if (p.getPassivelDevolucao() == 1 && p.getDevolvido() == 0) {
                        if (p.getDevolverAte().before(new Date())) {
                            label.setText("Devolução Atrasada");
                            label.setStyle("-fx-background-color:red;-fx-text-fill: white;");
                        } else {
                            label.setText("No Prazo");
                            label.setStyle("-fx-background-color:green;-fx-text-fill: white;");
                        }
                    } else {
                        label.setText("Concluido");
                        label.setStyle("-fx-background-color:green;-fx-text-fill: white;");
                    }
                    setGraphic(label);
                }
            }

        });
        tbPrincipal.getColumns().add(colunaStatus);
        TableColumn<ProtocoloEntrada, Date> colunaDataDevolucao = new TableColumn<>("Devolver em");
        colunaDataDevolucao.setCellValueFactory(new PropertyValueFactory<>("devolverAte"));
        colunaDataDevolucao.setCellFactory((TableColumn<ProtocoloEntrada, Date> param) -> new TableCell<ProtocoloEntrada, Date>() {
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
        tbPrincipal.getColumns().add(colunaDataDevolucao);
        TableColumn<ProtocoloEntrada, String> colunaApelido = new TableColumn<>("Apelido");
        colunaApelido.setCellValueFactory(new PropertyValueFactory<>("apelido"));
        tbPrincipal.getColumns().add(colunaApelido);
        TableColumn<ProtocoloEntrada, String> colunaEmpresa = new TableColumn<>("Empresa");
        colunaEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        colunaEmpresa.setCellFactory((TableColumn<ProtocoloEntrada, String> param) -> new TableCell<ProtocoloEntrada, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                if (item == null) {
                    setText(null);
                } else {
                    String[] em = item.split(" ");
                    if (em.length >= 2) {
                        setText(em[0] + " " + em[1]);
                    } else {
                        setText(item);
                    }
                }
            }
        });
        tbPrincipal.getColumns().add(colunaEmpresa);
        TableColumn<ProtocoloEntrada, String> colunaQuemRecebeu = new TableColumn<>("De");
        colunaQuemRecebeu.setCellValueFactory(new PropertyValueFactory<>("quemEntregou"));
        tbPrincipal.getColumns().add(colunaQuemRecebeu);

        TableColumn<ProtocoloEntrada, String> colunaParaQuem = new TableColumn<>("Destino");
        colunaParaQuem.setCellValueFactory(new PropertyValueFactory<>("paraQuem"));
        tbPrincipal.getColumns().add(colunaParaQuem);

        TableColumn<ProtocoloEntrada, String> colunaSetor = new TableColumn<>("Setor");
        colunaSetor.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        tbPrincipal.getColumns().add(colunaSetor);

        TableColumn<ProtocoloEntrada, String> colunaRecebedor = new TableColumn<>("Recebido por");
        colunaRecebedor.setCellValueFactory(new PropertyValueFactory<>("quemRecebeu"));
        tbPrincipal.getColumns().add(colunaRecebedor);

//        TableColumn<ProtocoloEntrada, String> colunaObs = new TableColumn<>("Obs*");
//        colunaObs.setCellValueFactory(new PropertyValueFactory<>("observacao"));
//        tbPrincipal.getColumns().add(colunaObs);
//        
        TableColumn<ProtocoloEntrada, Date> colunaDataRecebimento = new TableColumn<>("Recebido em");
        colunaDataRecebimento.setCellValueFactory(new PropertyValueFactory<>("dataFuncionarioRecebeu"));
        colunaDataRecebimento.setCellFactory((TableColumn<ProtocoloEntrada, Date> param) -> new TableCell<ProtocoloEntrada, Date>() {
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
        tbPrincipal.getColumns().add(colunaDataRecebimento);
        TableColumn actionEdit = new TableColumn("Alterações");
        actionEdit.setCellValueFactory(new PropertyValueFactory<>("Encaminhar"));
        Callback<TableColumn<ProtocoloEntrada, String>, TableCell<ProtocoloEntrada, String>> editFactory
                = (final TableColumn<ProtocoloEntrada, String> param) -> {
                    final TableCell<ProtocoloEntrada, String> cell = new TableCell<ProtocoloEntrada, String>() {
                JFXButton btn = new JFXButton("Encaminhar");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    btn.getStyleClass().add("btJFXDefault");
                    setAlignment(Pos.CENTER);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        ProtocoloEntrada prot = tbPrincipal.getItems().get(getIndex());
                        if(prot.getRecebido()==null){
                            btn.setText("Erro");
                        }
                        else if(prot.getRecebido().equals("S")
                                && prot.getPassivelDevolucao() == 1
                                && prot.getDevolvido() == 1
                                || prot.getRecebido().equals("S")
                                && prot.getPassivelDevolucao() == 0) {
                            btn.setDisable(true);
                            btn.setText("Baixado");
                        } else if (prot.getRecebido().equals("N")) {
                            btn.setDisable(false);
                            btn.setText("Encaminhar");
                        } else if (prot.getRecebido().equals("S")
                                && prot.getPassivelDevolucao() == 1
                                && prot.getDevolvido() == 0) {
                            btn.setDisable(false);
                            btn.setText("Novo Prazo");
                        }
                        btn.setOnAction((ActionEvent event) -> {
                            if (btn.getText().equals("Encaminhar")) {
                                ProtocoloEntrada p = tbPrincipal.getItems().get(getIndex());
                                ChoiceDialog<String> dialog = new ChoiceDialog<>();
                                dialog.getItems().addAll(nomesAlfabetico);
                                dialog.getItems().remove(UsuarioLogado.getInstance().getUsuario().getUsuario());//sumir meu nome da lista
                                dialog.setSelectedItem(nomesAlfabetico.iterator().next());//inserir condição
                                dialog.setTitle("Alterar responsável");
                                dialog.setHeaderText("Por favor escolha um novo destino para esse protocolo");
                                dialog.setContentText("Escolha pelo nome:");
                                Optional<String> result = dialog.showAndWait();
                                if (result.isPresent()) {
                                    Usuario u = usuariosNome.get(result.get());
                                    p.setParaQuemId(u.getCod());
                                    p.setDepartamento(u.getDepartamento());
                                    dao = new ProtocoloDao();
                                    if (dao.atualizar(p)) {
                                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                        alert.setTitle("Atualização...");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Atualizado com sucesso!");
                                        alert.showAndWait();
                                        preencherGrafico();
                                        tbPrincipal.getItems().remove(p);
                                    }
                                }
                            } else if (btn.getText().equals("Novo Prazo")) {
                                ProtocoloEntrada p = prot;
                                Optional<Pair<LocalDate, String>> result2 = AlterarPrazo(p.getDevolverAte());
                                if (result2.isPresent()) {
                                    if (result2.get().getKey() != null) {
                                        LocalDate data2 = result2.get().getKey();
                                        p.setAdiado(1);
                                        p.setPassivelDevolucao(1);
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.set(data2.getYear(), data2.getMonthValue() - 1, data2.getDayOfMonth());
                                        p.setDevolverAte(calendar.getTime());
                                    } else {
                                        p.setPassivelDevolucao(0);
                                        p.setDevolverAte(null);
                                    }
                                    p.setAdiadoMotivo(result2.get().getValue());
                                    dao = new ProtocoloDao();
                                    if (dao.atualizar(p)) {
                                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                        alert.setTitle("Atualização...");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Atualizado com sucesso!");
                                        alert.showAndWait();
                                        preencherGrafico();
                                        tbPrincipal.getItems().set(getIndex(), p);
                                    }
                                }
                                //alterar prazo
//                                Optional<Pair<LocalDate, String>> result = AlterarPrazo(prot.getDevolverAte());
//                                if (result.isPresent()) {
//                                    result.ifPresent(u -> {
//                                        System.out.println("is pressed ok " + u.getKey() + " " + u.getValue());
//                                    });
//                                }

                            }
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        actionEdit.setCellFactory(editFactory);
        actionEdit.setPrefWidth(100);
        tbPrincipal.getColumns().add(actionEdit);

        TableColumn actionCol = new TableColumn("Conclusão");
        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        Callback<TableColumn<ProtocoloEntrada, String>, TableCell<ProtocoloEntrada, String>> cellFactory
                = (final TableColumn<ProtocoloEntrada, String> param) -> {
                    final TableCell<ProtocoloEntrada, String> cell = new TableCell<ProtocoloEntrada, String>() {
                final JFXButton btn = new JFXButton("Validar");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    btn.getStyleClass().add("btJFXDefault");
                    setAlignment(Pos.CENTER);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        ProtocoloEntrada prot = tbPrincipal.getItems().get(getIndex());
                        if(prot.getRecebido()==null){
                            btn.setText("Erro");
                        }
                        else if (prot.getRecebido().equals("N")) {
                            btn.setDisable(false);
                            btn.setText("Baixar");
                        } else if (prot.getRecebido().endsWith("S")
                                && prot.getPassivelDevolucao() == 1
                                && prot.getDevolvido() == 0) {
                            btn.setText("Devolver");
                            btn.setDisable(false);
                        } else {
                            btn.setText("Concluido");
                            btn.setDisable(true);
                        }
                        btn.setOnAction((ActionEvent event) -> {
                            if (btn.getText().equals("Baixar")) {
                                ProtocoloEntrada p = tbPrincipal.getItems().get(getIndex());
                                TextInputDialog dialog = new TextInputDialog("");
                                dialog.setTitle("Confirmar recebimento...");
                                dialog.setHeaderText(null);
                                dialog.setContentText("Informe uma observação (opcional):");
                                Optional<String> result = dialog.showAndWait();
                                if (result.isPresent()) {
                                    //baixar o documento
                                    Optional<Pair<LocalDate, Boolean>> result2 = Baixar();
                                    if (result2.isPresent()) {
                                        p.setObservacao(result.get());
                                        p.setQuemRecebeuId(UsuarioLogado.getInstance().getUsuario().getCod());//receber o usuario logado
                                        if (result2.get().getValue() == true) {
                                            LocalDate data2 = result2.get().getKey();
                                            p.setPassivelDevolucao(1);
//                                            p.setDevolverAte(new Date(data2.getYear(), data2.getMonthValue() - 1, data2.getDayOfMonth()));
                                            p.setDevolverAte(Date.from(data2.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                                        }
                                        p.setRecebido("S");
                                        p.setDataFuncionarioRecebeu(new Date());
                                        dao = new ProtocoloDao();
                                        if (dao.atualizar(p)) {
                                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                            alert.setTitle("Atualização...");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Atualizado com sucesso!");
                                            alert.showAndWait();
                                            preencherGrafico();
                                            tbPrincipal.getItems().set(getIndex(), p);
                                        }
                                    }
                                }
                            } else if (btn.getText().equals("Devolver")) {
                                Alert alert = new Alert(AlertType.CONFIRMATION);
                                alert.setTitle("Confirme o dialogo para finalizar a sua ação...");
                                alert.setHeaderText("Você deseja finalizar ou concluir gerando um protocolo de saida");
                                alert.setContentText("Por favor escolha uma opção!");
                                ButtonType btnConcluir = new ButtonType("Concluir");
                                ButtonType btnGerar = new ButtonType("Protocolo de Saída");
                                alert.getButtonTypes().setAll(btnConcluir, btnGerar, ButtonType.CANCEL);
                                ProtocoloEntrada p = tbPrincipal.getItems().get(getIndex());
                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.get() != ButtonType.CANCEL) {
                                    p.setDevolvido(1);
                                    dao = new ProtocoloDao();
                                    if (dao.atualizar(p)) {
                                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                                        alerta.setTitle("Atualização...");
                                        alerta.setHeaderText(null);
                                        alerta.setContentText("Atualizado com sucesso!");
                                        alerta.showAndWait();
                                        preencherGrafico();
                                        tbPrincipal.getItems().set(getIndex(), p);
                                        if (result.get() == btnGerar) {
                                            new ProtocoloView(p.getId()).setVisible(true);
                                        }
                                    }
                                }
                            }
                        });
                        setGraphic(btn);
                        setText(null);
                        limparTela();
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
        tbItem.getColumns().addAll(colunaId, colunaNome, colunaQuantidade, colunaDetalhes);
    }

    public Optional<Pair<LocalDate, Boolean>> Baixar() {
        Dialog<Pair<LocalDate, Boolean>> dialog = new Dialog<>();
        dialog.setTitle("Formulário de Validação");
        dialog.setHeaderText("Os documentos desse protocolo serão devolvidos para o cliente?");
        ButtonType botaoAplicar = new ButtonType("Aplicar", ButtonBar.ButtonData.OK_DONE);
        ButtonType botaoCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(botaoAplicar, botaoCancelar);
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        JFXRadioButton radioYes = new JFXRadioButton("Sim");
        radioYes.setSelected(true);
        double distanciaEsquerda = 20;
        Label lb1 = new Label("Será devolvido?");
        lb1.setLayoutX(distanciaEsquerda);
        lb1.setLayoutY(50);
        radioYes.setLayoutX(distanciaEsquerda);
        radioYes.setLayoutY(70);
        JFXRadioButton radioNo = new JFXRadioButton("Não");
        radioNo.setLayoutX(100);
        radioNo.setLayoutY(70);
        ToggleGroup toggle = new ToggleGroup();
        toggle.getToggles().addAll(radioYes, radioNo);

        Label label = new Label("Será devolvido em: ");
        label.setLayoutX(distanciaEsquerda);
        label.setLayoutY(130);
        JFXDatePicker data = new JFXDatePicker();
        data.setLayoutX(distanciaEsquerda);
        data.setLayoutY(150);
        data.setEditable(false);
        LocalDate ld = LocalDate.now();
        LocalDate ld2 = ld.plusMonths(1);
        data.setValue(ld2);
        data.setEditable(false);
        data.setDayCellFactory((DatePicker param) -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                LocalDate date = LocalDate.now();
                LocalDate dataLimite = date.plusDays(365);
                if (item.isAfter(dataLimite)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                    setTooltip(new Tooltip("Intervalo muito longo, diminua o prazo"));
                } else if (item.isBefore(date)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                    setTooltip(new Tooltip("Data minima deve ser hoje! " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                }
            }
        });
        JFXTextArea areaText = new JFXTextArea();
        areaText.setEditable(false);
        areaText.setText("*Uma vez informado a data de devolução, você deverá registrar um Protocolo de Saída pelo botão PROTOCOLAR DEVOLUÇÃO até a data de vencimento informada,\n"
                + "*2 Alertas serão enviados antes do vencimento, se o prazo for excedido, informe um novo prazo atraves do botão ADIAR DEVOLUÇÃO.\n"
                + "*Os protocolos de saída são opcionais, para visualizá-los clique no botão Protocolo de Saída no menu principal.");
        areaText.setWrapText(true);
        areaText.setLayoutX(distanciaEsquerda);
        areaText.setLayoutY(200);
        Node botaoAplicarAction = dialog.getDialogPane().lookupButton(botaoAplicar);
        pane.getChildren().addAll(lb1, radioYes, radioNo, label, data, areaText);
        dialog.getDialogPane().setContent(pane);
        radioYes.addEventHandler(ActionEvent.ACTION, (ActionEvent event1) -> {
            if (radioYes.isSelected()) {
                data.setDisable(false);
                botaoAplicarAction.setDisable(data.getValue() == null);
            } else {
                data.setDisable(true);
                botaoAplicarAction.setDisable(false);
            }
        });
        radioNo.addEventHandler(ActionEvent.ACTION, (ActionEvent event1) -> {
            if (radioYes.isSelected()) {
                data.setDisable(false);
                botaoAplicarAction.setDisable(data.getValue() == null);
            } else {
                data.setDisable(true);
                botaoAplicarAction.setDisable(false);
            }
        });

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == botaoAplicar && radioYes.isSelected()) {
                return new Pair(data.getValue(), true);
            } else if (dialogButton == botaoAplicar && radioNo.isSelected()) {
                return new Pair(null, false);
            }
            return null;
        });
        Optional<Pair<LocalDate, Boolean>> result = dialog.showAndWait();
        return result;
    }

    public Optional<Pair<LocalDate, String>> AlterarPrazo(Date newDate) {
        Dialog<Pair<LocalDate, String>> dialog = new Dialog<>();
        dialog.setTitle("Formulário de Validação");
        dialog.setHeaderText("Altere o prazo para devolução dos documentos do protocolo ou cancele.");
        ButtonType botaoAplicar = new ButtonType("Aplicar", ButtonBar.ButtonData.OK_DONE);
        ButtonType botaoCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(botaoAplicar, botaoCancelar);
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        double distanciaEsquerda = 20;
        Label lb1 = new Label("Será devolvido?");
        lb1.setLayoutX(distanciaEsquerda);
        lb1.setLayoutY(50);
        JFXRadioButton radioYes = new JFXRadioButton("Sim");
        radioYes.setSelected(true);
        radioYes.setLayoutX(distanciaEsquerda);
        radioYes.setLayoutY(70);
        JFXRadioButton radioNo = new JFXRadioButton("Não");
        radioNo.setLayoutX(100);
        radioNo.setLayoutY(70);
        ToggleGroup toggle = new ToggleGroup();
        toggle.getToggles().addAll(radioYes, radioNo);

        Label label = new Label("Será devolvido em: ");
        label.setLayoutX(distanciaEsquerda);
        label.setLayoutY(130);
        JFXDatePicker dataPicker = new JFXDatePicker();
        dataPicker.setLayoutX(distanciaEsquerda);
        dataPicker.setLayoutY(150);
        dataPicker.setEditable(false);
        GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
        calendar.setTime(newDate);
        LocalDate ld2 = calendar.toZonedDateTime().toLocalDate();
        dataPicker.setValue(ld2);
        dataPicker.setDayCellFactory((DatePicker param) -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                LocalDate date = LocalDate.now();
                LocalDate dataLimite = date.plusDays(365);
                if (item.isAfter(dataLimite)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                    setTooltip(new Tooltip("Intervalo muito longo, diminua o prazo"));
                } else if (item.isBefore(date)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                    setTooltip(new Tooltip("Data minima deve ser hoje! " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                }
            }
        });
        JFXTextArea areaText = new JFXTextArea();
        areaText.setPromptText("Descreva um resumo relatando o motivo desse novo prazo!");
        areaText.setWrapText(true);
        areaText.setLayoutX(distanciaEsquerda);
        areaText.setLayoutY(200);
        pane.getChildren().addAll(lb1, radioYes, radioNo, label, dataPicker, areaText);
        Node botaoAplicarAction = dialog.getDialogPane().lookupButton(botaoAplicar);
        botaoAplicarAction.setDisable(true);
        areaText.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            botaoAplicarAction.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(pane);
        radioYes.addEventHandler(ActionEvent.ACTION, (ActionEvent event1) -> {
            if (radioYes.isSelected()) {
                dataPicker.setDisable(false);
                areaText.setPromptText("Descreva um resumo relatando o motivo desse novo prazo!");
            } else {
                dataPicker.setDisable(true);
            }
        });
        radioNo.addEventHandler(ActionEvent.ACTION, (ActionEvent event1) -> {
            if (radioYes.isSelected()) {
                areaText.setPromptText("Descreva um resumo relatando o motivo desse novo prazo!");
                dataPicker.setDisable(false);
            } else {
                dataPicker.setDisable(true);
            }
        });
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == botaoAplicar && radioYes.isSelected()) {
                return new Pair<>(dataPicker.getValue(), areaText.getText());
            } else if (dialogButton == botaoAplicar && radioNo.isSelected()) {
                return new Pair<>(null, areaText.getText());
            }
            return null;
        });
        Optional<Pair<LocalDate, String>> result = dialog.showAndWait();
//            if(result.isPresent()){
//                result.ifPresent(u -> {
//                    System.out.println("is pressed ok "+u.getKey()+" "+u.getValue());});
//            }
        return result;
    }
}
