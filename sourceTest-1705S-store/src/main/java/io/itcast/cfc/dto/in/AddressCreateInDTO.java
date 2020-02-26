package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddressCreateInDTO {
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
