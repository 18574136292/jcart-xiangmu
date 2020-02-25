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
    private Byte status;
    private Double totalPirce;
    private Long createTimestamp;
    private Long updateTimestamp;
}
