package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OrderListOutDTO {

    private Long orderId;
    private Integer customerId;
    private String customerName;
    private Integer totalProducts;
    private Byte status;
    private Double totalPrice;
    private Long createTimestamp;
}
