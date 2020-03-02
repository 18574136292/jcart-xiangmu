package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AdministratorGetProfileOutDTO {

    private Integer administratorId;
    private String username;
    private String realName;
    private String email;
    private String avatarUrl;
    private Long createTimestamp;
}
