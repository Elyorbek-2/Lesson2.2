package uz.pdp.lesson2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @ManyToOne
    private Category category;

    @ManyToOne
    private Payment payment;

    @ManyToMany
    private List<Detail> detail;


    private Double salePrice;

    private Double incomePrice;


}
