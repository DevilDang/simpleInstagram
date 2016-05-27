package simpleInstagram.web.controllers;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.database.dao.impl.UserDaoImpl;

@Controller
public class UserController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@RequestParam String email, @RequestParam String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			UserDaoImpl dao = new UserDaoImpl(session);

			boolean flag = dao.authenticate(email, password);

			if (flag)
				return "home";
			else
				return "login";

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return "login";

	}
}
