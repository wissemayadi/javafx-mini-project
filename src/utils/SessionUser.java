/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Candidat;

/**
 *
 * @author naderayadi
 */
public class SessionUser {
    private static Candidat  currentCandidat=null;
     public static void setSessionUser(Candidat candidat) {
       currentCandidat = candidat;
    }
    
    public static Candidat getSessionUser() {
        return currentCandidat;
    }
    
    public static void destroySession() {
        currentCandidat = null;
    }
}
