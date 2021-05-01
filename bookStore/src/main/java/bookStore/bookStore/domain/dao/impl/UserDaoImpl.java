package bookStore.bookStore.domain.dao.impl;



import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bookStore.bookStore.domain.dao.UserDao;
import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BsuserM01;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private EntityManager em;  
	
	@Override
	public List<BsuserM01> findUser( UserDTO userDTO ) {		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT ");
		sb.append("* ");
		sb.append("FROM ");
		sb.append("usermaster ");
		sb.append("WHERE  ");
		sb.append("	username = ?  ");
		sb.append("AND  ");
		sb.append(" password = ?  ");
		
		@SuppressWarnings("unchecked")
		List<BsuserM01> result = (List<BsuserM01>) em.createNativeQuery(sb.toString(), BsuserM01.class)
				.setParameter(1, userDTO.getUsername())
				.setParameter(2, userDTO.getPassword())
				.getResultList();
		
		return result;
	}
	
	@Override
	public List<BsuserM01> findUsername( UserDTO userDTO ) {		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT ");
		sb.append("* ");
		sb.append("FROM ");
		sb.append("usermaster ");
		sb.append("WHERE  ");
		sb.append("	LOWER(username) = ?  ");
		
		@SuppressWarnings("unchecked")
		List<BsuserM01> result = (List<BsuserM01>) em.createNativeQuery(sb.toString(), BsuserM01.class)
				.setParameter(1, userDTO.getUsername().toLowerCase())
				.getResultList();
		
		return result;
	}
	
	@Transactional
	public UserDTO registerUser( UserDTO userDTO ) {		
		
		BsuserM01 bsuserM01 = new BsuserM01(userDTO) ;
		
		em.persist(bsuserM01);
		
		return userDTO;
	}

}
