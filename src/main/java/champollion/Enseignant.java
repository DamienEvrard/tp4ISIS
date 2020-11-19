package champollion;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {
    
    private List<ServicePrevu> servicePrevu;
    private List<Intervention> listeIntervention;
    
    public Enseignant(String nom, String email) {
        super(nom, email);
        this.listeIntervention = new ArrayList<>();
        this.servicePrevu = new ArrayList<>();
    }
    
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float heures=0;
        for(ServicePrevu s :servicePrevu){
            heures+= 1.5*s.getVolumeCM()+s.getVolumeTD()+0.75*s.getVolumeTP();
        }
        return Math.round(heures);
    }
    
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        float heures=0;
        for(ServicePrevu s :servicePrevu){
            if(s.getUe()==ue){
                heures+= 1.5*s.getVolumeCM()+s.getVolumeTD()+0.75*s.getVolumeTP();
            }
        }
        return Math.round(heures);
    }
    
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        servicePrevu.add(new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue));
    }
    
    /**
     * ajoute une intervention planifiée pour l'enseignant
     * @param inter lintervention a ajouter
     */
    public void ajouteIntervention(Intervention inter) {
        listeIntervention.add(inter);
    }
    
    /**
     * verifie si l'enseignant est en sous service
     * @return true si l'enseignant est en sous service
     */
    public boolean enSousService() {
        return heuresPrevues()<192;
    }
    
    
    public int heuresPlanifier() {
        float heures=0;
        
        if(!listeIntervention.isEmpty()){
            for(Intervention i : listeIntervention){
                switch (i.getType()){
                    case CM:
                        heures+= 1.5*i.getDuree();
                        break;
                        
                    case TD:
                        heures+= 1*i.getDuree();
                        break;
                        
                    case TP:
                        heures+= 0.75*i.getDuree();
                        break;
                }
            }
        }
        return Math.round(heures);
    }

    public List<ServicePrevu> getServicePrevu() {
        return servicePrevu;
    }

    public List<Intervention> getListeIntervention() {
        return listeIntervention;
    }
    
    
    
}
