/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.mysql.cj.xdevapi.Statement;
import entities.Candidat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.MaConnexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Utulities;


public class ServiceUser {

    Connection cnx = MaConnexion.getInstance().getCnx();

    public void AjouterPersonne(Candidat c) {

        try {
            String requete = "INSERT INTO personne VALUES(NULL,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getLogin());
            pst.setString(2, c.getPassword());
            pst.setString(3, c.getPassword2());
            pst.setString(4, c.getEmail());
            pst.setString(5, c.getPays());
            pst.setString(6, c.getVille());
            pst.setInt(7, c.getCodePostal());
            pst.setString(8, c.getAdresse());
            pst.setInt(9, c.getTel());
            pst.setString(10, c.getDomaine());

            pst.executeUpdate();
            System.out.println("Personne ajoutée !");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }

    public boolean LoginUser(String login, String password) {

        String requete = "SELECT * from personne WHERE login like? AND password like ?";
        boolean status = false;
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, login);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            status = rs.next();
            
            pst.close();
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static Candidat findUser(String login, String password) {

        try {
            Connection cnx = MaConnexion.getInstance().getCnx();
            String requete = "SELECT * from personne WHERE login like? AND password like ? AND id like?";
//String requete = "SELECT * FROM personne WHERE login='" +login + "' AND password='" + password + " '; ";
            PreparedStatement pst = cnx.prepareStatement(requete);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    Candidat currentCandidat = new Candidat(rs.getInt("id"), rs.getString(login));
//                    cnx.close();
                    return currentCandidat;

                } 
                catch (Exception ex) {
                    System.err.println(ex.getLocalizedMessage());
                    return null;
                }
            }
            else {
                return null;
            }
        
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
        
       
        }
        
        
        
        
        




    
         

 
 
 
 
 
 
 
 
 

    public List<Candidat> afficher() {
        List<Candidat> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM personne ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Candidat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10)));
            }
//    public Candidat(int id, String login, String password, String adresse, String ville, String pays, String email, int tel, int codePostal) {

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public Candidat getUserByid(int id) throws ClassNotFoundException {
        Candidat candidat = new Candidat(id, "", "", "", "", "", 0);
        Connection cnx = MaConnexion.getInstance().getCnx();
        try {
            String requete = "SELECT login,email,pays,ville,tel,domaine FROM personne where `id`=" + id;
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                candidat.setId(rs.getInt("id"));
                candidat.setLogin(rs.getString("login"));
                candidat.setEmail(rs.getString("email"));
                candidat.setPays(rs.getString("pays"));
                candidat.setVille(rs.getString("ville"));
                candidat.setTel(Integer.parseInt(rs.getString("tel")));
                candidat.setVille(rs.getString("domaine"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return candidat;
    }


    
     public  Candidat Auth(String login , String password ){
            Candidat c = new Candidat();
//           String requete = "SELECT * from personne WHERE login like? AND password like ?";
               String requete= "SELECT * FROM personne WHERE login='" + login + "' AND password='" + password + "'" ;

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
               ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    Candidat currentCandidat = new Candidat(rs.getInt("id"), rs.getString("login"),rs.getString("password"), rs.getString("email"), rs.getString("pays"), rs.getString("ville"), rs.getInt("codep"),rs.getString("adresse"),rs.getInt("tel"), rs.getString("domaine"));
//    public Candidat(int id, String login, String password, String email, String pays, String ville, int codePostal, String adresse,int tel, String domaine) {

                    utils.Utulities.currentCandidat= currentCandidat;
                    return currentCandidat;

                } 
                catch (Exception ex) {
                    System.err.println(ex.getLocalizedMessage());
                    return null;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
        return c ;
            
    
    
}
     
     public void modifier( Candidat candidat) {
        Connection cnx = MaConnexion.getInstance().getCnx();
        try {
            String requete="UPDATE `personne` SET `login`='"+candidat.getLogin()+"',`email`='"+candidat.getEmail()+"',`pays`='"+candidat.getPays()+"',`ville`='"+candidat.getVille()+"',`pays`='"+candidat.getPays()+"',`tel`='"+candidat.getTel()+"',`domaine`='"+candidat.getDomaine()+"'  WHERE `id`="+Utulities.currentCandidat.getId();
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.executeUpdate();
            System.out.println("personne  modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public Candidat getCandidatByid(int id) throws ClassNotFoundException{
        Candidat candidat = new Candidat(0, "", "", "", "","",0,"",0,"");
       Connection cnx = MaConnexion.getInstance().getCnx();
        try {
            String requete = "SELECT * FROM admin where `id`="+id;
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               candidat.setId(rs.getInt("id"));
               candidat.setLogin(rs.getString("login"));
                  candidat.setPassword(rs.getString("password"));
               candidat.setEmail(rs.getString("email"));
               candidat.setPays(rs.getString("pays"));
               candidat.setVille(rs.getString("ville"));
                 candidat.setCodePostal(rs.getInt("codep"));
                    candidat.setAdresse(rs.getString("adresse"));
                     candidat.setTel(rs.getInt("tel"));
                       candidat.setDomaine(rs.getString("domaine"));
                     
                
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return candidat;
    }
}
