package uz.pdp.lesson2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2.entity.User;

@Projection(types = User.class)
public interface UserProjection {
    Integer getId();
    String getUserName();
    String getPassword();
}
