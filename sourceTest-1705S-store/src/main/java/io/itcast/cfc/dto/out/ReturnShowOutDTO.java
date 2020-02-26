package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ReturnShowOutDTO {

    private Integer returnId;
    private Integer orderId;
    private Long orderTimestamp;
    private String customerName;
    private String mobile;
    private String email;
    private Byte status;
    private Byte action;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private String comment;
    private Long createTimestamp;
    private Long updateTimestamp;

    private List<ReturnHistoryListOutDTO> returnHistories;
}
