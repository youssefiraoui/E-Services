package com.eservice.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eservice.dao.AccordRepository;
import com.eservice.dao.AnnonceRepository;
import com.eservice.dao.ClientRepository;
import com.eservice.dao.CorpMetierRepository;
import com.eservice.dao.OffreRepository;
import com.eservice.dao.UtilisateurRepository;
import com.eservice.entities.Annonce;
import com.eservice.entities.*;
import com.eservice.entities.CorpMetier;
import com.eservice.entities.Utilisateur;

@Controller
@RequestMapping(value = "E-service")
public class HomeController {

	// pour le path ou on va enregistrer les images
	@Value("${dir.imagesAnnoces}")
	private String ImagesAnnonces;
	@Value("${dir.corpMImage}")
	private String ImageCorp;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CorpMetierRepository corpMetierRepository;
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private AccordRepository accordRepository;
	/// pages des listes d'annoces index par default
	@RequestMapping(value = "/Index")
	public String Index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			 @RequestParam(name = "metier",defaultValue = "")String titre,
			 @RequestParam(name = "ville",defaultValue = "")String ville) {
		/*
		Page<Annonce> annonnces = annonceRepository.findAll(new PageRequest(p, 3));
		int pagesCount = annonnces.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++)
			pages[i] = i;
		// List<Utilisateur> clients=utilisateurRepository.afficherAllAnnonces();
		model.addAttribute("annonnces", annonnces);
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		
		
*/	
		
		System.out.println(titre +" "+ ville);
		List<Annonce> annonnces;
		List<CorpMetier> users;
		model.addAttribute("corpmetier", new CorpMetier(5,"lklklk","jjjjj","kjh","","","jjj","01/01/1995"));
		if(titre.isEmpty() && ville.isEmpty()) {
			annonnces=annonceRepository.findAll();
			users=corpMetierRepository.findAll();
			annonnces.forEach(e->System.out.println(e.getClient().getEmail()));
			model.addAttribute("annonnces", annonnces);
			model.addAttribute("users",users);
			System.out.println("22222222222");
		}else {
			annonnces=annonceRepository.searchIgnoreCaseContaining(titre, ville);
			users=corpMetierRepository.searchIgnoreCaseContaining(titre,ville);
			model.addAttribute("users",users);
			model.addAttribute("annonnces", annonnces);
		}
			
		
		
		
		return "home";
	}

	// formulaire pour deposer une annonce
	@RequestMapping(value = "/formAnnonce", method = RequestMethod.GET)
	public String AddAnnonce(Model model,HttpSession session) {
		Client cl=(Client) session.getAttribute("conUser");
		//Utilisateur u=(Utilisateur)session.getAttribute("conUser");
		//client cl=(client)u;
		System.out.println(cl.toString());
		model.addAttribute("annonce", new Annonce());
		model.addAttribute("corpmetier", new Client());
		return "service-add";
	}

	// formulaire d inscription d client
	@RequestMapping(value = "/AddUser", method = RequestMethod.GET)
	public String AddUser(Model model) {
		model.addAttribute("client", new Client());
		return "AddClient";
	}
	@RequestMapping(value = "/AddUserC", method = RequestMethod.GET)
	public String AddUserC(Model model) {
		System.out.println("7878787878");
		model.addAttribute("corpmetier", new CorpMetier(5,"lklklk","jjjjj","kjh","","","jjj","01/01/1995"));
		System.out.println("787878******8");
		return "addCorpMetier";
	}
	
	@RequestMapping(value = "/SaveCorp", method = RequestMethod.POST)
	public String SaveUserC(@Valid CorpMetier c,BindingResult bindingResult,
			@RequestParam(name = "pic1") MultipartFile fileImage,
			@RequestParam(name = "pic2") MultipartFile fileCin) throws IllegalStateException, IOException {
		System.out.println("--/********1111111*******");
		System.out.println(c.toString());
		if (bindingResult.hasErrors()) {
			return "addCorpMetier";
		}
		if(!fileCin.isEmpty() && !fileImage.isEmpty()) {
			System.out.println("--/*****222222******");
			c.setCin(fileCin.getOriginalFilename());
			c.setImage(fileImage.getOriginalFilename());
			System.out.println(fileImage.getOriginalFilename()+"--/******************"+ImageCorp+fileCin.getOriginalFilename());
			fileCin.transferTo(new File(ImageCorp+fileCin.getOriginalFilename()));
			System.out.println("--/*********444444*****");
			fileImage.transferTo(new File(ImageCorp+fileImage.getOriginalFilename()));
			System.out.println("--/************5555");}
		corpMetierRepository.save(c);
		System.out.println("--/***5555***********");
		return "redirect:/E-service/Index";
	}
	// fonction qui trite l enregistrement e uplaod
	@RequestMapping(value = "/AddAnnonce", method = RequestMethod.POST)
	public String SaveAnnonce(@Valid Annonce a, BindingResult bindingResult,
			@RequestParam(name = "picture") MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException {
		
		Client c = (Client) session.getAttribute("conUser");
		System.out.println("--/******************");

		if (bindingResult.hasErrors()) {
			return "AddService";
		}
		if (!file.isEmpty()) {
			a.setImage(file.getOriginalFilename());
			System.out.println("--/******************"+ImagesAnnonces + file.getOriginalFilename());
			
			file.transferTo(new File(ImagesAnnonces + file.getOriginalFilename()));
			System.out.println(ImagesAnnonces + file.getOriginalFilename());
		}
		a.setClient(c);
		annonceRepository.save(a);
		return "redirect:/E-service/Index";
	}

	// fonction qui enregistre un client
	@RequestMapping(value = "/AddClient", method = RequestMethod.POST)
	public String SaveClient(Client c) {
		System.out.println(c.toString());
		System.out.println("--/******************");
		clientRepository.save(c);
		System.out.println("--/******************");
		return "redirect:/E-service/Index";
	}

	@RequestMapping(value = "/conn")
	public String Conn(Model model) {
		return "home";
	}

	@RequestMapping(value = "/info/{id_an}")
	public String InfoServ(Model modele,@PathVariable("id_an") Long id_an,HttpSession session) {
		Annonce a=annonceRepository.findOne((long) id_an);
		CorpMetier cl=(CorpMetier) session.getAttribute("conUser");
		if(a==null) {
			return "redirect:/E-service/Index";
		}
		modele.addAttribute("annonce",a);
		modele.addAttribute("userC",cl);
		return "service";
	}
	@RequestMapping(value = "/Connection")
	public String Connection(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			Model modele,HttpSession session,Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			 @RequestParam(name = "metier",defaultValue = "")String titre,
			 @RequestParam(name = "ville",defaultValue = "")String ville) {
		System.out.println(email);
		System.out.println(password);
		if (email == null && password == null) {
			return "home";
		}
		System.out.println("--/-------------------***************************************");
		Utilisateur u = utilisateurRepository.findByEmailAndPassword(email, password);
		session.setAttribute("conUser", u);
		modele.addAttribute("userC",u);
		System.out.println("--/-------------------***************************************");
		System.out.println(u.toString());
		System.out.println(titre +" "+ ville);
		List<Annonce> annonnces;
		List<CorpMetier> users;
		modele.addAttribute("corpmetier", new CorpMetier(5,"lklklk","jjjjj","kjh","","","jjj","01/01/1995"));
		if(titre.isEmpty() && ville.isEmpty()) {
			annonnces=annonceRepository.findAll();
			users=corpMetierRepository.findAll();
			annonnces.forEach(e->System.out.println(e.getClient().getEmail()));
			modele.addAttribute("annonnces", annonnces);
			modele.addAttribute("users",users);
			System.out.println("22222222222");
		}else {
			annonnces=annonceRepository.searchIgnoreCaseContaining(titre, ville);
			users=corpMetierRepository.searchIgnoreCaseContaining(titre,ville);
			model.addAttribute("users",users);
			model.addAttribute("annonnces", annonnces);
		}
			
		
		
		System.out.println("--/-------------------***************************************");
		return "header-connected";
	}
	
	
	@RequestMapping(value="/search")
	public String Search(Model model,@RequestParam(name = "service") String service,
			@RequestParam(name = "ville") String ville) {
		List<Utilisateur> users=utilisateurRepository.searchIgnoreCaseContaining(service,ville);
		
		// List<Utilisateur> clients=utilisateurRepository.afficherAllAnnonces();
		model.addAttribute("users", users);
		
		return "";
	}
	
	@RequestMapping(value="/offre/{id_an}")
	public String Offre(HttpSession session,@PathVariable("id_an") Long id_an) {
		System.out.println("ghanbdaw");
		Annonce a=annonceRepository.findOne((long) id_an);
		CorpMetier cl=(CorpMetier) session.getAttribute("conUser");
		System.out.println(cl.toString());
		if(cl==null || a==null){
			System.out.println("aykhrej");
			return "home";
		}
		Offre of=new Offre();
		of.setAdresse(a.getAddresse());
		of.setVille(a.getVille());
		of.setCorpMetier(cl);
		of.setClient(a.getClient());
		of.setDateOffre(new Date());
		offreRepository.save(of);
		System.out.println("oook rak nadiii");
		return "redirect:/E-service/Index";
	}
	/*
	 * Effectuer un accord entre client et corpMetiers
	 */
	@RequestMapping(value="/accord/{id_cl}")
	public String Accord(HttpSession session,@PathVariable("id_cl") Long id_cl ) {
		System.out.println("test1");
		CorpMetier cm=(CorpMetier)session.getAttribute("conUser");
		System.out.println("test1");
		Client cl= clientRepository.findOne((long)id_cl);
		if(cl==null || cm==null){
			System.out.println("aykhrej dak chi khawi");
			return "home";
		}
		Accord a=new Accord();
		a.setAdresseCl(cl.getAdresse());
		a.setClient(cl);
		a.setCorpMetier(cm);
		a.setDateAccord(new Date());
		a.setVille(cl.getVille());
		accordRepository.save(a);
		System.out.println("oook rak nadiii assat");
		return "redirect:/E-service/Index";
	}
	/*
	 * 
	 */
}
