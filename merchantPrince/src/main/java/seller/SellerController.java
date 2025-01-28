package seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/sellers")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	//셀러가입
	@PostMapping("/register")
	public ResponseEntity<SellerResponseDTO> registerSeller(@RequestBody SellerRequestDTO requestDTO){
		System.out.println("셀러가입 api 호출");
		SellerResponseDTO responseDTO = sellerService.registerSeller(requestDTO);
		return ResponseEntity.status(201).body(responseDTO); // 201응답, 200이랑 다름 요청처리가아닌 새로운 리소스 생성임.
	}
	
	//셀러 조회
	@GetMapping("/{sellerNum}")
	public ResponseEntity<SellerResponseDTO> getSeller(@PathVariable Long sellerNum){
		System.out.println("셀러조회 api 호출");
		SellerResponseDTO responseDTO = sellerService.getSeller(sellerNum);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 로그인 api - 유저로그인 api 재사용
	@PostMapping("/login")
	public ResponseEntity<SellerResponseDTO> login(@RequestBody SellerRequestDTO sellerRequestDTO,HttpSession session){
		System.out.println("셀러로그인 api 호출");
		SellerResponseDTO responseDTO = sellerService.login(sellerRequestDTO, session);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 셀러 프로필조회
	@GetMapping("/profile")
	public ResponseEntity<SellerResponseDTO> getSellerProfile(HttpSession session){
		System.out.println("셀러 프로필조회 api 호출");
		SellerResponseDTO responseDTO = sellerService.getSellerProfile(session);
		return ResponseEntity.ok(responseDTO);
		
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("셀러 로그아웃 api 호출");
		session.invalidate();
		return "로그아웃!";
	}
}
