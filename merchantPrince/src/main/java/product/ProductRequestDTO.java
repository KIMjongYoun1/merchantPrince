package product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	
	@NotBlank(message = "상품이름은 필수 입니다.")
	private String name;
	
	private String description;
	
	@Positive(message = "가격은 0원 이상입니다.")
	private int price;
	
	@Positive(message = "재고수량은 0보다 커야합니다.")
	private int stockQuantity;
	
	private Long categoryId;
	
	
	
}
