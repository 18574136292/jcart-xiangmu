package io.itcast.cfc.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AdministratorShowOutDTO {

    private Integer administratorId;
    private String username;
    private String email;
    private String avatarUrl;
    private Byte status;
}
