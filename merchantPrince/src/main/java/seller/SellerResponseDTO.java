package seller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerResponseDTO {
	
	private Long sellerNum;
	private String sellerId;
	private String companyName;
	private String contactNumber;
	private String description;
	
	public SellerResponseDTO(Seller seller) {
		this.sellerNum = seller.getSellerNum();
		this.sellerId = seller.getSellerId();
		this.companyName = seller.getCompanyName();
		this.contactNumber = seller.getContactNumber();
		this.description = seller.getDescription(); // 선택사항임
	}
	
}
