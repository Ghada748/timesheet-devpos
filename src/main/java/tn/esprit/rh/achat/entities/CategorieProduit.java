package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	@OneToMany(mappedBy = "categorieProduit")
	@JsonIgnore
	private Set<Produit> produits;

	public CategorieProduit(Long idCategorieProduit, String codeCategorie, String libelleCategorie) {
		this.idCategorieProduit = idCategorieProduit;
		this.codeCategorie = codeCategorie;
		this.libelleCategorie = libelleCategorie;
	}

	public Long getIdCategorieProduit() {
		return idCategorieProduit;
	}

	public String getCodeCategorie() {
		return codeCategorie;
	}

	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setIdCategorieProduit(Long idCategorieProduit) {
		this.idCategorieProduit = idCategorieProduit;
	}

	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public void setidCategorieProduit(long l) {
	}
}
