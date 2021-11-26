package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson2.entity.Detail;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
}
