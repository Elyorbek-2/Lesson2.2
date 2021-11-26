package uz.pdp.lesson2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private Integer id;

    private Integer orderId;

    private Integer userId;

    private boolean result;

    private Double totalSumm;
}
