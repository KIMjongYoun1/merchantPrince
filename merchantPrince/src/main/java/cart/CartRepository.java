package cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	// 특정 유저의 장바구니 조회
	public List<Cart> findByUserId(String userId);
	
	//특정 유저의 장바구니에 특정 상품이 있는지 확인
	public Optional<Cart> findByUserIdAndProductId(String userId, Long productId );
	
	//자동제공 되야하나 제공되지않아 명시적으로 작성
	public Optional<Cart> findById(Long cartId);
	
	
}
