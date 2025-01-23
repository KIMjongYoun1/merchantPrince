package user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	/*
	 * 
	 * 
	 * */
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	// 회원가입 api
	@PostMapping("/register")
	public ResponseEntity<String> regitserUser(@RequestBody @Validated UserRequestDTO userRequestDTO){
		userService.registerUser(userRequestDTO);
		return ResponseEntity.ok("회원가입 완료");
	}
	
	// 사용자조회 api (로그인유저아님 판매자정보등 상대 프로필)
	@GetMapping("/{user}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable String userId){
		UserResponseDTO responseDTO = userService.findUserById(userId);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 로그인 api
	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> login(@RequestBody @Validated UserRequestDTO userRequestDTO){
		UserResponseDTO responseDTO = userService.login(userRequestDTO);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 로그인 사용자 프로필 조회 
	@GetMapping("/profile")
	public ResponseEntity<UserResponseDTO> getProfile(HttpSession session){
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			throw new IllegalArgumentException("로그인후 이용 하세요");
		}
		
		UserResponseDTO responseDTO = userService.findUserById(userId);
		return ResponseEntity.ok(responseDTO);
	}
	
}
