package bookStore.bookStore.domain.logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import bookStore.bookStore.domain.dao.UserDao;
import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BsuserM01;

@Component
public class UserLogic {
	
	@Autowired
	private UserDao userDao;
	
	
	public Boolean findUser( UserDTO userDTO ) {
		
		boolean valid = false ;
		
		List<BsuserM01> user = new ArrayList<>();
		
		user = userDao.findUser( userDTO );
		
		if( !user.isEmpty() ) {
			valid = true;
		}
		
		
		return valid;
	}
	
	public List<String> registerUser( UserDTO userDTO ) {
		
		int exist =  userDao.findUsername( userDTO ).size();
		List<String>  message = new ArrayList<>();
		
		if( exist > 0 ) {
			
			message.add("error");
			message.add("Username is already exist.");
		}
		else {

			UserDTO user = new UserDTO();
			
			user = userDao.registerUser( userDTO );

			message.add("success");
			message.add("Registration completed succesfully");
			
		}
		
		return message;
	}

}
