package product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Category.CategoryEntity;
import productimage.ProductImage;
import productimage.ProductImageRepository;
import productoption.ProductOption;
import productoption.ProductOptionRepository;
import productoption.ProductOptionRequestDTO;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductOptionRepository productOptionRepository;
	
	@Autowired
	private ProductImageRepository productImageRepository;

	// 상품등록
	public Product createProduct(ProductRequestDTO productRequestDTO) {
		
		//상품 기본정보
		Product product = new Product();
		product.setName(productRequestDTO.getName());
		product.setDescription(productRequestDTO.getDescription());
		product.setPrice(productRequestDTO.getPrice());
		product.setStockQuantity(productRequestDTO.getStockQuantity());

		// 카테고리 설정
	    CategoryEntity categoryEntity = new CategoryEntity();  // Category -> CategoryEntity로 변경
	    categoryEntity.setCategoryId(productRequestDTO.getCategoryId());  // getCategoryId()로 수정
	    product.setCategory(categoryEntity);
	    
	    // 상품 옵션
	    List<ProductOption> productOptions = new ArrayList<>();
	    for(ProductOptionRequestDTO optionDTO : productRequestDTO.getOptions()){
	    	ProductOption option = new ProductOption();
	    	option.setName(optionDTO.getName());
	    	option.setValue(optionDTO.getValue());
	    	option.setProduct(product); // 상품과 연계 부분임
	    	productOptions.add(option);
	    }
	    product.setProductOptions(productOptions);
	    
	    // 상품 이미지 설정
	    if (productRequestDTO.getImageUrls() != null) {
	    	List<ProductImage> productImages = new ArrayList<>();
	    	for (String imageUrl : productRequestDTO.getImageUrls()) {
	    		ProductImage productImage = new ProductImage();
	    		productImage.setProduct(product);
	    		productImage.setImageUrl(imageUrl);
	    		productImages.add(productImage);
	    	}
	    	product.setProductImages(productImages); // if문 안에있어야함 for문 직후에있어야함 외부로나가면 접근불가함
	    }
	    
	    return productRepository.save(product);  // prduct 오타 수정
	}
	
	// 상품 수정 - 상품 추가에서 구문수정
	public Product updateProduct(Long productId, ProductRequestDTO productRequestDTO) {
	    // 1. 기존 상품을 찾음
	    Product product = productRepository.findById(productId)
	            .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
	    
	    // 2. 기존 상품 정보 수정
	    product.setName(productRequestDTO.getName());
	    product.setDescription(productRequestDTO.getDescription());
	    product.setPrice(productRequestDTO.getPrice());
	    product.setStockQuantity(productRequestDTO.getStockQuantity());
	    
	    // 3. 카테고리 수정 (기존처럼)
	    CategoryEntity categoryEntity = new CategoryEntity();
	    categoryEntity.setCategoryId(productRequestDTO.getCategoryId());
	    product.setCategory(categoryEntity);
	    
	    // 4. 상품 옵션 수정 (기존처럼)
	    List<ProductOption> updatedOptions = new ArrayList<>();
	    for (ProductOptionRequestDTO optionDTO : productRequestDTO.getOptions()) {
	        ProductOption option = new ProductOption();
	        option.setName(optionDTO.getName());
	        option.setValue(optionDTO.getValue());
	        option.setProduct(product);
	        updatedOptions.add(option);
	    }
	    product.setProductOptions(updatedOptions);
	    
	    // 5. 상품 이미지 수정 (기존처럼)
	    if (productRequestDTO.getImageUrls() != null) {
	        List<ProductImage> updatedImages = new ArrayList<>();
	        for (String imageUrl : productRequestDTO.getImageUrls()) {
	            ProductImage productImage = new ProductImage();
	            productImage.setProduct(product);
	            productImage.setImageUrl(imageUrl);
	            updatedImages.add(productImage);
	        }
	        product.setProductImages(updatedImages);
	    }
	    
	    // 6. 수정된 상품 저장
	    return productRepository.save(product);
	}


	// 상품 조회
	public Product getProduct(Long id) {
	    return productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));  // 상품 조회
	}
	
	// 상품 삭제
	public void deleteProduct(Long productId) {
		Product product = productRepository.findById(productId)
											.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
		productRepository.delete(product);
	}

}
