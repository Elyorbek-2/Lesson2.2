package uz.pdp.lesson2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto {

    private String name;

    private boolean active;

    private Integer measurementId;

    private Integer amount;
}
