package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OrderHistoryListOutDTO {

    private Long orderHistoryId;
    private Long timestamp;
    private Byte orderStatus;
    private String comment;
    private Boolean customerNotified;
}
