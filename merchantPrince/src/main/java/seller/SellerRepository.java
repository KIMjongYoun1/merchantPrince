package seller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
	// 매서드 추가해줘야 서비스단에서 중복 검사 로직 사용가능함 long 타입의 매서드만 제공하기때문에 필요한 타입 매서드는 추가해야함
	boolean existsBySellerId(String serllerId);
	
	// 이매서드 없으면 자동으로 long타입 반환으로 오류남 아이디는 STring 임
	Optional<Seller> findBySellerId(String sellerId);
}
