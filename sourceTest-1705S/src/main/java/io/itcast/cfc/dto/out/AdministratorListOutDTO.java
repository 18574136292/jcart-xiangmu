package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AdministratorListOutDTO {

    private Integer administratorId;
    private String username;
    private String realName;
    private Byte status;
    private Long createTimestamp;
}
