package productoption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOptionRequestDTO {
	
	private long productId;
	private String name;
	private String value;
	
}
