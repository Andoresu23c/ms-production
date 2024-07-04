package uisrael.ms_production_cost.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String category;
    
    @Column(nullable = false)
    private boolean active;
    
    public boolean isActive() {
    	return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    @OneToMany(mappedBy = "fkProduct")
    @JsonManagedReference
    private List<Feedstock> feedstocks = new ArrayList<Feedstock>();

    @OneToMany(mappedBy = "fkProduct")
    @JsonManagedReference
    private List<Workforce> workforces = new ArrayList<Workforce>();

    @OneToMany(mappedBy = "fkProduct")
    @JsonManagedReference
    private List<Totalcost> totalcosts = new ArrayList<Totalcost>();

    @OneToMany(mappedBy = "fkProduct")
    @JsonManagedReference
    private List<Indirectcost> indirectcosts = new ArrayList<Indirectcost>();
}
