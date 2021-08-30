/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class testProject extends Application {


    public void start(Stage stage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));

  
Scene scene = new Scene(root);



        stage.setScene(scene);
        stage.setTitle("User Login");

        stage.show();
        
       
    }
    
    
    public static void main(String[]args){
        launch(args);
    }
}
