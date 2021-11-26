package uz.pdp.lesson2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private String name;

    private Integer categoryId;

    private Integer paymentId;

    private Double salePrice;

    private Double incomePrice;
}
