package io.itcast.cfc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductVO {

    private Integer productId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Integer unitRewordPoints;
    private Integer totalRewordPoints;
}
