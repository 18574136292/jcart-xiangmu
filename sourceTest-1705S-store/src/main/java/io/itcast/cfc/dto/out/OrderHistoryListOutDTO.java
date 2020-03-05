package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHistoryListOutDTO {

    private Long timestamp;
    private Byte orderStatus;
    private String comment;
}
