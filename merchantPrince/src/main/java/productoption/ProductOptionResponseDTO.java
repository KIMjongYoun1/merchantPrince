package productoption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOptionResponseDTO {
	
	private Long optionId;
	private String name;
	private String value;
	
	// 앤티티 객체를 이용해서 DTO 객체생성 모든 리스폰 DTO 동일개념
	public ProductOptionResponseDTO(ProductOption productOption) {
		this.optionId = productOption.getOptionId();
		this.name = productOption.getName();
		this.value = productOption.getValue();
		
	}
	
}
