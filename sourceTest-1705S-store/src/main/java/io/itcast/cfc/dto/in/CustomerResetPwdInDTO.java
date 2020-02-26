package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerResetPwdInDTO {
    private String email;
    private String resetCode;
    private String newPwd;
}
