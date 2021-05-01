package bookStore.bookStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.logic.UserLogic;


@Controller
public class OnlineBookstoreController {

	@Autowired
	private UserLogic userLogic;

	@GetMapping("/bookstore")
	public String init(Model model, HttpServletRequest request ) {

		request.getSession().setAttribute("login", null);
		
		return "login";
	}

	@ResponseBody
	@RequestMapping("/bookstore/login")
	public Boolean login( Model model, HttpServletRequest request, UserDTO userDTO ) {

		boolean valid = false;

		valid = userLogic.findUser(userDTO);
		
		if( valid == true ) {
			request.getSession().setAttribute("login", "true");
		} 

		return valid;
	}
}
