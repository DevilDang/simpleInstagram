package simpleInstagram.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
	
	@RequestMapping(value = { "/mainpage" }, method = RequestMethod.GET)
	public String renderMainPage() {
		return "mainpage";
	}

}
