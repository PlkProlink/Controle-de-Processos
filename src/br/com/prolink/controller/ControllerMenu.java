package br.com.prolink.controller;

import br.com.prolink.cadastros.CadastroClassificacao;
import br.com.prolink.cadastros.CadastroClientes;
import br.com.prolink.departamentos.Comercial;
import br.com.prolink.departamentos.Contabil;
import br.com.prolink.departamentos.Contratos;
import br.com.prolink.departamentos.DepPessoal;
import br.com.prolink.departamentos.Financeiro;
import br.com.prolink.departamentos.Fiscal;
import br.com.prolink.departamentos.Regularizacao;
import br.com.prolink.documentos.Documentos;
import br.com.prolink.view.Sobre;
import br.com.prolink.inicio.administracaoAlertas.AdministradorDePendencias;
import br.com.prolink.model.ProcessoLogado;
import br.com.prolink.config.init.UsuarioLogado;
import br.com.prolink.protocolos.ProtocoloView;
import br.com.prolink.relatorios.RelatCadastro;
import br.com.prolink.view.swings.CadastroDepartamento;
import br.com.prolink.view.swings.RelatorioAcessos;
import br.com.prolink.view.swings.CadastroUsuarios;
import br.com.prolink.view.Ativador;
import br.com.prolink.view.ProtocoloEntrada;
import br.com.prolink.view.ProtocoloRecebimento;
import br.com.prolink.view.interfaces.Icons;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;

public class ControllerMenu implements Initializable {
    Regularizacao regularizacao;
    Fiscal fiscal;
    Contabil contabil;
    Financeiro financeiro;
    DepPessoal dp;
    Contratos contratos;
    Comercial comercial;
    CadastroUsuarios cadUsuario;
    CadastroClientes cadClientes;
    CadastroClassificacao classificacao;
    CadastroDepartamento cd;
    Documentos documentos;
    Sobre sobre;
    RelatCadastro relCliente;
    AdministradorDePendencias pendencias;
    RelatorioAcessos historico;
    ProtocoloView protocolo;

    Ativador ativador;//fxml
    @FXML
    Button btProtocoloEntrada, btConfirmarRecebimento,
            btProtocoloSaida, btGerenciarCliente,
            btRelatorios, btHistorico,
            btDocumentosEnviados, btDocumentosRecebidos;
    @FXML
    Label lbUsuario;
    @FXML
    TextField txProcesso, txApelido, txProcessoNome, txClassificacao, txStatus;
    @FXML
    BarChart barGraphic;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lbUsuario.setText(saudacao() + " " + UsuarioLogado.getInstance().getUsuario().getUsuario() + ";");
        ObservableList<FadeTransition> arrayTransitions = FXCollections.observableArrayList();
        arrayTransitions.add(addFadeTransition(btProtocoloEntrada));
        arrayTransitions.add(addFadeTransition(btConfirmarRecebimento));
        arrayTransitions.add(addFadeTransition(btProtocoloSaida));
        arrayTransitions.add(addFadeTransition(btGerenciarCliente));
        arrayTransitions.add(addFadeTransition(btRelatorios));
        arrayTransitions.add(addFadeTransition(btHistorico));
        arrayTransitions.add(addFadeTransition(btDocumentosEnviados));
        arrayTransitions.add(addFadeTransition(btDocumentosRecebidos));
        initTransition(arrayTransitions);
        //guardar textfields como paramentro para a classe ativador
        ProcessoLogado processo = ProcessoLogado.getInstance();
        processo.setTextFields(new TextField[]{txProcesso, txApelido, txProcessoNome, txClassificacao, txStatus});
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
    @FXML
    private void abrirImpostosCNet(ActionEvent e){
        
    }
    @FXML
    private void contabil(ActionEvent e) {
        if (verificaAtivacao()) {
            if (contabil != null) {
                contabil.dispose();
            }
            contabil = new Contabil();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            contabil.txt_codigo.setText(txProcesso.getText());
            contabil.txt_nome.setText(txProcessoNome.getText());
            contabil.txt_id.setText(txApelido.getText());
            contabil.txt_usuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());
            contabil.setVisible(true);
        }
    }

    @FXML
    private void regularizacao(ActionEvent e) {
        if (verificaAtivacao()) {
            if (regularizacao != null) {
                regularizacao.dispose();
            }
            regularizacao = new Regularizacao();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            regularizacao.txt_codigo.setText(txProcesso.getText());
            regularizacao.txt_nome.setText(txProcessoNome.getText());
            regularizacao.txt_id.setText(txApelido.getText());
            regularizacao.txt_usuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());

            regularizacao.setVisible(true);
            //JOptionPane.showMessageDialog(null, "A tela solicitada já se encontra aberta!");

        }
    }

    @FXML
    private void financeiro(ActionEvent e) {
        if (verificaAtivacao()) {
            if (financeiro != null) {
                financeiro.dispose();
            }
            financeiro = new Financeiro();
            financeiro.txt_codigo.setText(txProcesso.getText());
            financeiro.txt_nome.setText(txProcessoNome.getText());
            financeiro.txt_id.setText(txApelido.getText());
            financeiro.txt_usuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());

            financeiro.setVisible(true);
        }
    }

    @FXML
    private void comercial(ActionEvent e) {
        if (verificaAtivacao()) {
            if (comercial != null) {
                comercial.dispose();
            }
            comercial = new Comercial();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            comercial.txtCodigo.setText(txProcesso.getText());
            comercial.txtNome.setText(txProcessoNome.getText());
            comercial.txtId.setText(txApelido.getText());
            comercial.txtUsuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());
            comercial.setVisible(true);
        }
    }

    @FXML
    private void fiscal(ActionEvent e) {

        if (verificaAtivacao()) {
            if (fiscal != null) {
                fiscal.dispose();
            }
            fiscal = new Fiscal();
            fiscal.txt_codigo.setText(txProcesso.getText());
            fiscal.txt_nome.setText(txProcessoNome.getText());
            fiscal.txt_id.setText(txApelido.getText());
            fiscal.txt_usuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());
            fiscal.setVisible(true);
        }
    }

    @FXML
    private void contratos(ActionEvent e) {

        if (verificaAtivacao()) {
            if (contratos != null) {
                contratos.dispose();
            }
            contratos = new Contratos();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            contratos.txtCodigo.setText(txProcesso.getText());
            contratos.txtNome.setText(txProcessoNome.getText());
            contratos.txtId.setText(txApelido.getText());
            contratos.txtUsuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());

            contratos.setVisible(true);
        }
    }

    @FXML
    private void dp(ActionEvent e) {

        if (verificaAtivacao()) {
            if (dp != null) {
                dp.dispose();
            }
            dp = new DepPessoal();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            dp.txtCodigo.setText(txProcesso.getText());
            dp.txtNome.setText(txProcessoNome.getText());
            dp.txtId.setText(txApelido.getText());
            dp.txtUsuario.setText(UsuarioLogado.getInstance().getUsuario().getUsuario());

            dp.setVisible(true);
        }
    }

    @FXML
    private void gerenciarCliente(ActionEvent e) {
        if (cadClientes != null) {
            cadClientes.dispose();
        }
        cadClientes = new CadastroClientes();
        cadClientes.setVisible(true);

    }

    @FXML
    private void classificacao(ActionEvent e) {
        if (classificacao != null) {
            classificacao.dispose();
        }
        classificacao = new CadastroClassificacao();
        classificacao.setVisible(true);

    }

    @FXML
    private void documentosRecebidos(ActionEvent e) {

        if (verificaAtivacao()) {
            if (documentos != null) {
                documentos.dispose();
            }
            documentos = new Documentos();

            documentos.txtCodigo.setText(txProcesso.getText());
            documentos.txtNome.setText(txProcessoNome.getText());
            documentos.txtID.setText(txApelido.getText());

            documentos.setVisible(true);

        }
    }

    @FXML
    private void documentosEnviados(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Esse ambiente foi desativado");
    }

    @FXML
    private void historico(ActionEvent e) {
        if (historico != null) {
            historico.dispose();
        }
        historico = new RelatorioAcessos();
        historico.setVisible(true);
    }

    @FXML
    private void pendencias(ActionEvent e) {
        if (pendencias != null) {
            pendencias.dispose();
        }
        pendencias = new AdministradorDePendencias(txProcesso.getText().equals("")
                ? 0 : Integer.parseInt(txProcesso.getText()));
        pendencias.setVisible(true);
    }

    @FXML
    private void protocoloEntrada(ActionEvent e) {
        ProtocoloEntrada prot = new ProtocoloEntrada();
        prot.start(new Stage());
    }

    @FXML
    private void protocoloConfirmar(ActionEvent e) {
       ProtocoloRecebimento recConf = new ProtocoloRecebimento();
       recConf.start(new Stage());
    }

    @FXML
    private void protocoloSaida(ActionEvent e) {
        if (protocolo != null) {
            protocolo.dispose();
        }
        protocolo = new ProtocoloView(-1);
        protocolo.setVisible(true);
    }

    @FXML
    private void usuarios(ActionEvent e) {
        if (cadUsuario != null) {
            cadUsuario.dispose();
        }
        cadUsuario = new CadastroUsuarios();
        cadUsuario.setVisible(true);
    }

    @FXML
    void sair(ActionEvent e) {
        System.exit(0);
    }

    @FXML
    private void departamentos(ActionEvent e) {
        cd = new CadastroDepartamento();
        cd.setVisible(true);
    }

    private String saudacao() {
        String s = "";
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            s = "Bom dia";
        } else if (hour >= 12 && hour < 18) {
            s = "Boa tarde";
        } else if (hour >= 18) {
            s = "Boa noite";
        }
        return s;
    }
    private boolean verificaAtivacao() {
        if (txProcesso.getText().equals("")) {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Ativação necessaria!");
            alerta.setContentText("Para prosseguir ative um cadastro!");
            Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(Icons.getInstance().getIcon().toString()));
            alerta.showAndWait();
            
            ativador = new Ativador();
            ativador.start(new Stage());
            return false;
        } else {
            return true;
        }
    }
    @FXML
    void ativar(ActionEvent e) {
	if(ativador!=null){
                try {
                    ativador.stop();
                } catch (Exception ex) {}
        }
        ativador = new Ativador();
        ativador.start(new Stage());
    }

}
