package Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	// 카테고리 생성
	public CategoryEntity createCategory(CategoryRequestDTO categoryRequestDTO) {
		CategoryEntity category = new CategoryEntity();
		category.setName(categoryRequestDTO.getName());
		return categoryRepository.save(category);
	}
	
	// 카테고리조회
	public CategoryEntity getCategory(Long id) {
		return categoryRepository.findById(id)
								 .orElseThrow(() -> new RuntimeException("카테고리를 찾을 수 없습니다."));
	}
	
}
