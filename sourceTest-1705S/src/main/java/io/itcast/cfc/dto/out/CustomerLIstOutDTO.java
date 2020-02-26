package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerLIstOutDTO {

    private Integer customerId;
    private String username;
    private String realName;
    private String Mobile;
    private String email;
    private Byte status;
    private Long createTimestamp;

}
