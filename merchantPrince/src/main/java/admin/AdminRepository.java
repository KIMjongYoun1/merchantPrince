package admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product.Product;

@Repository
public interface AdminRepository extends JpaRepository<Product, Long>{

}
