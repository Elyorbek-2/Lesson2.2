package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson2.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
