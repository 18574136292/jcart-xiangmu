package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnApplyInDTO {
    private Long orderId;
    private Long orderTimestamp;
    private String customerName;
    private String mobile;
    private String email;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private String comment;
}
