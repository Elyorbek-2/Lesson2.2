package uz.pdp.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson2.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
