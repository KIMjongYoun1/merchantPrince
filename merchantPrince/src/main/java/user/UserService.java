package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	
	/*
	 * DTO 활용으로 변경 
	 *  생성자 주입 final 제거 어노테이션으로 변경
	 * */
	@Autowired
	private UserRepository userRepository;
	
	
	
	// 회원가입 
	public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
		
		if (userRepository.existsByUserId(userRequestDTO.getUserId())) {
	        throw new RuntimeException("이미 존재하는 사용자 아이디입니다.");
	    }
		User user = new User();
		user.setUserId(userRequestDTO.getUserId());
		user.setUserName(userRequestDTO.getUserName());
		user.setPassWord(userRequestDTO.getPassword());
		user.setEmail(userRequestDTO.getEmail());
		
		User savedUser = userRepository.save(user);
		
		return new UserResponseDTO(savedUser);
	}
	// 사용자 조회
	public UserResponseDTO findUserById(String userId) {
		User user = userRepository.findById(userId)
					.orElseThrow(() -> new IllegalArgumentException("User not found"));
		
		
		return new UserResponseDTO(user);
				
	}
	// 로그인 
	public UserResponseDTO login(UserRequestDTO userRequestDTO, HttpSession session) {
		User user = userRepository.findById(userRequestDTO.getUserId())
								  .orElseThrow(() -> new IllegalArgumentException("User not Found"));
		
		if (!user.getPassWord().equals(userRequestDTO.getPassword())) {
			throw new IllegalArgumentException("패스워드오류");
		}
		
		session.setAttribute("userId", user.getUserId());
		
		return new UserResponseDTO(user);
				
	}
}
