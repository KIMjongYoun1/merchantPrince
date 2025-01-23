package user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	/*
	 * DTO 활용으로 변경 
	 * 
	 * */
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
			this.userRepository = userRepository;
	}
	
	// 회원가입 
	public void registerUser(UserRequestDTO userRequestDTO) {
		User user = new User();
		user.setUserId(userRequestDTO.getUserId());
		user.setUserName(userRequestDTO.getUserName());
		user.setPassWord(userRequestDTO.getPassword());
		user.setEmail(userRequestDTO.getEmail());
	}
	// 사용자 조회
	public UserResponseDTO findUserById(String userId) {
		User user = userRepository.findById(userId)
					.orElseThrow(() -> new IllegalArgumentException("User not found"));
		
		return new UserResponseDTO(
				user.getUserId(),
				user.getUserName(),
				user.getEmail()
				);
	}
	// 로그인 
	public UserResponseDTO login(UserRequestDTO userRequestDTO) {
		User user = userRepository.findById(userRequestDTO.getUserId())
								  .orElseThrow(() -> new IllegalArgumentException("User not Found"));
		
		if (!user.getPassWord().equals(userRequestDTO.getPassword())) {
			throw new IllegalArgumentException("패스워드오류");
		}
		
		return new UserResponseDTO(
				user.getUserId(),
				user.getUserName(),
				user.getEmail()
				);
	}
}
