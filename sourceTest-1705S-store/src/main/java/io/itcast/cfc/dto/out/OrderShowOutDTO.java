package io.itcast.cfc.dto.out;

import io.itcast.cfc.vo.OrderProductVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class OrderShowOutDTO {

    private Long orderId;
    private Byte status;
    private Double totalPrice;
    private Integer rewordPoints;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Short shipMethod;
    private String shipAddress;
    private Double shipPrice;
    private Short payMethod;
    private String invoiceAddress;
    private Double invoicePrice;
    private String comment;
    private List<OrderProductVO> orderProducts;
    private List<OrderHistoryListOutDTO> orderHistories;
}
