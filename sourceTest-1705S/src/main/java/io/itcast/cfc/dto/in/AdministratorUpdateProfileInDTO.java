package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AdministratorUpdateProfileInDTO {

    private String realName;
    private String email;
    private String avatarUrl;
}
