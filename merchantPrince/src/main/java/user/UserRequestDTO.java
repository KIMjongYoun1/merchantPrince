package user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
	
	/*
	 * 
	 * */
	
	@NotBlank(message = "User Id is required")
	private String userId;
	
	@NotBlank(message = "User Name is required")
	private String userName;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	private String email;
	
}
