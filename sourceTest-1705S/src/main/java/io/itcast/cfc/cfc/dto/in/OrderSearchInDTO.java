package io.itcast.cfc.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OrderSearchInDTO {

    private Long orderId;
    private String customerName;
    private Byte status;
    private Double totalPrice;
}
