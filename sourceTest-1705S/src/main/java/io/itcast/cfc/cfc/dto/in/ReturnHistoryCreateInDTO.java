package io.itcast.cfc.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnHistoryCreateInDTO {

    private Integer returnId;
    private Byte returnStatus;
    private Boolean customerNotified;
    private String comment;

}
