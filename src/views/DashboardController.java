/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author naderayadi
 */
public class DashboardController implements Initializable {
  private Parent fxml;
    @FXML
    private ImageView exit;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private Button btnProfil;
    @FXML
    private AnchorPane root;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    exit.setOnMouseClicked(event->{
        
        System.exit(0);
    });
    
    slider.setTranslateX(-176);
    Menu.setOnMouseClicked(event->{
        TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);
        slide.setToX(0);
        slide.play();
        slider.setTranslateX(-176);
        
        slide.setOnFinished(evt->{
            Menu.setVisible(false);
            MenuClose.setVisible(true);
            
        });
        
    });
      MenuClose.setOnMouseClicked(event->{
        TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);
        slide.setToX(-176);
        slide.play();
        slider.setTranslateX(0);
        
        slide.setOnFinished(evt->{
            Menu.setVisible(true);
            MenuClose.setVisible(false);
            
        });
        
    });
      
    
    }    


    @FXML
    private void profilEvent(MouseEvent event) {
         try {
          fxml=FXMLLoader.load(getClass().getResource("ProfilPage.fxml"));
           root.getChildren().removeAll();
         root.getChildren().setAll(fxml);
           
      } catch (IOException ex) {
          ex.printStackTrace();
          
      }
    }
       

    
}
