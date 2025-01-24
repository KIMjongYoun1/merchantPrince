package Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDTO {
	private Long categoryId;
	private String name;
	
	public CategoryResponseDTO(CategoryEntity category) {
		this.categoryId = category.getCategoryId();
		this.name = category.getName();
	}
}
