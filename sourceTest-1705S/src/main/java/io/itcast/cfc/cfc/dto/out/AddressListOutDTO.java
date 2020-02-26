package io.itcast.cfc.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddressListOutDTO {

    private Integer addressId;
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
