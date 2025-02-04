package cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	/*
	 * 등록 (어드민) → 201 Created 사용 (새로운 상품이 생성됨) 새로운게 등록되는것이 아니기에 응답값x 200 ok 사용 장바구니
	 * 추가 (카트) → 200 OK 사용 (장바구니 상태 변경, 기존 데이터 업데이트 가능)
	 * 
	 * 리소스 식별 (ID, 특정 데이터 조회 등) → @PathVariable
	 * - GET /users/12345 
	 * 
	 * 필터링, 검색, 정렬 등 선택적인 데이터 → @RequestParam
	 * - GET /products?categoryId=5&page=2
	 * 
	 * 새로운 데이터 생성 또는 업데이트 (JSON 본문 필요) → @RequestBody
	 * - POST /orders
	 */

	@Autowired
	private CartService cartService;

	// 장바구니 상품 추가
	@PostMapping("/add")
	public ResponseEntity<CartResponseDTO> addCart(@RequestBody CartRequestDTO cartRequestDTO) {

		CartResponseDTO responseDTO = cartService.addCart(cartRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	// 특정 사용자 장바구니 조회
	@GetMapping("/{userId}")
	public ResponseEntity<List<CartResponseDTO>> getUserCart(@PathVariable String userId) {
		List<CartResponseDTO> cartItems = cartService.getCartByUser(userId);
		return ResponseEntity.ok(cartItems);
	}

	// 장바구니 수량 업데이트
	@PutMapping("/update/{cartId}")
	public ResponseEntity<CartResponseDTO> updateCartQuantity(@PathVariable Long cartId, @RequestParam int quantity) {
		System.out.println("장바구니 업데이트 호출");
		CartResponseDTO responseDTO = cartService.updateCartQuantity(cartId, quantity);
		return ResponseEntity.ok(responseDTO);
	}

	// 장바구니 개별상품 삭제
	@DeleteMapping("/{cartid}")
	public ResponseEntity<String> removeCartItem(@PathVariable Long cartId){
		cartService.removeCartItem(cartId);
		return ResponseEntity.ok("상품이 삭제 되었습니다");
		
	}
	
	// 장바구니 전체삭제
	@DeleteMapping("/clear")
	public ResponseEntity<String> clearCart(@RequestParam String userId){
		cartService.clearCart(userId);
		return ResponseEntity.ok("장바구니를 비웠습니다.");
	}
	
}
