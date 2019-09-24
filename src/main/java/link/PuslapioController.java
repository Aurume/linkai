package link;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PuslapioController {

	@RequestMapping("/")
    public String menu( Model model ) {
      	
        model.addAttribute("lst_menu", Menu.values() );    	
        return "index";
    }
	
    /*
    @RequestMapping("/simple") // pavyzdys ka atiduoda, kai yra response body, o ne String
    public @ResponseBody String greeting() {
        return "Hello Simple";
    }    
    */
    
    //pridedu cia kategorijas, nereikia naudoti model atrtribute ir name laukeliu. uztenka paprastos strukturos.
    @GetMapping("/kategorijos")
    public String kategorijos() {
        return "kategorijos";
    }
    
    @GetMapping("/nuorodos")
    public String nuorodos() {
        return "nuorodos";
    }  
}
