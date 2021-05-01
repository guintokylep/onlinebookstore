package bookStore.bookStore.domain.dao;

import java.util.List;

import bookStore.bookStore.domain.dto.BookDTO;
import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BbookM01;
import bookStore.bookStore.domain.entity.BsuserM01;

public interface BookDao {

	public List<BbookM01> findBook( BookDTO bookDTO );

}
