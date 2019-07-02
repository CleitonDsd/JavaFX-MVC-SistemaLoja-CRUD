/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cleiton Dsd'
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        /*Aqui o arquivo será carregado com o caminho indicado - 
           pois já estamos na classe principal com o pacote principal'*/
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLVBoxMain.fxml"));

        //cena será instanciada para a tela aparecer'
        Scene scene = new Scene(root);
        
        stage.setScene(scene); //a cena é setada no stage
        stage.setTitle("Sistema Para Controle de Vendas");
        stage.setResizable(false); //proibi manipulação da tela;
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
//
