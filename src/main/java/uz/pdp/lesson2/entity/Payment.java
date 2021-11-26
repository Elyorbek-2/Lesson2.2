package uz.pdp.lesson2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @OneToOne
    private Order order;

    @OneToOne
    private User user;

    private boolean result;

    private Double totalSumm;

}
