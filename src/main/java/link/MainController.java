package link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import link.Kategorijos;
import link.KategorijosRepository;

import link.Nuorodos;
import link.NuorodosRepository;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/restfull") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private KategorijosRepository kategorijosRepository;
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data	
	private NuorodosRepository nuorodosRepository;
	
	/*
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String naujasProduktas (@RequestParam String pav
			, @RequestParam String mat_vnt 
			, @RequestParam Double mat_kiek
			, @RequestParam Double kaina
			, @RequestParam Double kiekis_sand			
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Produktai n = new Produktai();
		n.setPav(pav);
		n.setMat_vnt(mat_vnt);
		n.setMat_kiek(mat_kiek);
		n.setKaina(kaina);
		n.setKiekis_sand(kiekis_sand);
		System.out.println (n.toString() );
		produktaiRepository.save(n);
		return "Saved";
	}
	
	//neaišku ar čia problema, kodėl neprideda patiekalo užsakymuose.
	*/ 
	
	/*
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String naujasUzsakymas (@RequestParam String pav
			, @RequestParam Integer trukme_ruosimo
			, @RequestParam Integer trukme_kaitinimo
			//, @RequestParam Double kaina
			//, @RequestParam Integer id_patiekalo
			//, @RequestParam String klientas
			, @RequestParam String pastabos
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Uzsakymai n = new Uzsakymai();
		n.setPav(pav);
		n.setTrukme_ruosimo(trukme_ruosimo);
		n.setTrukme_kaitinimo(trukme_kaitinimo);
		//n.setKaina(kaina);
		//n.setId_patiekalo(id_patiekalo);
		//n.setKlientas(klientas);
		n.setKlientas(pastabos);
		n.setBusena( "uzsakytas" );
		System.out.println (n.toString() );
		uzsakymaiRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/changestatus") // Map ONLY GET Requests
	public @ResponseBody String keistiBusena (@RequestParam String busena
			, @RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Uzsakymai> found = uzsakymaiRepository.findById( id );
		
		// variantas trynimuiui
		// uzsakymaiRepository.deleteById(id);
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Uzsakymai n = found.get();
			   n.setId(id);
			   n.setBusena(busena);
			   
			   // pagal https://coderanch.com/t/304851/databases/Java-date-MySQL-date-conversion

			   java.util.Date dt = new java.util.Date();
			   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   String currentTime = sdf.format(dt);
			   // \pagal
			   n.setLaikas_pateikimo(currentTime);			   
			   uzsakymaiRepository.save(n);	
			   res = "Saved";
			}		
		return res;
	}
	*/
	
/*	
	@GetMapping(path="/patiekalo-produktas") // Map ONLY GET Requests
	public @ResponseBody String saugotiProduktaPatiekalo (@RequestParam Integer id 
			, @RequestParam Double kiekis_produkto
			, @RequestParam(defaultValue="0") Integer id_prod
			, @RequestParam(defaultValue="0") Integer id_pat
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Patiekalu_produktai n = new Patiekalu_produktai();
		
		if (id > 0) {
		
			Optional <Patiekalu_produktai> found = patiekalu_produktaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
			
		} else {
		
			if ( ( id_prod > 0 ) && ( id_pat > 0 ) ) {
				
				n.setProduktai_id ( id_prod );
				n.setPatiekalai_id( id_pat );
			}
		}
		n.setKiekis_produkto ( kiekis_produkto );
			   			   
		patiekalu_produktaiRepository.save(n);	
		res = "Saved";
	    
		return res;
	}
	
*/	
	
	@GetMapping(path="/saugoti-kategorija") // Map ONLY GET Requests
	public @ResponseBody String saugotiKategorija (@RequestParam Integer id
			, @RequestParam String pav 
			, @RequestParam Integer id_parent
			
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		
		String res = "Not done";
		Kategorijos n = new Kategorijos();
		
		if (id > 0) {
		
			Optional <Kategorijos> found = kategorijosRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPav( pav );
	    
	    if (id_parent > 0 ) {
	    	
	    	n.setId_parent( id_parent );
	    }
	    
	    kategorijosRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}	
		
	
	@GetMapping(path="/salinti-kategorija") // Map ONLY GET Requests
	public @ResponseBody String salintiKategorija ( @RequestParam Integer id ) {
	
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
	
		Optional <Kategorijos> found = kategorijosRepository.findById( id );
		String res = "Not done";
	
		if ( found.isPresent() ) {
			
			Kategorijos n = found.get();
			kategorijosRepository.deleteById(id);
			res = "Deleted";
		}
		return res;
	}
	
	
	//patiekalu salinimas ir redagavimas cia:
	
	@GetMapping(path="/saugoti-nuoroda") // Map ONLY GET Requests
	public @ResponseBody String saugotiNuoroda (@RequestParam Integer id
			, @RequestParam String pav
			, @RequestParam String link
			, @RequestParam Integer kategorijos_id
			, @RequestParam String tipas
			, @RequestParam Integer rating
			, @RequestParam String flags
			, @RequestParam String aprasymas
			
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		
		String res = "Not done";
		Nuorodos n = new Nuorodos();
		
		if (id > 0) {
		
			Optional <Nuorodos> found = nuorodosRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPav( pav );
	    n.setKategorijos_id(kategorijos_id);
	    n.setLink( link );
	    n.setTipas( tipas );
	    n.setRating( rating );
	    n.setFlags(flags);
	    n.setAprasymas(aprasymas);
			   			   
	    nuorodosRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}	
		
	
	@GetMapping(path="/salinti-nuoroda") // Map ONLY GET Requests
	public @ResponseBody String salintiNuoroda ( @RequestParam Integer id ) {
	
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Nuorodos> found = nuorodosRepository.findById( id );
		
		String res = "Not done";

		if ( found.isPresent() ) {
			
			Nuorodos n = found.get();
			nuorodosRepository.deleteById(id);
			   res = "Deleted";
		}
		return res;
	}
	
	@GetMapping(path="/lst-kategorijos")
	public @ResponseBody Iterable<Kategorijos> getAllKategorijos() {
		// This returns a JSON or XML with the users
		return kategorijosRepository.findAll();
	}
	
	
	 @GetMapping(path="/lst-nuorodos")
		public @ResponseBody Iterable<Nuorodos> getAllNuorodos() {
		// This returns a JSON or XML with the users
		 return nuorodosRepository.findAll();
	}
	
	 
	 
	// @GetMapping(path="/del-product")
		//public @ResponseBody Iterable<Produktai> getAllProduktaix() {
		// This returns a JSON or XML with the users
		 //return produktaiRepository.findAll();
	//}
	
		
	
	

	
		

}
