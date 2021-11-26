package uz.pdp.lesson2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2.entity.Measurement;

@Projection(types = Measurement.class)
public interface MeasurementProjection {

    Integer getId();

    String getName();

    boolean isActive();
}
