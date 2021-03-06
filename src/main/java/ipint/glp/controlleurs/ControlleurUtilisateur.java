package ipint.glp.controlleurs;

import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

import ipint.glp.donnees.Annonce;
import ipint.glp.donnees.Evenement;
import ipint.glp.donnees.Job;
import ipint.glp.metiers.MetierAnnonce;
import ipint.glp.metiers.MetierEvenement;
import ipint.glp.metiers.MetierJob;
import ipint.glp.metiers.MetierUtilisateur;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlleurUtilisateur {
	private static final Logger logger = LoggerFactory
			.getLogger(ControlleurUtilisateur.class);
	
	private MetierUtilisateur metierUtilisateur = new MetierUtilisateur();
	private MetierAnnonce metierAnnonce = new MetierAnnonce();
	private MetierJob metierJob = new MetierJob();
	private MetierEvenement metierEvenement = MetierEvenement.getInstance();
	
	@RequestMapping(value = "/utilisateur/connecter", method = RequestMethod.GET)
	public String connecter() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
	public String profil() {
		return "/utilisateur/profil";
	}
	
	@RequestMapping(value = "/utilisateur/lister/annonce", method = RequestMethod.GET)
	public String listerAnnonce(Model model, HttpServletRequest request) {
		model.addAttribute("annonces", metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesAnnonces());
		return "/utilisateur/lister/annonce";
	}
	
	@RequestMapping(value = "/utilisateur/lister/annonce", method = RequestMethod.POST)
	public String listerAnnonce2(Model model, HttpServletRequest request,@RequestParam("ref") int reference,@RequestParam("typeAction") String action) {
		System.out.println(reference);
		System.out.println(action);
		
		Annonce an = metierAnnonce.rechercher(reference);
		if(action.equalsIgnoreCase("republier"))
		{
			Calendar cal = new GregorianCalendar();
			cal.add(Calendar.DAY_OF_MONTH,30);
			Date d = new Date(cal.getTimeInMillis());
			an.setFinpublication(d);
			metierAnnonce.modifier(an);
			model.addAttribute("republierSucces", true);
			
			
		}
		
		if(action.equalsIgnoreCase("supprimer"))
		{
			metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesAnnonces().remove(an);
			metierAnnonce.supprimerAnnonce(an);
		}
		model.addAttribute("annonce", an);
		model.addAttribute("annonces", metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesAnnonces());
		return "/utilisateur/lister/annonce";
	}
	
	@RequestMapping(value = "/utilisateur/lister/evenement", method = RequestMethod.GET)
	public String listerEvenement(Model model, HttpServletRequest request) {
		model.addAttribute("evenements", metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesEvenements());
		return "/utilisateur/lister/evenement";
	}
	
	@RequestMapping(value = "/utilisateur/lister/evenement", method = RequestMethod.POST)
	public String listerEvenement2(Model model, HttpServletRequest request,@RequestParam("ref") int reference,@RequestParam("typeAction") String action) {
		Evenement evenement = metierEvenement.obtenir(reference);
		if(action.equalsIgnoreCase("supprimer"))
		{
			metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesEvenements().remove(evenement);
			metierEvenement.supprimer(evenement);
		}
		model.addAttribute("evenements", metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesEvenements());
		return "/utilisateur/lister/evenement";
	}
	@RequestMapping(value = "/utilisateur/lister/job", method = RequestMethod.GET)
	public String listerJob (Model model, HttpServletRequest request) {
		model.addAttribute("jobs", metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesJobs());
		return "/utilisateur/lister/job";
	}
	
	@RequestMapping(value = "/utilisateur/lister/job", method = RequestMethod.POST)
	public String listerJob2 (Model model, HttpServletRequest request,@RequestParam("ref") int reference,@RequestParam("typeAction") String action) {
		Job job = metierJob.rechercher(reference);
		if(action.equalsIgnoreCase("supprimer"))
		{
			metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesJobs().remove(job);
			metierJob.supprimer(job);
		}
		model.addAttribute("jobs", metierUtilisateur.getUtilisateur((CasAuthenticationToken) request.getUserPrincipal()).getLesJobs());
		return "/utilisateur/lister/job";
	}
}
