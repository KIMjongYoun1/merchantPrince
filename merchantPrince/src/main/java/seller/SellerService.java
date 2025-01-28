package seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	// 셀러등록
	public SellerResponseDTO registerSeller(SellerRequestDTO sellerRequestDTO) {

	      if (sellerRepository.existsBySellerId(sellerRequestDTO.getSellerId())) {
	            throw new RuntimeException("아이디를 사용할 수 없습니다.");
	        }
	      
	      Seller seller = new Seller();
	      seller.setSellerId(sellerRequestDTO.getSellerId());
	      seller.setPassword(sellerRequestDTO.getPassword()); // 암호화처리해야함 스프링 시큐리티 JWT 도입을 해야함.. 어려움
	      seller.setCompanyName(sellerRequestDTO.getCompanyName());
	      seller.setContactNumber(sellerRequestDTO.getContactNumber());
	      seller.setDescription(sellerRequestDTO.getDescription());
	      
	      Seller savedSeller = sellerRepository.save(seller);
	      
	      return new SellerResponseDTO(savedSeller);
	      
	}
	
	// 셀러 조회
	public SellerResponseDTO getSeller(Long sellerNum) {
		Seller seller = sellerRepository.findById(sellerNum)
										.orElseThrow(() -> new RuntimeException("셀러를 찾을 수 없습니다."));
		
		return new SellerResponseDTO(seller);
	}
	
	// 셀러 로그인 - 유저 로그인로직 재사용
	public SellerResponseDTO login(SellerRequestDTO sellerRequestDTO, HttpSession session) {
		
		Seller seller = sellerRepository.findBySellerId(sellerRequestDTO.getSellerId())
										.orElseThrow(() -> new RuntimeException("셀러를 찾을 수 없습니다"));
		
		if (!seller.getPassword().equals(sellerRequestDTO.getPassword())) {
			throw new IllegalArgumentException("패스워드오류");
		}
		session.setAttribute("sellerId", seller.getSellerId());
		return new SellerResponseDTO(seller);
	}
	
	// 셀러 프로필조회 getSeller랑 다른목적 마이페이지
	public SellerResponseDTO getSellerProfile(HttpSession session) {
		String sellerId = (String) session.getAttribute("sellerId");
		if(sellerId == null) {
			throw new IllegalArgumentException("로그인 이 필요합니다");
		}
		
		Seller seller = sellerRepository.findBySellerId(sellerId)
												.orElseThrow(() -> new IllegalArgumentException("셀러를 찾을 수 없습니다."));
		
		return new SellerResponseDTO(seller);
	}
	
}
