package io.itcast.cfc.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class OrderListOutDTO {

    private Long orderId;
    private Integer customerId;
    private String customerName;
    private Byte status;
    private Double totalPrice;
    @JsonIgnore
    private Date createTime;
    private Long createTimestamp;
    @JsonIgnore
    private Date updateTime;
    private Long updateTimestamp;
}
