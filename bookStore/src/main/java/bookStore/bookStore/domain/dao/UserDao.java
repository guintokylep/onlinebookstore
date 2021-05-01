package bookStore.bookStore.domain.dao;

import java.util.List;

import bookStore.bookStore.domain.dto.UserDTO;
import bookStore.bookStore.domain.entity.BsuserM01;

public interface UserDao {

	public List<BsuserM01> findUser( UserDTO userDTO );
	
	public List<BsuserM01> findUsername( UserDTO userDTO );
	
	public UserDTO registerUser( UserDTO userDTO );

}
