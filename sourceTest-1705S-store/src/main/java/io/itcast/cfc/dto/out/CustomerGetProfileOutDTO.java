package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerGetProfileOutDTO {

    private Integer customerId;
    private String username;
    private String realName;
    private String mobile;
    private Boolean mobileVerified;
    private String email;
    private Boolean emailVerified;
}
