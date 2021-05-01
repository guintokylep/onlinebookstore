package bookStore.bookStore.domain.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bookStore.bookStore.domain.dao.BookDao;
import bookStore.bookStore.domain.dao.UserDao;
import bookStore.bookStore.domain.dto.BookDTO;
import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BbookM01;
import bookStore.bookStore.domain.entity.BsuserM01;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private EntityManager em;  
	
	@Override
	public List<BbookM01> findBook( BookDTO bookDTO ) {		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT ");
		sb.append("* ");
		sb.append("FROM ");
		sb.append(" bookdetails ");
		
		if( bookDTO.getName() != "" ) {

			sb.append("WHERE  ");
			sb.append("	LOWER(name) LIKE '%" + bookDTO.getName().toLowerCase() + "%'  ");
			sb.append("ORDER BY ranking");
			
			@SuppressWarnings("unchecked")
			List<BbookM01>  result = (List<BbookM01>) em.createNativeQuery(sb.toString(), BbookM01.class)
					.getResultList();
			
			return result; 
		}
		else {
			

			sb.append("ORDER BY ranking");
			
			@SuppressWarnings("unchecked")
			 List<BbookM01> result = (List<BbookM01>) em.createNativeQuery(sb.toString(), BbookM01.class)
					.getResultList();
			
			return result;
		}
		
	}

}
