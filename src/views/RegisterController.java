/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Candidat;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author naderayadi
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPays;
   
   
    private Button btnRegister;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfCode;
    @FXML
    private TextField tfVille;
    @FXML
    private TextField tfDomaine;
    @FXML
    private PasswordField tfPasswordConfirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    @FXML
      public void loginEvent(ActionEvent event) throws IOException {
     try{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);      
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    } catch(IOException e){
        e.printStackTrace();
    }
    
    }
    
    @FXML
     public void ajouterpersonne(ActionEvent event) throws IOException{
        
//        LocalDate myDate=pickerBirthday.getValue();



ServiceUser su = new ServiceUser();
if(tfPassword.getText().equals("")||tfPasswordConfirm.getText().equals("")|| tfLogin.getText().equals("")|| tfVille.getText().equals("")
        
        ||tfEmail.getText().equals("")||tfAdresse.getText().equals("")||tfDomaine.getText().equals("")||tfPays.getText().equals("")||tfTel.getText().equals("")||tfCode.getText().equals("")){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setContentText("champ vide!!");
     alert.showAndWait();
     
     
}else {
su.AjouterPersonne(new Candidat(tfLogin.getText(),
        tfPassword.getText(),
        tfPasswordConfirm.getText(),
        tfEmail.getText(),
        tfPays.getText(),
         tfVille.getText(),
      Integer.parseInt(tfTel.getText()),
         tfAdresse.getText(),
      Integer.parseInt(   tfCode.getText()),
       tfDomaine.getText()
));


Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
         alert.setHeaderText(null);
       alert.setContentText("Success");
     alert.showAndWait();
     
 ((Node) (event.getSource())).getScene().getWindow().hide();
     Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();

            }
     }
}
