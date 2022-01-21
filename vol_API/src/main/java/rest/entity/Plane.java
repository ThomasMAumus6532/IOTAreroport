package rest.entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import entity.Personne;

public class Plane {
    private int idPlane;
    private List<Integer> tabIdFlight = new ArrayList<>();
    private String model;
    private String brand;
    private List<Personne> tabPers = new ArrayList<Personne>();


    public Plane(int idPlane, String model, String brand) {
        this.idPlane = idPlane;
        this.model = model;
        this.brand = brand;
    }
    
    public Plane() {};
    
    public boolean vol() {
    	Random rand = new Random();
        int max = 2;
        boolean isFlying;
        int int_random = rand.nextInt(max); 
        if (int_random == 0) 
        	isFlying = false;
        else 
        	isFlying = true;
        
        return isFlying;
    }
    
    public void addPersonne(Personne personne) {
    	tabPers.add(personne);
    }
    
    public void deletePersonne(Personne personne) {
    	tabPers.remove(personne);
    }
    
    public void addFlight(int id) {
    	tabIdFlight.add(id);
    	
    }
    public List<Personne> gettabPers() {
    	return this.tabPers;
    }
    public void settabPers(List<Personne>  tabPers) {
    	this.tabPers = tabPers;
    }
    public int getIdPlane() {
        return this.idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

	public List<Integer> getTabIdFlight() {
		return tabIdFlight;
	}

	public void setTabIdFlight(List<Integer> idFlight) {
		this.tabIdFlight = idFlight;
	}

}

