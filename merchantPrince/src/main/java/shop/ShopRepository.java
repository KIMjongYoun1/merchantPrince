package shop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product.Product;

@Repository
public interface ShopRepository extends JpaRepository<Product, Long> {
	
	// 전체 상품 목록 조회
    public List<Product> findAll();
	
	//카테고리 검색
	public List<Product> findByCategoryId(Long categoryId);
	
	// 키워드검색
	public List<Product> findByNameContaining(String keyword);
	

}
