package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerRegisterInDTO {
    private String username;
    private String realName;
    private String email;
    private String mobile;
    private String password;
    private Boolean newsSubscribed;
}
