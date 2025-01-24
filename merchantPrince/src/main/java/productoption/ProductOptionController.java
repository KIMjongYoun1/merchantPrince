package productoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-option")
public class ProductOptionController {
	
	@Autowired
	private ProductOptionService productOptionService;
	
	// 상품 옵션추가
	@PostMapping("/add")
	public ResponseEntity<ProductOptionResponseDTO> getProductOption(@RequestBody ProductOptionRequestDTO requestDTO){
		System.out.println("상품 옵션추가 호출");
		ProductOption productOption = productOptionService.addProductOption(requestDTO);
		ProductOptionResponseDTO responseDTO = new ProductOptionResponseDTO(productOption);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 상품 옵션조회 - 단일옵션만
	@GetMapping("{optionId}")
	public ResponseEntity<ProductOptionResponseDTO> getProductOption(@PathVariable Long optionId){
		System.out.println("상품 단일옵션조회 호출");
			ProductOptionResponseDTO responseDTO = productOptionService.getProductOption(optionId);
			return ResponseEntity.ok(responseDTO);
	}
	
	// 상품 옵션 수정
	@PutMapping("/{optionId}")
	public ResponseEntity<ProductOptionResponseDTO> updateProductOption(@PathVariable Long optionId,
												@RequestBody ProductOptionRequestDTO requestDTO){
		System.out.println("상품 옵션수정 호출");
		ProductOptionResponseDTO responseDTO = productOptionService.updateProductOption(optionId, requestDTO);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 상품 옵션 삭제
	@DeleteMapping("/{optionId}")
	
	public ResponseEntity<Void> deleteProductOptoin(@PathVariable Long optionId){
		System.out.println("상품 옵션삭제 호출");
		productOptionService.deleteProductOption(optionId);
		return ResponseEntity.noContent().build();
	}
	
	//특정상품 옵션조회 리스트라서 responseDTOs <- 복수형임
	@GetMapping("product/{productId}")
	public ResponseEntity<List<ProductOptionResponseDTO>> getProductOptionByProductId(@PathVariable Long productId){
		System.out.println("특정상품 옵션 호출");
		List<ProductOptionResponseDTO> responseDTOs = productOptionService.getProductOptionByProductId(productId);
		return ResponseEntity.ok(responseDTOs);
	}
	
}
