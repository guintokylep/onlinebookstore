package bookStore.bookStore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.logic.UserLogic;


@Controller
public class RegisterController {

	@Autowired
	private UserLogic userLogic;

	@RequestMapping("/bookstore/register")
	public String init(Model model) {
		return "register";
	}

	@ResponseBody
	@RequestMapping("/bookstore/register/save")
	public List<String> login( UserDTO userDTO ) {

		List<String> message = new ArrayList<>();

		message = userLogic.registerUser(userDTO);

		return message;
	}
}
