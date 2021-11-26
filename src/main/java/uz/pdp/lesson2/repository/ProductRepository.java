package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson2.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
