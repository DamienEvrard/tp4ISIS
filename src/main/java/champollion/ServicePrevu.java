package champollion;

public class ServicePrevu {
    int volumeCM;
    int volumeTD;
    int volumeTP;
    Enseignant enseignant;
    UE ue;
    
    public ServicePrevu(int vCM, int vTD, int vTP, Enseignant e, UE pUe){
        this.volumeCM=vCM;
        this.volumeTD=vTD;
        this.volumeTP=vTP;
        this.enseignant=e;
        this.ue=pUe;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
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
