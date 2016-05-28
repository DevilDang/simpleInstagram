package simpleInstagram.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import simpleInstagram.database.modelenity.User;
import simpleInstagram.system.SimpleinstagramContextListner;
import simpleInstagram.web.businessobject.UserBo;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String rennderLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {

		UserBo userbo = new UserBo();

		try {
			if (userbo.authenticate(email, password)) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", email);
				
				logger.debug(email + " was logged");
				return new ModelAndView("mainpage", "userLogged", email);
			} else {
				logger.debug(email + " logged failed");
				return new ModelAndView("login", "error", "wrong username or password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ModelAndView("login", "error", e.getMessage());
		}
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String doLogout(HttpServletRequest request) {

		request.getSession().removeAttribute("user");

		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView dosignup(@RequestParam String username, @RequestParam String email,
			@RequestParam String password, HttpServletRequest request) {

		UserBo userbo = new UserBo();

		User user = new User();
		user.setEmail(email);
		user.setName(username);
		user.setPassword(password);

		try {
			if (userbo.createUser(user)) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", email);
				logger.debug(email + " was logged");
				return new ModelAndView("login", "mesageSignUp", "Sign up sucessfully");
			} else {
				logger.debug(email + " logged failed");
				return new ModelAndView("login", "mesageSignUp", "Sign up fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ModelAndView("login", "mesageSignUp", e.getMessage());
		}

	}

}
