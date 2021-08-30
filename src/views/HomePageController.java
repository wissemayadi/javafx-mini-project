/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceUser;


public class HomePageController implements Initializable {

     private Parent fxml;
     
    @FXML
    private AnchorPane root;
    @FXML
    private Button btnLogout;
  ServiceUser su = new ServiceUser();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profil(MouseEvent event) {
       
              try {
              
             fxml=FXMLLoader.load(getClass().getResource("Profil.fxml"));
           root.getChildren().removeAll();
             root.getChildren().setAll(fxml);
                
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         
    }
         

        
    

    @FXML
    public void accueil(MouseEvent event) {
         try {
             fxml=FXMLLoader.load(getClass().getResource("Accueil.fxml"));
           root.getChildren().removeAll();
             root.getChildren().setAll(fxml);
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         
    }

    @FXML
    private void offre(MouseEvent event) {
          try {
             fxml=FXMLLoader.load(getClass().getResource("Offre.fxml"));
           root.getChildren().removeAll();
             root.getChildren().setAll(fxml);
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
        btnLogout.getScene().getWindow().hide();
 
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Good bye ");
            alert.show();
    }
    
}
