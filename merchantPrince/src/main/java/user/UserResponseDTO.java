package user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
	
	/*
	 * */
	
	private String userId;
	private String userName;
	private String email;
	
	public UserResponseDTO(String userId, String userName, String email) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
	}
}
