/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;


public class Candidat {
private int id ;

private String login, password ,password2,adresse , ville , pays,email,domaine;
private int tel, codePostal;
    public Candidat() {
    }

    public Candidat(String login, String password,String password2, String email,   String pays,String ville, int codePostal,String adresse,int tel,String domaine) {
        this.login = login;
        this.password = password;
        this.password2=password2;
        this.adresse = adresse;
           this.pays = pays;
        this.ville = ville;
        this.email = email;
        this.tel = tel;
        this.codePostal = codePostal;
        this.domaine=domaine;
       
    }

    public Candidat(int id, String login, String password, String email, String pays, String ville, int codePostal, String adresse,int tel, String domaine) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.email = email;
        this.tel = tel;
        this.codePostal = codePostal;
        this.domaine=domaine;
    }

    public Candidat( int id,String login, String ville, String pays, String email, String domaine, int tel) {
        this.id=id;
        this.login = login;
        this.ville = ville;
        this.pays = pays;
        this.email = email;
        this.domaine = domaine;
        this.tel = tel;
    }
    
    
    
    
public Candidat(String login, String password){
    this.login=login;
    this.password=password;
}


public Candidat(int id,String login){
    this.id=id;
    this.login=login;
  
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Candidat{" + "id=" + id + ", login=" + login + ", password=" + password + ", password2=" + password2 + ", adresse=" + adresse + ", ville=" + ville + ", pays=" + pays + ", email=" + email + ", domaine=" + domaine + ", tel=" + tel + ", codePostal=" + codePostal + '}';
    }

  

  
}
