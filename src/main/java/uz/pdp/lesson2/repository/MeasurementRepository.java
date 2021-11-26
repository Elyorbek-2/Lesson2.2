package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.lesson2.entity.Measurement;
import uz.pdp.lesson2.projection.MeasurementProjection;

@RepositoryRestResource(path = "measurement",excerptProjection = MeasurementProjection.class)
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
}
