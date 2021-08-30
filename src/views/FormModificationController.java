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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author naderayadi
 */
public class FormModificationController implements Initializable {

    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPays;
    @FXML
    private TextField tfVille;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfDomaine;
    @FXML
    private Button btnUpdate;
    @FXML
    private AnchorPane updateScene;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  ServiceUser su= new ServiceUser();
        
        tfLogin.setText(utils.Utulities.currentCandidat.getLogin());
        tfEmail.setText(utils.Utulities.currentCandidat.getEmail());
      tfPays.setText(utils.Utulities.currentCandidat.getPays());
      tfVille.setText(utils.Utulities.currentCandidat.getVille());
      tfTel.setText(Integer.toString(utils.Utulities.currentCandidat.getTel()));
      tfDomaine.setText(utils.Utulities.currentCandidat.getDomaine());

       btnUpdate.setOnAction(evt->{
           
      try {
          Candidat candidatupdate = new ServiceUser().getUserByid(1);
          candidatupdate.setId(utils.Utulities.currentCandidat.getId());
          candidatupdate.setLogin(tfLogin.getText());
          candidatupdate.setEmail(tfEmail.getText());
          candidatupdate.setPays(tfPays.getText());
          candidatupdate.setVille(tfVille.getText());
          candidatupdate.setTel(Integer.parseInt(tfTel.getText()));
          candidatupdate.setDomaine(tfDomaine.getText());
          
          su.modifier(candidatupdate);
          System.out.println("success");
          
            btnUpdate.getScene().getWindow().hide();
 

            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("updated ");
            alert.show();
      
         
          
      } catch (ClassNotFoundException ex) {
          System.out.println(ex.getMessage());   
      } catch (IOException ex) {
          System.out.println(ex.getMessage());
      }
      });
      btnBack.setOnAction(evt->{
      try {
          btnBack.getScene().getWindow().hide();
          
          Stage dashboardStage = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
          Scene scene = new Scene(root);
          dashboardStage.setScene(scene);
          dashboardStage.show();
      } catch (IOException ex) {
          System.out.println(ex.getMessage());
      }
          
      });
    }    
  
        
    
}
