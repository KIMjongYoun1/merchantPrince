package productoption;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOptionRequestDTO {
	
	private long productId;
	 @NotBlank(message = "옵션 이름은 필수입니다.")
	private String name;
	
	@NotBlank(message = "옵션 값은 필수입니다.")
	private String value;
	
}
