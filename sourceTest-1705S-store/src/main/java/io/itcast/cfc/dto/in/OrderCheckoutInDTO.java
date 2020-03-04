package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class OrderCheckoutInDTO {
    private Short shipMethod;
    private Integer shipAddressId;
    private Short payMethod;
    private Integer invoiceAddressId;
    private String comment;
    private List<OrderProductInDTO> orderProducts;
}
