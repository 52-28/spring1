package com.wildcodeschool.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class Application {

	public static void main(String[] args) {		
		SpringApplication.run(Application.class, args);

	}
	
	@RequestMapping("/doctor/{numberDoctor}")
    @ResponseBody
    public Object doctor(@PathVariable(required = false) String numberDoctor) {

		Doctor doctor9 = new Doctor(9,"Christopher Eccleston");
		Doctor doctor10 = new Doctor(10,"David Tennant");
		Doctor doctor11 = new Doctor(11,"Matt Smith");
		Doctor doctor12 = new Doctor(12,"Peter Capaldi");
		Doctor doctor13 = new Doctor(13,"Jodie Whittaker");
		
		if (Integer.valueOf(numberDoctor)> 8 && Integer.valueOf(numberDoctor)<14) {
				
			switch(numberDoctor) {
	        	case "9":
	        		return(doctor9);
	
	        	case "10":
	        		return(doctor10);
	        	case "11":
	        		return(doctor11);
	        	case "12":
	        		return(doctor12);        			
	        	case "13":
	        		return(doctor13);
			}
		}
	    else if(Integer.valueOf(numberDoctor)>0 && Integer.valueOf(numberDoctor) <9) {
	       	throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Essayez d'en consulter un autre");
	    }
	    else if(numberDoctor ==null) {
	       //else if (numberDoctor == null)    	
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'acces pour la racine");
	    }
	    else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'incarnation du docteur numéro " + numberDoctor +" n'a pas été trouvée" );
	    }
		return null;
	}
}


