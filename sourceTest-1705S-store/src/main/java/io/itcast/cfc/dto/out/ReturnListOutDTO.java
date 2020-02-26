package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnListOutDTO {

    private Integer returnId;
    private Byte status;
    private Long createTimestamp;
    private Long orderId;
    private Integer customerId;
    private String customerName;
}
