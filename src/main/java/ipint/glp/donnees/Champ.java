package ipint.glp.donnees;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;



@Entity
public class Champ {
	
	
	@Id
	private String libelle;
	
	private Integer limite;
	
	@Enumerated(EnumType.STRING)
	private TypeChamp typeChamp;
	
	
	public Champ(){
		super();
	}
	
	public Champ(String libelle, Integer limite, TypeChamp typeChamp) {
		super();
		this.libelle = libelle;
		this.limite = limite;
		this.typeChamp = typeChamp;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}

	public TypeChamp getTypeChamp() {
		return typeChamp;
	}

	public void setTypeChamp(TypeChamp typeChamp) {
		this.typeChamp = typeChamp;
	}
	
}
