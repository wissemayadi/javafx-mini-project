/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class HomeController implements Initializable {

    @FXML
    private Label lbLogin;
    @FXML
    private Button bntProfil;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btEmploi;
    @FXML
    private Label labelWelcom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
      
           public void setLbLogin(String login) {
          this.lbLogin.setText(login);
    }
        
}
