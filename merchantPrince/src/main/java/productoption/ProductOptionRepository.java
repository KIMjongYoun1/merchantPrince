package productoption;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
	// 목록조회 이후 추가 매서드 추가필요
	List<ProductOption> findByProductProductID(Long productId);
}
