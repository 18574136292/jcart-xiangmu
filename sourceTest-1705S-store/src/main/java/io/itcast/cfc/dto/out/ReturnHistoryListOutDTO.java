package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnHistoryListOutDTO {

    private Long timestamp;
    private Byte returnStatus;
    private String comment;
}
