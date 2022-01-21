package entity;

public class Personne {
	private int idPers;
    private int idFlight;
    private String nom;
    private String prenom;



    public Personne() {}
    
	public Personne(int idPers,int idFlight, String nom, String prenom) {
	    this.idPers = idPers;
		this.idFlight = idFlight;
	    this.nom = nom;
	    this.prenom = prenom;
	}
	public int getIdPers() {
	    return this.idPers;
	}
	
	public void setIdPers(int idPers) {
	    this.idPers = idPers;
	}
	public int getIdFlight() {
	    return this.idFlight;
	}
	
	public void setIdFlight(int idFlight) {
	    this.idFlight = idFlight;
	}
	
	public String getNom() {
	    return this.nom;
	}
	
	public void setNom(String nom) {
	    this.nom = nom;
	}
	
	public String getPrenom() {
	    return this.prenom;
	}
	
	public void setPrenom(String prenom) {
	    this.prenom = prenom;
	}
}   
 
