package ipint.glp.metiers;

import ipint.glp.donnees.Annonce;
import ipint.glp.donnees.Categorie;
import ipint.glp.donnees.TypeAnnonce;
import ipint.glp.donnees.Utilisateur;
import ipint.glp.fabriques.FabAnnonce;
import ipint.glp.fabriques.FabCategorie;
import ipint.glp.fabriques.FabUtilisateur;

import java.util.HashMap;
import java.util.List;

public class MetierAnnonce {
	
	public MetierAnnonce(){
		
	}
	
	public Annonce creerAnnonce(Categorie categorie,Utilisateur utilisateur,TypeAnnonce typeAnnonce, HashMap<String, String> lesChamps){
		Annonce annonce = FabAnnonce.getInstance().creerAnnonce(categorie, utilisateur, TypeAnnonce.offre, lesChamps);
		return annonce;
	}
	
	public List<Annonce> listerAnnoncesParCategorie(String categorie){
		return FabAnnonce.getInstance().listerAnnoncesParCategorie(FabCategorie.getInstance().getCategorie(categorie));
	}
	
	public List<Annonce> listerAnnonces(){
		return FabAnnonce.getInstance().listerAnnonces();
	}
	
	

}
