package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressShowOutDTO {

    private Integer addressId;
    private String tag;
    private String receiverName;
    private String receiverMobile;
    private String content;
}
