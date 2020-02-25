package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductSearchInDTO {

    private String productCode;
    private String productName;
    private Double price;
    private Integer stockQuantity;
    private Byte status;
}
