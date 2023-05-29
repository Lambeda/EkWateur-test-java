package main.java.format.client;

import main.java.utils.Constants;

public class ClientPro extends Client{
    private Siret siret;
    private String raisonSociale;
    private long chiffreAffaire;

    public ClientPro(IdEkWateur id, Siret siret, String raisonSociale, long chiffreAffaire) {
        super(id, TypeClient.PROFESSIONEL);
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.chiffreAffaire = chiffreAffaire;
        determineTypeProfessionnel();
    }

    public Siret getSiret() {
        return siret;
    }

    public void setSiret(Siret siret) {
        this.siret = siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public long getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(long chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
        determineTypeProfessionnel();
    }

    private void determineTypeProfessionnel() {
        if (this.chiffreAffaire >= Constants.CA_DELIMITEUR)
            this.setType(TypeClient.PROFESSIONEL_CA_SUPERIEUR);
    }
}
