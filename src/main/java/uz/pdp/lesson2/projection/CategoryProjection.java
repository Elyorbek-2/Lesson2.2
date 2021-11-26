package uz.pdp.lesson2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2.entity.Category;

@Projection(types = Category.class)
public interface CategoryProjection {
    String getName();
}
