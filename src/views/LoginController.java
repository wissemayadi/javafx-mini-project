/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Candidat;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.ServiceUser;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.Logger;

import utils.MaConnexion;
import utils.SessionUser;

public class LoginController implements Initializable {
 public ResultSet result;
 public PreparedStatement st;
    @FXML
    private TextField tfusername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSignup;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        

    }    
 Connection cnx = MaConnexion.getInstance().getCnx();
  public void signUpEvent(ActionEvent event) throws IOException {


 try{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
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
    public void Authentification(ActionEvent event) throws IOException{
        ServiceUser su = new ServiceUser();

   String login =tfusername.getText();
    String password=tfPassword.getText();
//if(su.LoginUser(login,password)){
Candidat c =su.Auth(login, password);
        System.out.println(c);
if(!c.getLogin().equals("") && (!c.getPassword().equals("")) ){
    
   btnLogin.getScene().getWindow().hide();
 

            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("welcome "+tfusername.getText());
            alert.show();
}   else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Error in login system please verify your data!!");
            alert.show();
//            reseting user and pass field
            tfusername.setText("");
            tfPassword.setText("");
        }
    
    }
//    public void changeScene(ActionEvent event) throws IOException{
//        if(attemptLogin() == false){
//            return ;
//        }
//         Stage dashboardStage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
//            Scene scene = new Scene(root);
//            dashboardStage.setScene(scene);
//            dashboardStage.show();
//              Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Success");
//            alert.setContentText("welcome "+tfusername.getText());
//            alert.show();
//        
//        
//    }
// public boolean attemptLogin() throws IOException{
//     String login =this. tfusername.getText();
//        String password=     this.tfPassword.getText();
//       if(login.isEmpty()|| password.isEmpty()){
//           System.out.println("champs vide!!");
//       } 
//       ServiceUser su = new ServiceUser();
//       Candidat attempted = su.findUser(login, password);
//       if(attempted == null) {
//           System.out.println("failed to login");
//           return false;
//       }
//       SessionUser.setSessionUser(attempted);
//       Logger.loginFailure(login);
//      return true;
// }
//    
//    
//    
    
    
}



