package com.eservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eservice.dao.AnnonceRepository;
import com.eservice.dao.*;
import com.eservice.dao.CorpMetierRepository;
import com.eservice.dao.UtilisateurRepository;
import com.eservice.entities.*;

@Controller
@RequestMapping(value = "E-service")
public class AdminPanelControllers {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CorpMetierRepository corpMetierRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private AccordRepository accordRepository;
	@Autowired
	private OffreRepository offreRepository;
	
	/*
	 * Home dyal Admin Panel
	 */
	
	@RequestMapping(value="/admin")
	public String homeAdmin(Model modele) {
		List<Utilisateur> users=utilisateurRepository.findAll();
		List<Service> services=serviceRepository.findAll();
		List<Accord> accords=accordRepository.findAll();
		List<Client> clients=clientRepository.findAll();
		List<CorpMetier> cmetier=corpMetierRepository.findAll();
		System.out.println(accords.toString());
		modele.addAttribute("users",users);
		modele.addAttribute("services",services);
		modele.addAttribute("accords",accords);
		modele.addAttribute("clients",clients);
		modele.addAttribute("cmetier",cmetier);
		
		//return "corpmetiers-list";
		
		return "admin";
	}
	
	@RequestMapping(value="/testtt")
	public String homeAd(Model modele) {
		List<Accord> accords=accordRepository.findAll();
		System.out.println(accords.toString());
		System.out.println("----------------");
		modele.addAttribute("accords",accords);
		return "accords";
	}
	@RequestMapping(value="/admin2")
	public String admin2(Model modele) {
		
		return "admin";
	}
	@RequestMapping(value="/demande")
	public String ad(Model modele) {
		List<Offre> offres=offreRepository.findAll();
		System.out.println(offres.toString());
		modele.addAttribute("offres",offres);
		return "demandes";
	}
	@RequestMapping(value="/frag")
	public String admi2(Model modele) {
		Utilisateur u = utilisateurRepository.findOne((long)1);
		modele.addAttribute("userC", u);
		return "lolo";
	}
	
	

}
