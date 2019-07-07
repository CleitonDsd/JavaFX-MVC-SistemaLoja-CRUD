package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxmvc.model.domain.Cliente;

/**
 * FXML Controller class
 *
 * @author Cleiton Dsd'
 */
public class FXMLAnchorPaneCadastrosDialogController implements Initializable {

    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteCPF;
    @FXML
    private Label labelClienteTelefone;

    @FXML
    private TextField textFieldClienteNome;
    @FXML
    private TextField textFieldClienteCPF;
    @FXML
    private TextField textFieldClienteTelefone;

    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    //Irá representar a tela aberta'
    private Stage dialogStage;
    //Para saber se a pessoa confirmou ou cancelou a ação'
    private boolean buttonConfirmarClicked = false;
    //Tipo de classe a qual vamos preencher para inserir no BD'
    private Cliente cliente;

    //Encapsulamento'
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @return the dialogStage
     */
    public Stage getDialogStage() {
        return dialogStage;
    }

    /**
     * @param dialogStage the dialogStage to set
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * @return the buttonConfirmarClicked
     */
    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    /**
     * @param buttonConfirmarClicked the buttonConfirmarClicked to set
     */
    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Confirma a ação do buttonConfirmar'
    @FXML
    public void handleButtonConfirmar() {

        //preenche os dados do cliente quando o botão for pressionado
        cliente.setCpf(textFieldClienteCPF.getText());
        cliente.setNome(textFieldClienteNome.getText());
        cliente.setTelefone(textFieldClienteTelefone.getText());

        //Seta como verdadeira a ação do usuário | clicando em confirmar'
        buttonConfirmarClicked = true;
        //fecha a tela'
        dialogStage.close();

    }
    //Ao clicar em cancelar a tela fecha
    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }
}
