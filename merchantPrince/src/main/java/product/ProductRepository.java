package product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//전체 상품 목록 조회
	public List<Product> getAllproduct();
	
	//특정 판매자의 상품 조회
	public List<Product> findBySellerId(String sellerId);
	
	//특정 카테고리의 상품 조회
	public List<Product> findByCategory_CategoryId(Long categoryId);
	
	// 특정 셀러가 등록한 특정 상품 조회
	public Optional<Product> findBySellerIdAndProductId(String sellerId, Long productId);
	
	// 키워드검색
	public List<Product> findByNameContaining(String keyword);
		
	
}
