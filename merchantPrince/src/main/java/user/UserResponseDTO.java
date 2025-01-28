package user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
	
	/*
	 * 매서드 상세로인자값 String userId, String.... 하면 불편해짐 명시다해줘야함 
	 * User user로 객체로 받으면 깔끔해짐 객체로 받아짐
	 * */
	
	private String userId;
	private String userName;
	private String email;
	
	public UserResponseDTO(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
	}

	
}
