package admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Category.CategoryService;
import product.Product;
import product.ProductRequestDTO;
import product.ProductService;

@Service
public class AdminService {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	// 상품등록
	public Product createProduct(ProductRequestDTO productRequestDTO) {
		Product product = productService.createProduct(productRequestDTO);

		return productService.createProduct(productRequestDTO);

	}

	// 상품 수정
	public Product updateProduct(Long productId, ProductRequestDTO productRequestDTO) {
		Product product = productService.updateProduct(productId, productRequestDTO);

		return productService.updateProduct(productId, productRequestDTO);
	}

	// 상품 삭제
	public void deleteProduct(Long productId) {
		 productService.deleteProduct(productId);
	}

	// 등록상품조회
	public Product getProduct(Long productId) {
		return productService.getProduct(productId);
	}
	
	// 등록상품 전체조회
	public List<Product> getAllProduct(){
		return productService.getAllproduct();
	}

}
