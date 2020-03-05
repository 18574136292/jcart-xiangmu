package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressShowOutDTO {
    private Integer addressId;
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
