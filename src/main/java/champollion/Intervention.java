/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author damie
 */
public class Intervention {
    Date debut;
    int duree;
    boolean anulee;
    Salle salle;
    Enseignant enseignant;
    UE ue;
    TypeIntervention type;
    
    public Intervention(Date deb, int d, TypeIntervention t,Salle s, Enseignant e, UE pue){
        this.debut=deb;
        this.duree=d;
        this.anulee=false;
        this.type=t;
        this.salle=s;
        this.enseignant=e;
        this.ue=pue;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnulee() {
        return anulee;
    }

    public void setAnulee(boolean anulee) {
        this.anulee = anulee;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }
    
    
    
    
    
}
