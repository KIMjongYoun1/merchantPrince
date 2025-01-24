package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Category.CategoryEntity;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// 상품등록
	public Product createProduct(ProductRequestDTO productRequestDTO) {
		Product product = new Product();
		product.setName(productRequestDTO.getName());
		product.setDescription(productRequestDTO.getDescription());
		product.setPrice(productRequestDTO.getPrice());
		product.setStockQuantity(productRequestDTO.getStockQuantity());

		// 카테고리 설정
	    CategoryEntity categoryEntity = new CategoryEntity();  // Category -> CategoryEntity로 변경
	    categoryEntity.setCategoryId(productRequestDTO.getCategoryId());  // getCategoryId()로 수정
	    product.setCategory(categoryEntity);
	    
	    return productRepository.save(product);  // prduct 오타 수정
	}

	// 상품 조회
	public Product getProduct(Long id) {
	    return productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));  // 상품 조회
	}

}
