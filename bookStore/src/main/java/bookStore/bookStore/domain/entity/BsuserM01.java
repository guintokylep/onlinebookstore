package bookStore.bookStore.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import bookStore.bookStore.domain.dto.UserDTO;

@Entity
@Table(name="usermaster")
public class BsuserM01 {
	
	@Id
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;
	
	@Column(name="useraddress")
	private String useraddress;
	
	@Column(name="useremail")
	private String useremail;
	
	public BsuserM01() {
		
	}
	
	public BsuserM01( UserDTO userDTO ) {
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
		this.useraddress = userDTO.getUseraddress();
		this.useremail = userDTO.getUseremail();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	
}
