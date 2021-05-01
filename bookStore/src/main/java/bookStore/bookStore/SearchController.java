package bookStore.bookStore;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookStore.bookStore.domain.dto.BookDTO;
import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BbookM01;
import bookStore.bookStore.domain.logic.BookLogic;
import bookStore.bookStore.domain.logic.UserLogic;

@Controller
public class SearchController {

	@Autowired
	private BookLogic bookLogic;

	@RequestMapping("/bookstore/search")
	public String searchInit( HttpSession session ) {
		
		if ( session.getAttribute("login") == null ){
			return "redirect:/bookstore";
		}
		
		return "search";
	}

	@ResponseBody
	@RequestMapping("/bookstore/search/list")
	public List<BbookM01> searchList( BookDTO bookDTO  ) {
		
		List<BbookM01> bookList = new ArrayList<>();
		
		bookList = bookLogic.findBook(bookDTO);
		
		return bookList;
	}
	
	@RequestMapping("/bookstore/logout")
	public String searchList(HttpServletRequest request) {
        request.getSession().invalidate();
		return "login";
	}
}
