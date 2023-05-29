package main.java.format.client;

public class ClientPart extends Client{
    private Civilite civilite;
    private String nom;
    private String prenom;

    public ClientPart(IdEkWateur id, Civilite civilite, String nom, String prenom) {
        super(id, TypeClient.PARTICULIER);
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

}
