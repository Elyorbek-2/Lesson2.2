package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson2.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
