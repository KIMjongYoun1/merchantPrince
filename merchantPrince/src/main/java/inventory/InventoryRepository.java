package inventory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	//상품 아이디로 재고조회 추가매서드 필요할수 있음 옵셔널 임포트
	Optional<Inventory> findByProductProductId(Long productId);
}
