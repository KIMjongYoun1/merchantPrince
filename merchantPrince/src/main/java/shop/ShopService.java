package shop;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Product;
import product.ProductRepository;

@Service
public class ShopService {

	@Autowired
	private ProductRepository productRepository;
	
	// 전체 상품 조회
	public List<ShopResponseDTO> getAllproducts(){
		
		List<Product> products = productRepository.findAll();
		return products.stream()
						.map(ShopResponseDTO::new)
						.collect(Collectors.toList());
		
	}
	
	//개별상품 조회
	public ShopResponseDTO getProduct(Long productId){
		Product product = productRepository.findById(productId)
								.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
		return new ShopResponseDTO(product);
	}
	
	//카테고리 상품별 조회
	public List<ShopResponseDTO> getProductsByCategory(Long categoryId){
		List<Product> products = productRepository.findByCategory_CategoryId(categoryId);
		return products.stream()
						.map(ShopResponseDTO::new)
						.collect(Collectors.toList());
	}
	// 키워드 검색
	public List<ShopResponseDTO> serchProducts(String keyword){
		List<Product> products = productRepository.findByNameContaining(keyword);
		return products.stream()
						.map(ShopResponseDTO::new)
						.collect(Collectors.toList());
	}
	
}
