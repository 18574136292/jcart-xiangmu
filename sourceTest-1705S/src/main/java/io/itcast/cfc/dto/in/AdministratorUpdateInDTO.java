package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AdministratorUpdateInDTO {

    private Integer administratorId;
    private String realName;
    private String password;
    private String email;
    private String avatarUrl;
    private Byte status;
}
