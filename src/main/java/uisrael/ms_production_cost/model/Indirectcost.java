package uisrael.ms_production_cost.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Indirectcost implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal cost;
    
    @Column(nullable = false)
    private boolean active;
    
    public boolean isActive() {
    	return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkProduct", nullable = false)
    @JsonBackReference
    private Product fkProduct;
}
