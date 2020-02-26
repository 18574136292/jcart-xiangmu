package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AdministratorCreateInDTO {

    private String username;
    private String password;
    private String realName;
    private String email;
    private String avatarUrl;
    private Byte status;

}
