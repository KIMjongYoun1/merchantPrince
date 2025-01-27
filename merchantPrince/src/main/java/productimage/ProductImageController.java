package productimage;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/porduct-image")
public class ProductImageController {

	@Autowired
	private ProductImageService productImageService;

	@PostMapping("/{productId}") // 이미지추가
	public ResponseEntity<ProductImageResponseDTO> addProductImage(@PathVariable Long productId,
			@RequestBody ProductImageRequestDTO requestDTO) {
		System.out.println("이미지추가 api 호출");
		requestDTO.setProductId(productId);
		ProductImageResponseDTO productImageResponseDTO = productImageService.addProductImage(requestDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(productImageResponseDTO);

	}

	@PutMapping("/{iamgeId}") // 이미지 수정 DTO 관련해서 서비스로직에도 DTO로 받을수있도록해야함 임의 인자설정 안됨 ex) string 0000
	public ResponseEntity<ProductImageResponseDTO> updateProductImage(@PathVariable Long imageId,
			@RequestBody ProductImageRequestDTO requestDTO) {
		System.out.println("이미지수정 api 호출");
		ProductImageResponseDTO productImageResponseDTO = productImageService.updateProductImage(imageId, requestDTO);

		return ResponseEntity.ok(productImageResponseDTO);

	}
	
	@GetMapping("/product/{productId}") // 이미조회 여러개일수있음 리스트로 
	public ResponseEntity<List<ProductImageResponseDTO>> getProductImageByProductId(@PathVariable Long productId){
		System.out.println("이미지 조회  api 호출");
		List<ProductImageResponseDTO> productImages = productImageService.getImageProductId(productId);
		return ResponseEntity.ok(productImages);
	}
	
	@DeleteMapping("/{imageId}")
	public ResponseEntity<Void> deleteProductImage(@PathVariable Long imageId){
		System.out.println("이미지 삭제  api 호출");
		productImageService.deleteImage(imageId);
		return ResponseEntity.noContent().build();
	}
	

}
