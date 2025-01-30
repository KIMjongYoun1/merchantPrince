package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {
	/*
	 * 
	 * 
	 * */
	@Autowired
	private UserService userService;
	
	
	// 회원가입 api
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> regitserUser(@RequestBody UserRequestDTO userRequestDTO){
		System.out.println("회원가입 요청 도착:");
		UserResponseDTO responseDTO = userService.registerUser(userRequestDTO);
		return ResponseEntity.status(201).body(responseDTO);
	}
	
	// 사용자조회 api (로그인유저아님 판매자정보등 상대 프로필) 필요없으면 삭제예정 셀러 구현함
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable String userId){
		System.out.println("사용자조회 api 호출");
		UserResponseDTO responseDTO = userService.findUserById(userId);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 로그인 api
	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO, HttpSession session){
		System.out.println("로그인 api 호출");
		UserResponseDTO responseDTO = userService.login(userRequestDTO, session);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 로그인 사용자 프로필 조회 - 서비스로직에 있어야함 셀러에서는 서비스로직 구분해서 컨트롤러 호출만 함
	@GetMapping("/profile")
	public ResponseEntity<UserResponseDTO> getProfile(HttpSession session){
		System.out.println("로그인 사용자 프로필 api 호출");
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			throw new IllegalArgumentException("로그인후 이용 하세요");
		}
		
		UserResponseDTO responseDTO = userService.findUserById(userId);
		return ResponseEntity.ok(responseDTO);
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 api 호출");
		session.invalidate();
		return "로그아웃!";
	}
}
