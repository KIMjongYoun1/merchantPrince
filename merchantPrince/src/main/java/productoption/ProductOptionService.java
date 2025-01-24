package productoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Product;
import product.ProductRepository;

@Service
public class ProductOptionService {
	
	@Autowired
	private ProductOptionRepository productOptionRepository;
	
	 @Autowired
	 private ProductRepository productRepository;
	
	// 상품 옵션추가
	public ProductOption addProductOption(ProductOptionRequestDTO requestDTO) {
		ProductOption productOption = new ProductOption();
		
		Product product = productRepository.findById(requestDTO.getProductId())
										   .orElseThrow(() -> new RuntimeException("상품을 찾을수 없습니다."));
		
		productOption.setProduct(product);
		productOption.setName(requestDTO.getName());
		productOption.setValue(requestDTO.getValue());
		
		return productOptionRepository.save(productOption);
		
	}
	
	// 상품 옵션 조회 (단일 옵션임)
	public ProductOptionResponseDTO getProductOption(Long optionId) {
			
			ProductOption productOption = productOptionRepository.findById(optionId)
										.orElseThrow(() -> new RuntimeException("상품 옵션을 찾을 수 없습니다."));
			return new ProductOptionResponseDTO(productOption);
		
	}
	
	// 상품 옵션 수정
	public ProductOptionResponseDTO updateProductOption(Long optionId, ProductOptionRequestDTO requestDTO) {
		
			ProductOption productOption = productOptionRepository.findById(optionId)
										.orElseThrow(() -> new RuntimeException("상품 옵션을 찾을 수 없습니다."));
			
			productOption.setName(requestDTO.getName());
			productOption.setValue(requestDTO.getValue());
			productOptionRepository.save(productOption);
			return new ProductOptionResponseDTO(productOption);
	}
	
	// 상품 옵션 삭제
	public void deleteProductOption(Long optionId) {
		ProductOption productOption = productOptionRepository.findById(optionId)
				.orElseThrow(() -> new RuntimeException("상품 옵션을 찾을 수 없습니다."));
		
		productOptionRepository.delete(productOption);
	}
	
	// 특정 상품의 모든 옵션 조회
	public List<ProductOptionResponseDTO> getProductOptionByProductId(Long porductId){
		List<ProductOption> productOption = productOptionRepository.findByProductProductID(porductId);
		return productOption.stream()
							.map(ProductOptionResponseDTO::new)
							.toList();
	}
	
}
