/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jcraft.jsch.JSchException;
import entities.Candidat;
import static java.awt.SystemColor.window;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceUser;
import utils.Server;
import utils.Utulities;

/**
 * FXML Controller class
 *
 * @author naderayadi
 */
public class ProfilController implements Initializable {
    @FXML
    private Button cvBtn;
    @FXML
    private TextField TfLogin;
    @FXML
    private TextField tfPays;
    @FXML
    private TextField tfVille;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tflEmail;
    @FXML
    private TextField tfDomaine;
    @FXML
    private Label lbId;
    @FXML
    private Button editButton;
    @FXML
    private Label lbDownload;

    /**
     * Initializes the controller class.
     */
     
//ServiceUser su =new ServiceUser();

    public void initialize(URL url, ResourceBundle rb){
        ServiceUser su = new ServiceUser();

     tfDomaine.setStyle("-fx-text-inner-color: white;");
     tfTel.setStyle("-fx-text-inner-color: white;");
          tflEmail.setStyle("-fx-text-inner-color: white;");
               tfVille.setStyle("-fx-text-inner-color: white;");

     
     lbId.setText(utils.Utulities.currentCandidat.getLogin());
        TfLogin.setText(utils.Utulities.currentCandidat.getLogin());
        tflEmail.setText(utils.Utulities.currentCandidat.getEmail());
      tfPays.setText(utils.Utulities.currentCandidat.getPays());
      tfVille.setText(utils.Utulities.currentCandidat.getVille());
      tfTel.setText(Integer.toString(utils.Utulities.currentCandidat.getTel()));
      tfDomaine.setText(utils.Utulities.currentCandidat.getDomaine());

    }
      
    
    @FXML
    private void cvUpload(ActionEvent event) throws JSchException {
        
    Server sv = new Server();
    sv.Download();
         lbDownload.setText("dowload complete");
//      FileChooser fc =new FileChooser();
//      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
//        List<File>f=fc.showOpenMultipleDialog(null);
//        for(File file : f){
//            System.out.println(file.getAbsolutePath());
//        }
    }
    
    @FXML
      public void modif(ActionEvent event) {
     
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormModification.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Modifier profil");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
         
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());     
        }
 }
//
//    @FXML
//    private void modif(MouseEvent event) {
//    }
        
        
    }
 

 

   

