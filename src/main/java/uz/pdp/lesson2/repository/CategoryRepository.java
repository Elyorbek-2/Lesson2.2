package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.lesson2.entity.Category;
import uz.pdp.lesson2.projection.CategoryProjection;

@RepositoryRestResource(path = "category",excerptProjection = CategoryProjection.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
