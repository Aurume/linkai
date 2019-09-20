package link;

import javax.persistence.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // This tells Hibernate to make a table out of this class

public class Kategorijos {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String pav;
    
    // @OneToMany(mappedBy = "patiekalai",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("kategorijos") 
    @OneToMany(mappedBy = "kategorijos",cascade = CascadeType.ALL)
    //private List<Patiekalu_produktai> patiekalu_produktai;  ar reikalinga eilutė?
    
	public Skirstymas() {
    	
	}
	
	public Kategorijos(String pav) {
    	
    	this.pav = pav;
    	
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}


	public List<Kategoriju_sarasas> getKategoriju_sarasas() {
		
		return kategoriju_sarasas;
	}
	public void setKategoriju_sarasas (List<Kategoriju_sarasas> kategoriju_sarasas) {
		
		this.kategoriju_sarasas = kategoriju_sarasas;
	}		
	
	public String toString() {
		
		
	    return this.id + " / " + this.pav + " / "
	    		
	}
	
}
