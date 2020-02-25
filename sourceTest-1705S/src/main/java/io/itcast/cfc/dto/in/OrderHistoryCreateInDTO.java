package io.itcast.cfc.dto.in;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OrderHistoryCreateInDTO {

    private Long orderId;
    private Byte orderStatus;
    private String comment;
    private Boolean customerNotified;
}
