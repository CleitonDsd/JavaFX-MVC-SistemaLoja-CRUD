/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxmvc.model.dao.ClienteDAO;
import javafxmvc.model.database.Database;
import javafxmvc.model.database.DatabaseFactory;
import javafxmvc.model.domain.Cliente;

/**
 * FXML Controller class
 *
 * @author Cleiton Dsd'
 */
public class FXMLAnchorPaneCadastrosClientesController implements Initializable {

    //Adicionando atributos utilizados na parte visual (SceneBuilder)'
    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteCPF;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelClienteCodigo;
    @FXML
    private Label labelClienteCPF;
    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteTelefone;

    //A classe irá retornar uma lista de clientes usando o List'
    private List<Cliente> listClientes;
    //Iremos setar os dados do tableView com o ObservableList'
    private ObservableList<Cliente> observableListClientes;

    //Atributos para a manipulação do DB';
    //fornece uma instancia da classe DB MySQL'
    private final Database database = DatabaseFactory.getDatabase("dbsistemaloja");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Acesso ao DB para - setando a conexão recem criada'
        clienteDAO.setConnection(connection);
        carregarTableViewCliente();
    }

    //Carrega a tabela de clientes'
    public void carregarTableViewCliente() {

        //Determina que a coluna 'tableColumnClienteNome' exiba o nome e o CPF do cliente'
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        //Usa o clienteDAO e usa o metodo para listar - guardando no listClientes'
        listClientes = clienteDAO.listar();

        //Converte o listClientes em um observableList, e depois converte o Observable para um tblView
        observableListClientes = FXCollections.observableArrayList(listClientes);
        tableViewClientes.setItems(observableListClientes);

    }

}
