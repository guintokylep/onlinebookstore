package bookStore.bookStore.domain.logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import bookStore.bookStore.domain.dao.BookDao;
import bookStore.bookStore.domain.dao.UserDao;
import bookStore.bookStore.domain.dto.BookDTO;
import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BbookM01;
import bookStore.bookStore.domain.entity.BsuserM01;

@Component
public class BookLogic {
	
	@Autowired
	private BookDao bookDao;
	
	
	public List<BbookM01> findBook( BookDTO BookDTO ) {
		
		List<BbookM01> bookList = new ArrayList<>();
		
		bookList = bookDao.findBook( BookDTO );
		
		return bookList;
	}

}
