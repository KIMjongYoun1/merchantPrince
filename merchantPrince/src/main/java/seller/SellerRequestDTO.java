package seller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerRequestDTO {
	
	@NotBlank(message = "셀러ID는 필수 입니다.")
	private String sellerId;
	
	@NotBlank(message = "셀러 비밀번호는 필수 입니다.")
	private String password;
	
	@NotBlank(message = "회사 이름는 필수 입니다.")
	private String companyName;
	
	@NotBlank(message = "회사 연락처 는 필수 입니다.")
	private String contactNumber;
	
	private String description;
}
