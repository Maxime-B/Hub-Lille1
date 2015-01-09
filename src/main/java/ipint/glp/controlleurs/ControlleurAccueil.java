package ipint.glp.controlleurs;

import ipint.glp.donnees.Categorie;
import ipint.glp.donnees.Champ;
import ipint.glp.donnees.Droit;
import ipint.glp.donnees.TypeAnnonce;
import ipint.glp.donnees.TypeChamp;
import ipint.glp.donnees.Utilisateur;
import ipint.glp.fabriques.FabCategorie;
import ipint.glp.fabriques.FabChamp;
import ipint.glp.fabriques.FabUtilisateur;
import ipint.glp.metiers.MetierAnnonce;
import ipint.glp.metiers.MetierCategorie;
import ipint.glp.metiers.MetierChamp;
import ipint.glp.metiers.MetierUtilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControlleurAccueil {
	private static final Logger logger = LoggerFactory
			.getLogger(ControlleurAccueil.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
		Champ c1 = FabChamp.getInstance().creerChamp("titre", 60,
				TypeChamp.TEXTE);
		Champ c2 = FabChamp.getInstance()
				.creerChamp("description", 500, TypeChamp.TEXTE);
		Champ c3 = FabChamp.getInstance()
				.creerChamp("depart", 10, TypeChamp.TEXTE);
		Champ c4 = FabChamp.getInstance()
				.creerChamp("prix", 10, TypeChamp.TEXTE);
		List<Champ> champs1 = new ArrayList<Champ>();
		champs1.add(c1);
		champs1.add(c2);
		champs1.add(c3);
		champs1.add(c4);
		List<Champ> champs2 = new ArrayList<Champ>();
		champs2.add(c1);
		champs2.add(c2);
		champs2.add(c4);
		Categorie categorie = FabCategorie.getInstance().creerCategorie(
				"covoiturage", champs1);
		Categorie categorie2 = FabCategorie.getInstance().creerCategorie(
				"biens", champs2);
		Utilisateur utilisateur = FabUtilisateur.getInstance()
				.creerUtilisateur("toto", "titi", "toto.titi@gmail.com",
						Droit.ADMIN);
		return "home";
	}
	private void init2() {
		// champs (Objet)
		ArrayList<Champ> l = new ArrayList<Champ>();
		l.add(new MetierChamp().creerChamp("Titre", 50, TypeChamp.TEXTE));
		l.add(new MetierChamp().creerChamp("Description", 500, TypeChamp.TEXTE));
		l.add(new MetierChamp().creerChamp("Prix", 10, TypeChamp.NUMERIQUE));

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("Titre", "Vend une chaise");
		hm.put("Description", "Bonjour je vends une chaise toute belle !");
		hm.put("Prix", "15");

		HashMap<String, String> hm2 = new HashMap<String, String>();
		hm2.put("Titre", "Vend un livre");
		hm2.put("Description",
				"Bonjour je vends un livre très très interessant avec plein d'images !");
		hm2.put("Prix", "5");

		// Catègorie
		new MetierCategorie().creerCategorie("Objet", l);
		new MetierCategorie().creerCategorie("Covoiturage", l);

		// Utilisateur
		Utilisateur u = new MetierUtilisateur().creerUtilisateur("Smith",
				"John", "John.smith@gmail.com", Droit.DEFAUT);

		// Annonces
		new MetierAnnonce().creerAnnonce(
				new MetierCategorie().getCategorie("Objet"), u,
				TypeAnnonce.offre, hm);
		new MetierAnnonce().creerAnnonce(
				new MetierCategorie().getCategorie("Objet"), u,
				TypeAnnonce.offre, hm2);
		new MetierAnnonce().creerAnnonce(
				new MetierCategorie().getCategorie("Objet"), u,
				TypeAnnonce.offre, hm);
		new MetierAnnonce().creerAnnonce(
				new MetierCategorie().getCategorie("Objet"), u,
				TypeAnnonce.offre, hm2);
	}
}