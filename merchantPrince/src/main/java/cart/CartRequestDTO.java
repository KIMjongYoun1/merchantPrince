package cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDTO {
	
	/*
	 * 장바구니 NotNull 생략가능하나 검증을위해 추가함
	 * */
	
	
	@NotNull(message = "사용자ID는 필수 입니다.")
	private String userId;
	
	@NotNull(message = "상품 ID는 필수 입니다.")
	private Long productId;
	
	@Min(value = 1, message = "최소수량은 1개 이상입니다.")
	private int quantity;
	
}
