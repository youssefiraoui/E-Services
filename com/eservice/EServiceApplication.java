package com.eservice;

//import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.eservice.dao.AnnonceRepository;
import com.eservice.dao.CorpMetierRepository;
import com.eservice.dao.UtilisateurRepository;
import com.eservice.entities.Annonce;
import com.eservice.entities.CorpMetier;
import com.eservice.entities.Utilisateur;
@SpringBootApplication
public class EServiceApplication {

	public static void main(String[] args) {
		ApplicationContext	ctx =SpringApplication.run(EServiceApplication.class, args);
		UtilisateurRepository utilisateurRepository=ctx.getBean(UtilisateurRepository.class);
		/*utilisateurRepository.save(
				new Client("Youssef & doha", " Chkarat & IRAOUI", 
						"youssefDoha@gmail.com", "lolokaty", "koklala", 
						"06/06/1995", 124587));*/
		AnnonceRepository annonceRepository=ctx.getBean(AnnonceRepository.class);
		CorpMetierRepository corpMetierRepository=ctx.getBean(CorpMetierRepository.class);
	/*annonceRepository.save(
				new Annonce("lolololo", "14", "lollllll", 14, "lol.jpg", "Eljadida")
				);*/
		//utilisateurRepository.save(new CorpMetier(2, "lolo.jpg", "oraoui", "youssef", "irapio@gmail.com", "123456", "hay karima", "06/02/2019"));
		List<Annonce> clients=annonceRepository.findAll();
		List<Utilisateur> users=utilisateurRepository.searchIgnoreCaseContaining("plom","casablanca");
		//List<CorpMetier> cc=corpMetierRepository.findByVilleAndService("El jadida", Service)
		CorpMetier cx=corpMetierRepository.findOne((long)2);
		clients.forEach(e->System.out.println(e.getClient().getEmail()));
		System.out.println("---------");
		users.forEach(e->System.out.println(e.getPrenom()));
		System.out.println("---------TAILLE-------");
		System.out.println(users.size());
		//System.out.println(cx.getId());
		System.out.println(clients.size());
		
	}
}
