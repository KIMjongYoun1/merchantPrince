package shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

	/*
	 * 단순 조회만 하기때문에 응답값 조회 없음 Controller에서 return shopService.getAllProducts(); 하면
	 * 바로 데이터가 반환됨. 로직이 간단하고 가독성이 좋음.
	 */

	@Autowired
	private ShopService shopService;

	// 전체 상품 조회
	@GetMapping("/products")
	public ResponseEntity<List<ShopResponseDTO>> getAllProducts() {
		return ResponseEntity.ok(shopService.getAllproducts());
	}

	// 상품 개별조회
	@GetMapping("/products/{productId}")
	public ResponseEntity<ShopResponseDTO> getProduct(@PathVariable Long productId) {
		return ResponseEntity.ok(shopService.getProduct(productId));
	}

	// 카테고리별 상품조회
	@GetMapping("/products/category/{categoryId}")
	public ResponseEntity<List<ShopResponseDTO>> getProductByCategory(@PathVariable Long categoryId) {
		return ResponseEntity.ok(shopService.getProductsByCategory(categoryId));
	}

	// 키워드 검색
	@GetMapping("/products/search")
	public ResponseEntity<List<ShopResponseDTO>> searchProducts(@RequestParam String keyword) {
		return ResponseEntity.ok(shopService.serchProducts(keyword));
	}

}
