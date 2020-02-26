package io.itcast.cfc.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnListOutDTO {

    private Integer returnId;
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private String productCode;
    private String productName;
    private Byte status;
    private Long createTimestamp;
    private Long updateTimestamp;
}
